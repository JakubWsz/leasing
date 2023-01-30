package com.crc.leasing.api.dto.employee;

import com.crc.leasing.api.dto.AddressDto;
import com.crc.leasing.infrastructure.database.jpa.employee.entity.ContractType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record EmployeeResponse(@NotNull @NotEmpty @NotBlank String id, @NotNull @NotEmpty @NotBlank String firstname,
                               @NotNull @NotEmpty @NotBlank String lastname, @NotNull AddressDto address,
                               @NotNull @NotEmpty @NotBlank String pesel,
                               @NotNull @NotEmpty @NotBlank @Size(min = 26, max = 26) String accountNumber,
                               @NotNull BigDecimal salaryAmount, @NotNull ContractType contractType,
                               @NotNull @NotEmpty @NotBlank String position, @NotNull @NotEmpty @NotBlank String officeId) {
}
