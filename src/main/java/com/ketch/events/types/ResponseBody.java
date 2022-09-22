package com.ketch.events.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown=true)
public class ResponseBody {
    @NonNull RequestStatus status;
    RequestStatusReason reason;
    int expectedCompletionTimestamp;
//    String redirectUrl;
    List<Callback> results;
    String requestID;
}
