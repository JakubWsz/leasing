package com.crc.leasing.infrastructure.mapper.dto;

import com.crc.leasing.api.dto.car.CarResponse;
import com.crc.leasing.domain.model.car.Car;
import org.springframework.core.convert.converter.Converter;

public class CarToCarResponse implements Converter<Car, CarResponse> {

    @Override
    public CarResponse convert(Car car) {
        return CarResponse.builder()
                .uuid(car.getUuid())
                .brand(car.getBrand())
                .model(car.getModel())
                .carType(car.getCarType())
                .fuelType(car.getFuelType())
                .gearboxType(car.getGearboxType())
                .doorNumber(car.getDoorNumber())
                .bootCapacity(car.getBootCapacity())
                .officeUuid(car.getOffice().getUuid())
                .build();
    }
}
