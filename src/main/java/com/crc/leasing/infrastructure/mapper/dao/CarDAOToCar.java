package com.crc.leasing.infrastructure.mapper.dao;

import com.crc.leasing.domain.model.car.Car;
import com.crc.leasing.domain.model.office.Office;
import com.crc.leasing.infrastructure.database.jpa.car.entity.CarDAO;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CarDAOToCar implements Converter<CarDAO, Car> {

    ConversionService conversionService;

    @Override
    public Car convert(CarDAO carDAO) {
        return new Car(
                carDAO.getUuid(),
                carDAO.getBrand(),
                carDAO.getModel(),
                carDAO.getCarType(),
                carDAO.getFuelType(),
                carDAO.getGearboxType(),
                carDAO.getDoorNumber(),
                carDAO.getBootCapacity(),
                carDAO.getPricePerDay(),
                conversionService.convert(carDAO.getOfficeDAO(), Office.class),
                carDAO.isDeleted()
        );
    }
}
