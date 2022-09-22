package com.ketch.events.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.Map;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown=true)
public class Callback {
    @NonNull @NotBlank String url;
    Map<String, String> headers;
}
