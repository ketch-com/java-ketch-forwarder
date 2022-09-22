package com.ketch.events.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown=true)
public class Response {
    @NonNull ApiVersion apiVersion;
    @NonNull ResponseKind kind;
    @NonNull Metadata metadata;
    ResponseBody response;
    ErrorBody error;
}
