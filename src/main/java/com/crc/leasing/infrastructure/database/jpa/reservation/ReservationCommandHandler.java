package com.crc.leasing.infrastructure.database.jpa.reservation;

import com.crc.leasing.domain.model.car.Car;
import com.crc.leasing.domain.model.client.Client;
import com.crc.leasing.domain.model.employee.Employee;
import com.crc.leasing.domain.model.office.Office;
import com.crc.leasing.domain.model.reservation.Reservation;
import com.crc.leasing.domain.service.command.ReservationCommandService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ReservationCommandHandler {
    ReservationCommandService reservationCommandService;

    public Reservation handle(Client client, Office receipt, Office restoration, Car car,
                              LocalDateTime start, LocalDateTime end, Employee loaner, Employee receiver) {
        return reservationCommandService.createReservation(
                client, receipt, restoration, car, start, end, loaner, receiver
        );
    }
}
