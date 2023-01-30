package com.crc.leasing.api.dto.car;

import com.crc.leasing.infrastructure.database.jpa.car.entity.CarType;
import com.crc.leasing.infrastructure.database.jpa.car.entity.DoorNumber;
import com.crc.leasing.infrastructure.database.jpa.car.entity.FuelType;
import com.crc.leasing.infrastructure.database.jpa.car.entity.GearboxType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CarResponse(@NotNull @NotEmpty @NotBlank String id, @NotNull @NotEmpty @NotBlank String brand,
                          @NotNull @NotEmpty @NotBlank String model, @NotNull CarType carType,
                          @NotNull FuelType fuelType, @NotNull GearboxType gearboxType, @NotNull DoorNumber doorNumber,
                          @NotNull double bootCapacity, @NotNull @NotEmpty @NotBlank String officeId) {
}
