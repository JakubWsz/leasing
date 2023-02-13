package com.crc.leasing.infrastructure.database.jpa.car.entity;

import com.crc.leasing.infrastructure.database.jpa.BaseEntity;
import com.crc.leasing.infrastructure.database.jpa.office.entity.OfficeDAO;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Entity
@Table(name = "car")
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CarDAO extends BaseEntity {
    @Column(name = "brand")
    String brand;
    @Column(name = "model")
    String model;
    @Enumerated(EnumType.STRING)
    @Column(name = "car_Type")
    CarType carType;
    @Enumerated(EnumType.STRING)
    @Column(name = "fuel_Type")
    FuelType fuelType;
    @Enumerated(EnumType.STRING)
    @Column(name = "gearbox_Type")
    GearboxType gearboxType;
    @Enumerated(EnumType.STRING)
    @Column(name = "door_number")
    DoorNumber doorNumber;
    @Column(name = "boot_capacity")
    Double bootCapacity;
    @Column(name = "price_per_day")
    BigDecimal pricePerDay;
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "office_dao_id")
    OfficeDAO officeDAO;

    public CarDAO(String brand, String model, CarType carType, FuelType fuelType,
                  GearboxType gearboxType, DoorNumber doorNumber, Double bootCapacity, BigDecimal pricePerDay,
                  OfficeDAO officeDAO, boolean deleted, String uuid) {
        this.brand = brand;
        this.model = model;
        this.carType = carType;
        this.fuelType = fuelType;
        this.gearboxType = gearboxType;
        this.doorNumber = doorNumber;
        this.bootCapacity = bootCapacity;
        this.pricePerDay = pricePerDay;
        this.officeDAO = officeDAO;
        this.setDeleted(deleted);
        super.uuid = uuid;
    }


    public void setUuid(String uuid) {
        super.setUuid(uuid);
    }
}
