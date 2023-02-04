package com.crc.leasing.infrastructure.mapper;

import com.crc.leasing.domain.model.car.Car;
import com.crc.leasing.domain.model.office.Office;
import com.crc.leasing.domain.model.reservation.Reservation;
import com.crc.leasing.infrastructure.database.jpa.car.entity.CarDAO;
import com.crc.leasing.infrastructure.database.jpa.office.entity.OfficeDAO;
import com.crc.leasing.infrastructure.database.jpa.reservation.ReservationDAO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface DaoMapper {

    @Mapping(target = "deleted", source = "deleted")
    @Mapping(target = "clientDAO", source = "client")
    ReservationDAO mapToReservationDAO(Reservation reservation);

    @Mapping(target = "client", source = "clientDAO")
    @Mapping(target = "car", source = "carDAO")
    Reservation mapToReservation(ReservationDAO save);

    @Mapping(target = "address", source = "officeAddress")
    Office mapToOffice(OfficeDAO officeDAO);

    Car mapToCar(CarDAO carDAO);

    CarDAO mapToCarDAO(Car car);
}
