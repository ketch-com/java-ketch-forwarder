package com.ketch.events;

import com.ketch.events.types.Metadata;
import lombok.Getter;

public class MetadataException extends Exception {
    @Getter Metadata metadata;

    public MetadataException(Metadata metadata, String message) {
        this(message, null);
        this.metadata = metadata;
    }

    public MetadataException() {
        this("", null);
        this.metadata = null;
    }

    public MetadataException(String message) {
        this(message, null);
        this.metadata = null;
    }

    public MetadataException(Throwable cause) {
        this(cause != null ? cause.getMessage() : null, cause);
        this.metadata = null;
    }

    public MetadataException(String message, Throwable cause) {
        super(message);
        if (cause != null) super.initCause(cause);
    }
}
