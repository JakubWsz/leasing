package com.crc.leasing.api.controller.command;

import com.crc.leasing.api.dto.reservation.ReservationOrDatesResponse;
import com.crc.leasing.api.dto.reservation.ReservationRequest;
import com.crc.leasing.api.dto.reservation.ReservationResponse;
import com.crc.leasing.api.dto.reservation.UpdateReservationRequest;
import com.crc.leasing.api.handler.ReservationCommandHandler;
import com.crc.leasing.domain.model.reservation.Reservation;
import com.crc.leasing.infrastructure.mapper.DtoMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reservation")
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ReservationCommandController {

    ReservationCommandHandler reservationCommandHandler;
    DtoMapper dtoMapper;

    @PostMapping
    public Mono<ResponseEntity<ReservationOrDatesResponse>> createReservation(@RequestBody ReservationRequest request) {
        return reservationCommandHandler.handleCreate(
                request.getClientUuid(),
                request.getReceiptOfficeUuid(),
                request.getRestorationOfficeUuid(),
                request.getCarUuid(),
                request.getStart(), request.getEnd()
        ).flatMap(o -> handleReservationOrDates(o, request));
    }

    @PutMapping
    public Mono<ResponseEntity<ReservationOrDatesResponse>> updateReservation(
            @RequestBody UpdateReservationRequest request) {
        return reservationCommandHandler.handleUpdate(
                request.getUuid(),
                request.getCarUuid(),
                request.getReceiptOfficeUuid(),
                request.getRestorationOfficeUuid(),
                request.getStart(),
                request.getEnd()
        ).flatMap(o -> handleReservationOrDates(o, request));
    }

    @DeleteMapping("/{uuid}")
    public Mono<ResponseEntity<Void>> deleteReservation(@PathVariable String uuid) {
        return reservationCommandHandler.deleteHandler(uuid)
                .then(Mono.just(ResponseEntity.ok().build()));
    }

    private Mono<ResponseEntity<ReservationOrDatesResponse>> handleReservationOrDates(
            final Object reservationOrDates, final Object request
    ) {
        if (reservationOrDates instanceof Reservation) {
            ReservationOrDatesResponse response = createReservationResponse((Reservation) reservationOrDates);
            logReservation((Reservation) reservationOrDates, request);
            return Mono.just(ResponseEntity.ok(response));
        } else {
            List<LocalDateTime> dates = extractLocalDateTimes(reservationOrDates);
            ReservationOrDatesResponse response = createDatesResponse(dates);
            logDatesConflict();
            return Mono.just(ResponseEntity.ok(response));
        }
    }

    private ReservationOrDatesResponse createReservationResponse(final Reservation reservation) {
        ReservationResponse reservationResponse = dtoMapper.mapToReservationResponse(reservation);
        return new ReservationOrDatesResponse(reservationResponse);
    }

    private List<LocalDateTime> extractLocalDateTimes(final Object reservationOrDates) {
        return ((List<?>) reservationOrDates).stream()
                .filter(LocalDateTime.class::isInstance)
                .map(date -> {
                    try {
                        return (LocalDateTime) date;
                    } catch (ClassCastException e) {
                        e.printStackTrace();
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private ReservationOrDatesResponse createDatesResponse(final List<LocalDateTime> dates) {
        return new ReservationOrDatesResponse(dates);
    }

    private void logReservation(final Reservation reservation, final Object request) {
        String logMessage = String.format("%s reservation with uuid: '%s'",
                request instanceof ReservationRequest ? "created" : "updated",
                reservation.getUuid());
        log.info(logMessage);
    }

    private void logDatesConflict() {
        log.info("dates conflict occurred, returned free dates instead");
    }
}
