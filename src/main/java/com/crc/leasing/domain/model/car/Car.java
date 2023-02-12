package com.crc.leasing.domain.model.car;

import com.crc.leasing.domain.model.office.Office;
import com.crc.leasing.infrastructure.database.jpa.car.entity.CarType;
import com.crc.leasing.infrastructure.database.jpa.car.entity.DoorNumber;
import com.crc.leasing.infrastructure.database.jpa.car.entity.FuelType;
import com.crc.leasing.infrastructure.database.jpa.car.entity.GearboxType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder
@Getter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Car {
    final String uuid;
    final String brand;
    final String model;
    final CarType carType;
    final FuelType fuelType;
    final GearboxType gearboxType;
    final DoorNumber doorNumber;
    final Double bootCapacity;
    final Office office;
    boolean deleted;

    public void markAsDeleted() {
        deleted = true;
    }
}
