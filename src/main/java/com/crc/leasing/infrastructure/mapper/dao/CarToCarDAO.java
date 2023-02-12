package com.crc.leasing.infrastructure.mapper.dao;

import com.crc.leasing.domain.model.car.Car;
import com.crc.leasing.infrastructure.database.jpa.car.entity.CarDAO;
import com.crc.leasing.infrastructure.database.jpa.office.entity.OfficeDAO;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CarToCarDAO implements Converter<Car, CarDAO> {
    ConversionService conversionService;

    @Override
    public CarDAO convert(Car car) {
        return new CarDAO(

                car.getBrand(),
                car.getModel(),
                car.getCarType(),
                car.getFuelType(),
                car.getGearboxType(),
                car.getDoorNumber(),
                car.getBootCapacity(),
                conversionService.convert(car.getOffice(), OfficeDAO.class),
                car.isDeleted(),
                car.getUuid()
        );
    }
}