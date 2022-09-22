package com.ketch.events.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown=true)
public class Request {
    @NonNull ApiVersion apiVersion;
    @NonNull RequestKind kind;
    @NonNull Metadata metadata;
    @NonNull RequestBody request;
}
