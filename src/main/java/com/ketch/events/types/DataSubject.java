package com.ketch.events.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown=true)
public class DataSubject {
    @NonNull @NotBlank @Email String email;
    @NonNull @NotBlank String firstName;
    @NonNull @NotBlank String lastName;
    String phone;
    String addressLine1;
    String addressLine2;
    String city;
    String stateRegionCode;
    String postalCode;
    String countryCode;
    String description;
}
