package com.ketch.events.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown=true)
public class RequestBody {
    String controller;
    @NonNull @NotBlank String property;
    @NonNull @NotBlank String environment;
    @NonNull @NotBlank String regulation;
    @NonNull @NotBlank String jurisdiction;
    List<String> purposes;
    List<Identity> identities;
    List<Callback> callbacks;
    @NonNull DataSubject subject;
    Map<String, String> claims;
    int submittedTimestamp;
    int dueTimestamp;
}
