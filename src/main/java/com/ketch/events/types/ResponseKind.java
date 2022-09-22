package com.ketch.events.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ResponseKind {
    @JsonProperty("Error") Error,
    @JsonProperty("AccessResponse") Access,
    @JsonProperty("CorrectionResponse") Correction,
    @JsonProperty("DeleteResponse") Delete,
    @JsonProperty("RestrictProcessingResponse") RestrictProcessing;

    public static ResponseKind forRequestKind(RequestKind kind) {
        return switch (kind) {
            case Access -> ResponseKind.Access;
            case Delete -> ResponseKind.Delete;
            case Correction -> ResponseKind.Correction;
            case RestrictProcessing -> ResponseKind.RestrictProcessing;
            default -> ResponseKind.Error;
        };
    }
}
