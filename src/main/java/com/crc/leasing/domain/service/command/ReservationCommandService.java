package com.crc.leasing.domain.service.command;

import com.crc.leasing.domain.exception.DateConflictException;
import com.crc.leasing.domain.exception.DomainExceptionCode;
import com.crc.leasing.domain.model.car.Car;
import com.crc.leasing.domain.model.client.Client;
import com.crc.leasing.domain.model.office.Office;
import com.crc.leasing.domain.model.reservation.Reservation;
import com.crc.leasing.domain.model.reservation.ReservationCommand;
import com.crc.leasing.domain.service.query.CarQueryService;
import com.crc.leasing.domain.service.query.ClientQueryService;
import com.crc.leasing.domain.service.query.OfficeQueryService;
import com.crc.leasing.domain.service.query.ReservationQueryService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ReservationCommandService {
    ReservationCommand reservationCommand;
    ReservationQueryService reservationQueryService;
    ClientQueryService clientQueryService;
    CarQueryService carQueryService;
    OfficeQueryService officeQueryService;

    public Mono<?> createReservationOrFreeDates(
            String clientUuid, String receiptOfficeUuid, String restorationOfficeUuid, String carUuid,
            LocalDateTime start, LocalDateTime end
    ) {
        Car car = getCar(carUuid);
        try {
            validateRentDate(start, end, car);

            BigDecimal price = calculateRentalPrice(start, end, car.getPricePerDay());

            Reservation reservation = new Reservation(
                    UUID.randomUUID().toString(), getClient(clientUuid), getOffice(receiptOfficeUuid),
                    getOffice(restorationOfficeUuid), car, start, end, price
            );
            return Mono.just(reservationCommand.save(reservation));
        } catch (DateConflictException e) {
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
                    reservationCommand.update(
                            uuid, carUuid, receiptOfficeUuid, restorationOfficeUuid, start, end, price
                    )
            );
        } catch (DateConflictException e) {
            List<LocalDateTime> freeDates = getFreeRentDates(start, end, car);
            return Mono.just(freeDates);
        }
    }

    public Mono<Void> deleteReservation(String uuid) {
        reservationCommand.delete(uuid);
        return Mono.empty();
    }

    private BigDecimal calculateRentalPrice(LocalDateTime start, LocalDateTime end, BigDecimal pricePerDay) {
        Duration rentalDuration = Duration.between(start, end);
        long rentalDays = rentalDuration.toDays();
        return pricePerDay.multiply(BigDecimal.valueOf(rentalDays));
    }

    private List<LocalDateTime> getFreeRentDates(LocalDateTime start, LocalDateTime end, Car car) {
        List<Reservation> reservations =
                reservationQueryService.getReservationsByStartAndEndDatesAndCar(start, end, car);
        return Stream.iterate(start, date -> date.plusDays(1))
                .limit(ChronoUnit.DAYS.between(start, end))
                .filter(date -> reservations == null || reservations.stream()
                        .noneMatch(reservation -> date.isAfter(reservation.getStartDate())
                                && date.isBefore(reservation.getEndDate())))
                .collect(Collectors.toList());
    }

    private void validateRentDate(LocalDateTime start, LocalDateTime end, Car car) {
        List<Reservation> reservations =
                reservationQueryService.getReservationsByStartAndEndDatesAndCar(start, end, car);
        if (reservations != null && reservations.stream().anyMatch(reservation ->
                dateComparator(start, reservation.getStartDate(), reservation.getEndDate()) ||
                        dateComparator(end, reservation.getStartDate(), reservation.getEndDate()))) {
            throw DomainExceptionCode.DATE_CONFLICT.createDateConflictException();
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
}
