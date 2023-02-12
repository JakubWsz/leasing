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

        // TODO: 04.02.2023 fix   validateRentDate(start, end, car);

        // TODO: 01.02.2023 stwórz metodę obliczającą cene wynajmu
        BigDecimal price = null;
        Reservation reservation = new Reservation(
                UUID.randomUUID().toString(), getClient(clientUuid), getOffice(receiptOfficeUuid),
                getOffice(restorationOfficeUuid), getCar(carUuid), start, end,
                getEmployee(loanerEmployeeUuid), getEmployee(receiverEmployeeUuid), price
        );
        return Mono.just(reservationCommand.save(reservation));

    }

    private void validateRentDate(LocalDateTime start, LocalDateTime end, Car car) {
        List<Reservation> reservations =
                reservationQueryService.getReservationsByStartAndEndDatesAndCar(start, end, car);
        for (Reservation reservation : reservations) {
            if (dateComparator(start, reservation.startDate(), reservation.endDate())
                    || dateComparator(end, reservation.startDate(), reservation.endDate())) {
                throw new RuntimeException("Date conflict");
            }
        }
    }

    private boolean dateComparator(LocalDateTime date, LocalDateTime start, LocalDateTime finish) {
        return start.compareTo(date) * date.compareTo(finish) > 0;
    }

    private Client getClient(String uuid) {

        Client carByUuid = clientQueryService.getCarByUuid(uuid);
        return carByUuid;
    }

    private Office getOffice(String uuid) {
        Office officeByUuid = officeQueryService.getOfficeByUuid(uuid);
        return officeByUuid;
    }

    private Car getCar(String uuid) {
        Car carByUuid = carQueryService.getCarByUuid(uuid);
        return carByUuid;
    }

    private Employee getEmployee(String uuid) {
        Employee employeeByUuid = employeeQueryService.getEmployeeByUuid(uuid);
        return employeeByUuid;
    }
}
