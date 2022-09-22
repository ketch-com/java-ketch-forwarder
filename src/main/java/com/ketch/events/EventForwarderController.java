package com.ketch.events;

import com.ketch.events.types.*;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.stream.Collectors;

@RestController
public class EventForwarderController {
    @Autowired
    Validator validator;

    @Autowired
    EventService handler;

    @PostMapping("/ketch/endpoint")
    public ResponseEntity<Response> handleRequest(@RequestBody Request request) throws MetadataException {
        val validationResults = validator.validate(request);
        if (!validationResults.isEmpty()) {
            val messages = validationResults.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
            return makeError(HttpStatus.BAD_REQUEST, request.getApiVersion(), request.getMetadata(), String.join(";", messages));
        }

        try {
            val response = handler.handle(request);

            return ResponseEntity
                    .ok()
                    .body(
                            Response
                                    .builder()
                                    .apiVersion(request.getApiVersion())
                                    .kind(ResponseKind.forRequestKind(request.getKind()))
                                    .metadata(request.getMetadata())
                                    .response(response)
                                    .build()
                    );
        } catch (Exception e) {
            throw new MetadataException(request.getMetadata(), e.toString());
        }
    }

    @ExceptionHandler(MetadataException.class)
    ResponseEntity<Response> handleMetadataException(MetadataException e) {
        return makeError(HttpStatus.SERVICE_UNAVAILABLE, ApiVersion.V1, e.getMetadata(), e.getMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<Response> handleConstraintViolationException(ConstraintViolationException e) {
        return makeError(HttpStatus.BAD_REQUEST, ApiVersion.V1, new Metadata("", ""), e.getMessage());
    }

    private ResponseEntity<Response> makeError(HttpStatus status, ApiVersion apiVersion, Metadata metadata, String message) {
        return ResponseEntity
                .status(status)
                .body(
                        Response
                                .builder()
                                .apiVersion(apiVersion)
                                .kind(ResponseKind.Error)
                                .metadata(metadata)
                                .error(new ErrorBody(status.value(), status == HttpStatus.BAD_REQUEST ? "bad_request" : "unavailable", message))
                                .build()
                );
    }
}
