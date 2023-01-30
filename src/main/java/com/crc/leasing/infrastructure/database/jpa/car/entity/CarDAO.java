package com.crc.leasing.infrastructure.database.jpa.car.entity;

import com.crc.leasing.infrastructure.database.jpa.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@NoArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CarDAO extends BaseEntity {
    String brand;
    String model;
    @Enumerated(EnumType.STRING)
    CarType carType;
    @Enumerated(EnumType.STRING)
    FuelType fuelType;
    @Enumerated(EnumType.STRING)
    GearboxType gearboxType;
    @Enumerated(EnumType.STRING)
    DoorNumber doorNumber;
    Double bootCapacity;
    String officeId;

    public CarDAO(String brand, String model, CarType carType, FuelType fuelType,
                  GearboxType gearboxType, DoorNumber doorNumber, Double bootCapacity, String officeId,
                  boolean deleted) {
        this.brand = brand;
        this.model = model;
        this.carType = carType;
        this.fuelType = fuelType;
        this.gearboxType = gearboxType;
        this.doorNumber = doorNumber;
        this.bootCapacity = bootCapacity;
        this.officeId = officeId;
        this.setDeleted(deleted);
    }
}
