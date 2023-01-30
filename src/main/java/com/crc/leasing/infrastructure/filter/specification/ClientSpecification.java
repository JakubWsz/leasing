package com.crc.leasing.infrastructure.filter.specification;

import com.crc.leasing.infrastructure.database.jpa.client.entity.ClientDAO;
import com.crc.leasing.infrastructure.filter.FilterPredicateBuilder;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

@Setter
public class ClientSpecification implements Specification<ClientDAO> {
    private static final String FIRSTNAME = "firstname";
    private static final String LASTNAME = "lastname";
    private static final String EMAIL = "email";
    private static final String BIRTHDATE = "birthdate";

    private String firstname;
    private String lastname;
    private String email;
    private LocalDate birthdate;

    @Override
    public Predicate toPredicate(Root<ClientDAO> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return FilterPredicateBuilder.create(criteriaBuilder, root)
                .equal(FIRSTNAME, firstname)
                .equal(LASTNAME, lastname)
                .equal(EMAIL, email)
                .equal(BIRTHDATE, birthdate)
                .toPredicate();
    }
}
