package com.crc.leasing.domain.model.employee;

import com.crc.leasing.domain.model.Address;
import com.crc.leasing.domain.model.office.Office;
import com.crc.leasing.infrastructure.database.jpa.employee.entity.ContractType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@AllArgsConstructor
@Builder
@Getter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee {
    final String uuid;
    final String firstname;
    final String lastname;
    final Address address;
    final String pesel;
    final String accountNumber;
    final BigDecimal salaryAmount;
    final ContractType contractType;
    final String position;
    final Office office;
    private boolean deleted;

    public boolean isDeleted() {
        return deleted;
    }

    public void markAsDeleted() {
        deleted = true;
    }
}
