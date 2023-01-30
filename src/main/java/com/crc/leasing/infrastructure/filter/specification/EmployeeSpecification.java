package com.crc.leasing.infrastructure.filter.specification;

import com.crc.leasing.api.dto.AddressDto;
import com.crc.leasing.infrastructure.database.jpa.employee.entity.ContractType;
import com.crc.leasing.infrastructure.database.jpa.employee.entity.EmployeeDAO;
import com.crc.leasing.infrastructure.filter.FilterPredicateBuilder;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

@Setter
public class EmployeeSpecification implements Specification<EmployeeDAO> {
    private static final String FIRSTNAME = "firstname";
    private static final String LASTNAME = "lastname";
    private static final String ADDRESS_DTO = "addressDTO";
    private static final String PESEL = "pesel";
    private static final String ACCOUNT_NUMBER = "accountNumber";
    private static final String SALARY_AMOUNT = "salaryAmount";
    private static final String CONTRACT_TYPE = "contractType";
    private static final String POSITION = "position";
    private static final String OFFICE_ID = "officeId";
    private static final String DELETED = "deleted";

    private String firstname;
    private String lastname;
    private AddressDto addressDTO;
    private String pesel;
    private String accountNumber;
    private BigDecimal salaryAmount;
    private ContractType contractType;
    private String position;
    private String officeId;

    @Override
    public Predicate toPredicate(Root<EmployeeDAO> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return FilterPredicateBuilder.create(criteriaBuilder, root)
                .equal(FIRSTNAME, firstname)
                .equal(LASTNAME, lastname)
                .equal(ADDRESS_DTO, addressDTO)
                .equal(PESEL, pesel)
                .equal(ACCOUNT_NUMBER, accountNumber)
                .equal(SALARY_AMOUNT, salaryAmount)
                .equal(CONTRACT_TYPE, contractType)
                .equal(POSITION, position)
                .equal(OFFICE_ID, officeId)
                .equal(DELETED, false)
                .toPredicate();
    }
}
