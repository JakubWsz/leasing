package com.crc.leasing.infrastructure.mapper.dao;

import com.crc.leasing.domain.model.reservation.Reservation;
import com.crc.leasing.infrastructure.database.jpa.car.entity.CarDAO;
import com.crc.leasing.infrastructure.database.jpa.client.entity.ClientDAO;
import com.crc.leasing.infrastructure.database.jpa.employee.entity.EmployeeDAO;
import com.crc.leasing.infrastructure.database.jpa.office.entity.OfficeDAO;
import com.crc.leasing.infrastructure.database.jpa.reservation.ReservationDAO;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ReservationToReservationDAO implements Converter<Reservation, ReservationDAO> {
    ConversionService conversionService;

    @Override
    public ReservationDAO convert(Reservation reservation) {
        return new ReservationDAO(
                conversionService.convert(reservation.client(), ClientDAO.class),
                conversionService.convert(reservation.receipt(), OfficeDAO.class),
                conversionService.convert(reservation.restoration(), OfficeDAO.class),
                conversionService.convert(reservation.car(), CarDAO.class),
                reservation.startDate(),
                reservation.endDate(),
                conversionService.convert(reservation.loaner(), EmployeeDAO.class),
                conversionService.convert(reservation.receiver(), EmployeeDAO.class),
                reservation.getPrice(),
                reservation.uuid()
        );
    }
}
