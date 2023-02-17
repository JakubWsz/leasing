package com.crc.leasing.domain.model.reservation;

import com.crc.leasing.domain.model.car.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ReservationQueryRepository {
    List<Reservation> getReservationsByStartAndEndDatesAndCar(LocalDateTime startDate, LocalDateTime endDate, Car car);

    List<LocalDateTime> getFreeDatesForCar(Car car);

    Reservation getReservationByUuid(String uuid);

    List<Reservation> getReservationsByDateRange(LocalDate from, LocalDate to);

    Page<Reservation> getPagedReservationsByDateRange(LocalDate from, LocalDate to, Pageable pageable);
}
