package com.crc.leasing.infrastructure.mapper.dao;

import com.crc.leasing.domain.model.car.Car;
import com.crc.leasing.domain.model.client.Client;
import com.crc.leasing.domain.model.employee.Employee;
import com.crc.leasing.domain.model.office.Office;
import com.crc.leasing.domain.model.reservation.Reservation;
import com.crc.leasing.infrastructure.database.jpa.reservation.ReservationDAO;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ReservationDAOToReservation implements Converter<ReservationDAO, Reservation> {

    ConversionService conversionService;

    @Override
    public Reservation convert(ReservationDAO reservationDAO) {
        return new Reservation(
                reservationDAO.getUuid(),
               conversionService.convert( reservationDAO.getClientDAO(), Client.class),
                conversionService.convert(reservationDAO.getReceipt(), Office.class),
                conversionService.convert(reservationDAO.getRestoration(), Office.class),
                conversionService.convert(reservationDAO.getCarDAO(), Car.class),
                reservationDAO.getStartDate(),
                reservationDAO.getEndDate(),
                conversionService.convert(reservationDAO.getLoaner(), Employee.class),
                conversionService.convert(reservationDAO.getReceiver(), Employee.class),
                reservationDAO.getPrice()
        );
    }
}
