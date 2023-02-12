package com.crc.leasing.api.dto.client;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClientResponse {
    @NotNull @NotEmpty @NotBlank
    String uuid;
    @NotNull @NotEmpty @NotBlank
    String firstname;
    @NotNull @NotEmpty @NotBlank
    String lastname;
    @NotNull @NotEmpty @NotBlank
    String email;
    @NotNull
    LocalDate birthdate;
}
