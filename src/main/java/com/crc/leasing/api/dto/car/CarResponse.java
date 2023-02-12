package com.crc.leasing.api.dto.car;

import com.crc.leasing.infrastructure.database.jpa.car.entity.CarType;
import com.crc.leasing.infrastructure.database.jpa.car.entity.DoorNumber;
import com.crc.leasing.infrastructure.database.jpa.car.entity.FuelType;
import com.crc.leasing.infrastructure.database.jpa.car.entity.GearboxType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CarResponse {
    @NotNull @NotEmpty @NotBlank
    String uuid; @NotNull @NotEmpty @NotBlank
    String brand;
    @NotNull @NotEmpty @NotBlank
    String model; @NotNull
    CarType carType;
    @NotNull
    FuelType fuelType; @NotNull
    GearboxType gearboxType; @NotNull
    DoorNumber doorNumber;
    @NotNull
    double bootCapacity; @NotNull @NotEmpty @NotBlank
    String officeUuid;
}
