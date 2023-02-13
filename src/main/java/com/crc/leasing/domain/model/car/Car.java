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
    String brand;
    String model;
    CarType carType;
    FuelType fuelType;
    GearboxType gearboxType;
    DoorNumber doorNumber;
    Double bootCapacity;
    Office office;
    boolean deleted;

    public Car(String uuid) {
        this.uuid = uuid;
    }

    public void markAsDeleted() {
        deleted = true;
    }
}
