package com.crc.leasing.domain.model.reservation;

import com.crc.leasing.domain.model.car.Car;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationQuery {
    List<Reservation> getReservationsByStartAndEndDatesAndCar(LocalDateTime startDate, LocalDateTime endDate, Car car);
}
