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

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CarRequest {
    @NotNull(message = "Pole z identyfikatorem nie może być puste.")
    @NotEmpty(message = "Pole z identyfikatorem nie może być puste.")
    @NotBlank(message = "Pole z identyfikatorem nie może być puste.")
    String uuid;
    @NotNull(message = "Pole z marką nie może być puste.")
    @NotEmpty(message = "Pole z marką nie może być puste.")
    @NotBlank(message = "Pole z marką nie może być puste.")
    String brand;
    @NotNull(message = "Pole z modelem nie może być puste.")
    @NotEmpty(message = "Pole z modelem nie może być puste.")
    @NotBlank(message = "Pole z modelem nie może być puste.")
    String model;
    @NotNull(message = "Pole z nadwoziem nie może być puste.")
    CarType carType;
    @NotNull(message = "Pole z paliwem nie może być puste.")
    FuelType fuelType;
    @NotNull(message = "Pole ze skrzynią biegów nie może być puste.")
    GearboxType gearboxType;
    @NotNull(message = "Pole z liczbą drzwi nie może być puste.")
    DoorNumber doorNumber;
    @NotNull(message = "Pole z pojemnością bagarznika nie może być puste.")
    Double bootCapacity;
    @NotNull(message = "Pole z identyfikatorem biura nie może być puste.")
    @NotEmpty(message = "Pole z identyfikatorem biura nie może być puste.")
    @NotBlank(message = "Pole z identyfikatorem biura nie może być puste.")
    String officeUuid;
}
