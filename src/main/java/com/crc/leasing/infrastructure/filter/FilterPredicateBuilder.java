package com.crc.leasing.infrastructure.filter;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.List;

public class FilterPredicateBuilder {
    private final CriteriaBuilder builder;
    private final Root root;
    private final List<Predicate> predicates = new ArrayList<>();

    public FilterPredicateBuilder(CriteriaBuilder builder, Root root) {
        this.builder = builder;
        this.root = root;
    }

    public static FilterPredicateBuilder create(CriteriaBuilder criteriaBuilder, Root root) {
        return new FilterPredicateBuilder(criteriaBuilder, root);
    }

    public FilterPredicateBuilder equal(String field, Object value) {
        if (value != null) {
            predicates.add(builder.equal(root.get(field), value));
        }
        return this;
    }

    public Predicate toPredicate() {
        return builder.and(predicates.toArray(Predicate[]::new));
    }
}