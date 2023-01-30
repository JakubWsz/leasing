package com.crc.leasing.infrastructure.filter.specification;

import com.crc.leasing.api.dto.AddressDto;
import com.crc.leasing.infrastructure.database.jpa.office.entity.OfficeDAO;
import com.crc.leasing.infrastructure.filter.FilterPredicateBuilder;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

@Setter
public class OfficeSpecification implements Specification<OfficeDAO> {
    private static final String ADDRESS_DTO = "addressDto";
    private static final String WEBSITE_URL = "websiteUrl";
    private static final String OFFICE_CEO = "officeCeo";
    private static final String DELETED = "deleted";

    private AddressDto addressDto;
    private String websiteUrl;
    private String officeCeo;

    @Override
    public Predicate toPredicate(Root<OfficeDAO> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return FilterPredicateBuilder.create(criteriaBuilder, root)
                .equal(ADDRESS_DTO, addressDto)
                .equal(WEBSITE_URL, websiteUrl)
                .equal(OFFICE_CEO, officeCeo)
                .equal(DELETED, false)
                .toPredicate();
    }
}
