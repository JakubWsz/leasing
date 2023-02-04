package com.crc.leasing.api.dto.client;

import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClientRequest {
    @NotNull(message = "Pole z identyfikatorem nie może być puste.")
    @NotEmpty(message = "Pole z identyfikatorem nie może być puste.")
    @NotBlank(message = "Pole z identyfikatorem nie może być puste.")
    String uuid;
    @NotNull(message = "Pole z imieniem nie może być puste.")
    @NotEmpty(message = "Pole z imieniem nie może być puste.")
    @NotBlank(message = "Pole z imieniem nie może być puste.")
    String firstname;
    @NotNull(message = "Pole z nazwiskiem nie może być puste.")
    @NotEmpty(message = "Pole z nazwiskiem nie może być puste.")
    @NotBlank(message = "Pole z nazwiskiem nie może być puste.")
    String lastname;
    @NotNull(message = "Pole z e-mailem nie może być puste.")
    @NotEmpty(message = "Pole z e-mailem nie może być puste.")
    @NotBlank(message = "Pole z e-mailem nie może być puste.")
    @Email(message = "Adres email jest niepoprawny")
    String email;
    @NotNull(message = "Pole z datą urodzenia nie może być psute.")
    LocalDate birthdate;
}
