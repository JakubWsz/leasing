package com.crc.leasing.domain.service.command;

import com.crc.leasing.domain.model.car.Car;
import com.crc.leasing.domain.model.client.Client;
import com.crc.leasing.domain.model.employee.Employee;
import com.crc.leasing.domain.model.office.Office;
import com.crc.leasing.domain.model.reservation.Reservation;
import com.crc.leasing.domain.model.reservation.ReservationCommand;
import com.crc.leasing.domain.service.query.*;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ReservationCommandService {
    ReservationCommand reservationCommand;
    ReservationQueryService reservationQueryService;
    ClientQueryService clientQueryService;
    CarQueryService carQueryService;
    EmployeeQueryService employeeQueryService;
    OfficeQueryService officeQueryService;

    public Mono<Reservation> createReservation(
            String clientUuid, String receiptOfficeUuid, String restorationOfficeUuid, String carUuid,
            LocalDateTime start, LocalDateTime end, String loanerEmployeeUuid, String receiverEmployeeUuid
    ) {
        Car car = getCar(carUuid);
  //      validateRentDate(start, end, car);

        // TODO: 01.02.2023 stwórz metodę obliczającą cene wynajmu
        BigDecimal price = null;
        Reservation reservation = new Reservation(
                UUID.randomUUID().toString(), getClient(clientUuid), getOffice(receiptOfficeUuid),
                getOffice(restorationOfficeUuid), car, start, end,
                getEmployee(loanerEmployeeUuid), getEmployee(receiverEmployeeUuid), price
        );
        return Mono.just(reservationCommand.save(reservation));
    }

    public Mono<Reservation> updateReservation(
            String uuid, String carUuid, String receiptOfficeUuid, String restorationOfficeUuid,
            LocalDateTime start, LocalDateTime end
    ) {
        // TODO: 01.02.2023 stwórz metodę aktualizującą cene wynajmu
        BigDecimal price = null;

        return Mono.just(
                reservationCommand.update(uuid, carUuid, receiptOfficeUuid, restorationOfficeUuid, start, end, price)
        );
    }

//    private void validateRentDate(LocalDateTime start, LocalDateTime end, Car car) {
//        List<Reservation> reservations =
//                reservationQueryService.getReservationsByStartAndEndDatesAndCar(start, end, car);
//        if (!reservations.isEmpty()) {
//            throw new RuntimeException("Date conflict");
//        }
//    }

    private Client getClient(String uuid) {
        return clientQueryService.getCarByUuid(uuid);
    }

    private Office getOffice(String uuid) {
        return officeQueryService.getOfficeByUuid(uuid);
    }

    private Car getCar(String uuid) {
        return carQueryService.getCarByUuid(uuid);
    }

    private Employee getEmployee(String uuid) {
        return employeeQueryService.getEmployeeByUuid(uuid);
    }
}
