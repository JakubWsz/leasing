package com.crc.leasing.infrastructure.database.jpa.reservation;

import com.crc.leasing.domain.model.car.Car;
import com.crc.leasing.domain.model.reservation.Reservation;
import com.crc.leasing.domain.model.reservation.ReservationQuery;
import com.crc.leasing.infrastructure.mapper.DaoMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ReservationQueryAdapter implements ReservationQuery {
    ReservationQueryDAO reservationQueryDAO;
    DaoMapper daoMapper;

    @Override
    public List<Reservation> getReservationsByStartAndEndDatesAndCar(
            LocalDateTime startDate, LocalDateTime endDate, Car car
    ) {
//        return reservationQueryDAO.getReservationsByStartAndEndDatesAndCar(
//                        startDate, endDate, daoMapper.mapToCarDAO(car))
//                .stream()
//                .map(daoMapper::mapToReservation)
//                .toList();
    return null;
    }

    @Override
    public List<LocalDateTime> getFreeDatesForCar(Car car) {
        return null;
//                reservationQueryDAO.getFreeDatesForCar(daoMapper.mapToCarDAO(car));
    }
}