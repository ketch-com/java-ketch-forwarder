package com.ketch.events.types;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public enum RequestKind {
    @JsonProperty("AccessRequest") Access,
    @JsonProperty("CorrectionRequest") Correction,
    @JsonProperty("DeleteRequest") Delete,
    @JsonProperty("RestrictProcessingRequest") RestrictProcessing;
}
