package com.ketch.events.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum EventKind {
    @JsonProperty("AccessStatusEvent") Access,
    @JsonProperty("CorrectionStatusEvent") Correction,
    @JsonProperty("DeleteStatusEvent") Delete,
    @JsonProperty("RestrictProcessingStatusEvent") RestrictProcessing;
}
