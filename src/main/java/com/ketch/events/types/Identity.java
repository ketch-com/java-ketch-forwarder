package com.ketch.events.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown=true)
public class Identity {
    @NonNull @NotBlank String identitySpace;
    String identityFormat;
    @NonNull @NotBlank String identityValue;
}
