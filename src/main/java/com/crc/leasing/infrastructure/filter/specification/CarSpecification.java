package com.crc.leasing.infrastructure.filter.specification;

import com.crc.leasing.infrastructure.database.jpa.car.entity.*;
import com.crc.leasing.infrastructure.filter.FilterPredicateBuilder;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;

@Setter
public class CarSpecification implements Specification<CarDAO> {
    private static final String BRAND = "brand";
    private static final String MODEL = "model";
    private static final String CAR_TYPE = "carType";
    private static final String FUEL_TYPE = "fuelType";
    private static final String GEARBOX_TYPE = "gearboxType";
    private static final String DOOR_NUMBER = "doorNumber";
    private static final String BOOT_CAPACITY = "bootCapacity";
    private static final String OFFICE_ID = "officeId";
    private static final String DELETED = "deleted";
    private String brand;
    private String model;
    private CarType carType;
    private FuelType fuelType;
    private GearboxType gearboxType;
    private DoorNumber doorNumber;
    private Double bootCapacity;
    private String officeId;

    @Nullable
    @Override
    public Predicate toPredicate(Root<CarDAO> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return FilterPredicateBuilder.create(criteriaBuilder, root)
                .equal(BRAND, brand)
                .equal(MODEL, model)
                .equal(CAR_TYPE, carType)
                .equal(FUEL_TYPE, fuelType)
                .equal(GEARBOX_TYPE, gearboxType)
                .equal(DOOR_NUMBER, doorNumber)
                .equal(BOOT_CAPACITY, bootCapacity)
                .equal(OFFICE_ID, officeId)
                .equal(DELETED, false)
                .toPredicate();
    }
}
