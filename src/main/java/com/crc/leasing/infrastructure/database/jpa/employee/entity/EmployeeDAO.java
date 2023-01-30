package com.crc.leasing.infrastructure.database.jpa.employee.entity;

import com.crc.leasing.domain.model.Address;
import com.crc.leasing.infrastructure.database.jpa.BaseEntity;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeDAO extends BaseEntity {
    String firstname;
    String lastname;
    @Embedded
    Address address;
    String pesel;
    String accountNumber;
    BigDecimal salaryAmount;
    @Enumerated(EnumType.STRING)
    ContractType contractType;
    String position;
    String officeId;

    public EmployeeDAO(String firstname, String lastname, Address address,
                       String pesel, String accountNumber, BigDecimal salaryAmount, ContractType contractType,
                       String position, String officeId, boolean deleted) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.pesel = pesel;
        this.accountNumber = accountNumber;
        this.salaryAmount = salaryAmount;
        this.contractType = contractType;
        this.position = position;
        this.officeId = officeId;
        this.setDeleted(deleted);
    }
}

