package com.crc.leasing.domain.model.reservation;

import com.crc.leasing.domain.model.car.Car;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationQueryRepository {
    List<Reservation> getReservationsByStartAndEndDatesAndCar(LocalDateTime startDate, LocalDateTime endDate, Car car);

    List<LocalDateTime> getFreeDatesForCar(Car car);

    Reservation getReservationByUuid(String uuid);
}