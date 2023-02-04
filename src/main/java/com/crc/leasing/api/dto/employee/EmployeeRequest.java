package com.crc.leasing.api.dto.employee;

import com.crc.leasing.api.dto.AddressDto;
import com.crc.leasing.infrastructure.database.jpa.employee.entity.ContractType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeRequest {
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
    @NotNull(message = "Adres nie może być pusty.")
    @Valid
    AddressDto addressDto;
    @NotNull(message = "Pole z peselem nie może być puste.")
    @NotEmpty(message = "Pole z peselem nie może być puste.")
    @NotBlank(message = "Pole z peselem nie może być puste.")
    String pesel;
    @NotNull(message = "Pole z numerem konta nie może być puste.")
    @NotEmpty(message = "Pole z numerem konta nie może być puste.")
    @NotBlank(message = "Pole z numerem konta nie może być puste.")
    @Size(min = 26, max = 26, message = "Numer konta jest niepoprawny")
    String accountNumber;
    @NotNull(message = "Pole z kwotą pensji nie może być puste.")
    BigDecimal salaryAmount;
    @NotNull(message = "Pole z typem umowy nie może być puste.")
    ContractType contractType;
    @NotNull(message = "Pole ze stanowiskiem nie może być puste.")
    @NotEmpty(message = "Pole ze stanowiskiem nie może być puste.")
    @NotBlank(message = "Pole ze stanowiskiem nie może być puste.")
    String position;
    @NotNull(message = "Pole z identyfikatorem biura nie może być puste.")
    @NotEmpty(message = "Pole z identyfikatorem biura nie może być puste.")
    @NotBlank(message = "Pole z identyfikatorem biura nie może być puste.")
    String officeId;
}
