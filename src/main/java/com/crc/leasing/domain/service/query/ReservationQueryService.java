package com.crc.leasing.domain.service.query;

import com.crc.leasing.domain.model.car.Car;
import com.crc.leasing.domain.model.reservation.Reservation;
import com.crc.leasing.domain.model.reservation.ReservationQueryRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ReservationQueryService {
    ReservationQueryRepository reservationQueryRepository;

    public List<Reservation> getReservationsByStartAndEndDatesAndCar(
            LocalDateTime startDate, LocalDateTime endDate, Car car
    ) {
        return reservationQueryRepository.getReservationsByStartAndEndDatesAndCar(startDate, endDate, car);
    }

    public List<LocalDateTime> getFreeDatesForCar(Car car) {
        return reservationQueryRepository.getFreeDatesForCar(car);
    }

    public Reservation getReservationByUuid(String uuid) {
        return reservationQueryRepository.getReservationByUuid(uuid);
    }
}
