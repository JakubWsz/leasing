package com.crc.leasing.domain.service.command;

import com.crc.leasing.domain.exception.DomainExceptionCode;
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
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
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

    public Mono<?> createReservationOrFreeDates(
            String clientUuid, String receiptOfficeUuid, String restorationOfficeUuid, String carUuid,
            LocalDateTime start, LocalDateTime end, String loanerEmployeeUuid, String receiverEmployeeUuid
    ) {
        Car car = getCar(carUuid);
        try {
            validateRentDate(start, end, car);

            BigDecimal price = calculateRentalPrice(start, end, car.getPricePerDay());

            Reservation reservation = new Reservation(
                    UUID.randomUUID().toString(), getClient(clientUuid), getOffice(receiptOfficeUuid),
                    getOffice(restorationOfficeUuid), car, start, end,
                    getEmployee(loanerEmployeeUuid), getEmployee(receiverEmployeeUuid), price
            );
            return Mono.just(reservationCommand.save(reservation));
        } catch (RuntimeException e) {
            List<LocalDateTime> freeDates = getFreeRentDates(start, end, car);
            return Mono.just(freeDates);
        }
    }

    public Mono<?> updateReservationOrFreeDates(String uuid, String carUuid, String receiptOfficeUuid,
                                                String restorationOfficeUuid, LocalDateTime start, LocalDateTime end) {
        Car car = getCar(carUuid);
        try {
            validateRentDate(start, end, car);

            BigDecimal price = calculateRentalPrice(start, end, car.getPricePerDay());

            return Mono.just(
                    reservationCommand.update(uuid, carUuid, receiptOfficeUuid, restorationOfficeUuid, start, end, price)
            );
        } catch (RuntimeException e) {
            List<LocalDateTime> freeDates = getFreeRentDates(start, end, car);
            return Mono.just(freeDates);
        }
    }

    private BigDecimal calculateRentalPrice(LocalDateTime start, LocalDateTime end, BigDecimal pricePerDay) {
        Duration rentalDuration = Duration.between(start, end);
        long rentalDays = rentalDuration.toDays();
        return pricePerDay.multiply(BigDecimal.valueOf(rentalDays));
    }

    private List<LocalDateTime> getFreeRentDates(LocalDateTime start, LocalDateTime end, Car car) {
        List<Reservation> reservations =
                reservationQueryService.getReservationsByStartAndEndDatesAndCar(start, end, car);
        List<LocalDateTime> freeDates = new ArrayList<>();
        LocalDateTime current = start;
        while (current.isBefore(end)) {
            boolean isReserved = false;
            if (reservations != null) {
                for (Reservation reservation : reservations) {
                    if (current.isAfter(reservation.startDate()) && current.isBefore(reservation.endDate())) {
                        isReserved = true;
                        break;
                    }
                }
            }
            if (!isReserved) {
                freeDates.add(current);
            }
            current = current.plusDays(1);
        }
        return freeDates;
    }

    private void validateRentDate(LocalDateTime start, LocalDateTime end, Car car) {
        List<Reservation> reservations =
                reservationQueryService.getReservationsByStartAndEndDatesAndCar(start, end, car);
        if (reservations != null) {
            for (Reservation reservation : reservations) {
                if (dateComparator(start, reservation.startDate(), reservation.endDate())
                        || dateComparator(end, reservation.startDate(), reservation.endDate())) {
                    throw DomainExceptionCode.DATE_CONFLICT.createDateConflictException();
                }
            }
        }
    }

    private boolean dateComparator(LocalDateTime date, LocalDateTime start, LocalDateTime finish) {
        return start.compareTo(date) * date.compareTo(finish) > 0;
    }

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
