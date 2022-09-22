package com.ketch.events.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum RequestStatus {
    @JsonProperty("unknown") Unknown,
    @JsonProperty("pending") Pending,
    @JsonProperty("in_progress") InProgress,
    @JsonProperty("completed") Completed,
    @JsonProperty("cancelled") Cancelled,
    @JsonProperty("denied") Denied;
}
