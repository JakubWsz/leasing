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
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/reservation")
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ReservationCommandController {

    ReservationCommandHandler reservationCommandHandler;
    DtoMapper dtoMapper;
    ConversionService conversionService;

    @PostMapping
    public Mono<ResponseEntity<ReservationOrDatesResponse>> createReservation(@RequestBody ReservationRequest request) {
        return reservationCommandHandler.handle(
                request.getClientUuid(),
                request.getReceiptOfficeUuid(),
                request.getRestorationOfficeUuid(),
                request.getCarUuid(),
                request.getStart(), request.getEnd(),
                request.getLoanerEmployeeUuid(),
                request.getReceiverEmployeeUuid()
        ).flatMap(o -> handleReservationOrDates(o, request));
    }

    @PutMapping
    public Mono<ResponseEntity<ReservationOrDatesResponse>> updateReservation(@RequestBody UpdateReservationRequest
                                                                               request) {
        return reservationCommandHandler.handle(
                request.getUuid(),
                request.getCarUuid(),
                request.getReceiptOfficeUuid(),
                request.getRestorationOfficeUuid(),
                request.getStart(),
                request.getEnd()
        ).flatMap(o -> handleReservationOrDates(o, request));
    }

    private Mono<ResponseEntity<ReservationOrDatesResponse>> handleReservationOrDates(Object reservationOrDates,
                                                                                      Object request) {
        if (reservationOrDates instanceof Reservation) {
            ReservationResponse reservationResponse =
                    conversionService.convert(reservationOrDates, ReservationResponse.class);
            ReservationOrDatesResponse response = new ReservationOrDatesResponse(reservationResponse);

            if (request instanceof ReservationRequest) {
                log.info("created reservation with uuid: '{}'", response.getReservationResponse().getUuid());
            } else log.info("updated reservation with uuid: '{}'", response.getReservationResponse().getUuid());

            return Mono.just(ResponseEntity.ok(response));
        } else {
            List<?> list = (List<?>) reservationOrDates;
            List<LocalDateTime> dates = new ArrayList<>();
            for (Object obj : list) {
                if (obj instanceof LocalDateTime) {
                    dates.add((LocalDateTime) obj);
                }
            }
            ReservationOrDatesResponse response = new ReservationOrDatesResponse(dates);
            log.info("dates conflict occurred, returned free dates instead");
            return Mono.just(ResponseEntity.ok(response));
        }
    }
}
