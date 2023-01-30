package com.crc.leasing.api.dto.client;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ClientResponse(@NotNull @NotEmpty @NotBlank String id, @NotNull @NotEmpty @NotBlank String firstname,
                             @NotNull @NotEmpty @NotBlank String lastname, @NotNull @NotEmpty @NotBlank String email,
                             @NotNull LocalDate birthdate) {
}
