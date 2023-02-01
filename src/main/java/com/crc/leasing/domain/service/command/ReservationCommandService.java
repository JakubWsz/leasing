package com.crc.leasing.domain.service.command;

import com.crc.leasing.domain.model.car.Car;
import com.crc.leasing.domain.model.client.Client;
import com.crc.leasing.domain.model.employee.Employee;
import com.crc.leasing.domain.model.office.Office;
import com.crc.leasing.domain.model.reservation.Reservation;
import com.crc.leasing.domain.model.reservation.ReservationCommand;
import com.crc.leasing.domain.service.query.ReservationQueryService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ReservationCommandService {
    ReservationCommand reservationCommand;
    ReservationQueryService reservationQueryService;

    public Reservation createReservation(Client client, Office receipt, Office restoration, Car car,
                                         LocalDateTime start, LocalDateTime end, Employee loaner, Employee receiver) {

        validateRentDate(start, end, car);

        // TODO: 01.02.2023 stwórz metodę obliczającą cene wynajmu
        BigDecimal price = null;

        return reservationCommand.save(
                new Reservation(client, receipt, restoration, car, start, end, loaner, receiver, price)
        );
    }

    private void validateRentDate(LocalDateTime start, LocalDateTime end, Car car) {
        List<Reservation> reservations =
                reservationQueryService.getReservationsByStartAndEndDatesAndCar(start, end, car);
        for (Reservation reservation : reservations) {
            if (dateComparator(start, reservation.getStartDate(), reservation.getEndDate())
                    || dateComparator(end, reservation.getStartDate(), reservation.getEndDate())) {
                throw new RuntimeException("Date conflict");
            }
        }
    }

    private boolean dateComparator(LocalDateTime date, LocalDateTime start, LocalDateTime finish) {
        return start.compareTo(date) * date.compareTo(finish) > 0;
    }
}
