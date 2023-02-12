package com.crc.leasing.infrastructure.database.jpa.employee.entity;

import com.crc.leasing.infrastructure.database.jpa.AddressDAO;
import com.crc.leasing.infrastructure.database.jpa.BaseEntity;
import com.crc.leasing.infrastructure.database.jpa.office.entity.OfficeDAO;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Entity
@Table(name = "employee")
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeDAO extends BaseEntity {
    @Column(name = "firstname")
    String firstname;
    @Column(name = "lastname")
    String lastname;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "address_dao_id")
    AddressDAO addressDAO;
    @Column(name = "pesel")
    String pesel;
    @Column(name = "account_number")
    String accountNumber;
    @Column(name = "salary_amount")
    BigDecimal salaryAmount;
    @Enumerated(EnumType.STRING)
    @Column(name = "contract_type")
    ContractType contractType;
    @Column(name = "position")
    String position;
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "office_dao_id")
    OfficeDAO officeDAO;

    public EmployeeDAO(String firstname, String lastname, AddressDAO addressDAO,
                       String pesel, String accountNumber, BigDecimal salaryAmount, ContractType contractType,
                       String position, OfficeDAO officeDAO, boolean deleted, String uuid) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.addressDAO = addressDAO;
        this.pesel = pesel;
        this.accountNumber = accountNumber;
        this.salaryAmount = salaryAmount;
        this.contractType = contractType;
        this.position = position;
        this.officeDAO = officeDAO;
        this.setDeleted(deleted);
        super.uuid = uuid;
    }

    public void setUuid(String uuid) {
        super.setUuid(uuid);
    }
}

