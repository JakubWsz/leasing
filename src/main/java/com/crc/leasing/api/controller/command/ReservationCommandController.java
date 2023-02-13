package com.crc.leasing.api.controller.command;

import com.crc.leasing.api.dto.reservation.ReservationRequest;
import com.crc.leasing.api.dto.reservation.ReservationResponse;
import com.crc.leasing.api.dto.reservation.UpdateReservationRequest;
import com.crc.leasing.api.handler.ReservationCommandHandler;
import com.crc.leasing.infrastructure.mapper.DtoMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

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
    public Mono<ResponseEntity<ReservationResponse>> createReservation(@RequestBody ReservationRequest request) {
        return reservationCommandHandler.handle(
                request.getClientUuid(),
                request.getReceiptOfficeUuid(),
                request.getRestorationOfficeUuid(),
                request.getCarUuid(),
                request.getStart(), request.getEnd(),
                request.getLoanerEmployeeUuid(),
                request.getReceiverEmployeeUuid()
        ).flatMap(reservation -> {
            log.info("created reservation with uuid: '{}'", reservation.uuid());
            return Mono.just(ResponseEntity.ok(conversionService.convert(reservation, ReservationResponse.class)));
        });
    }

    @PutMapping
    public Mono<ResponseEntity<ReservationResponse>> updateReservation(@RequestBody UpdateReservationRequest request){
        return reservationCommandHandler.handle(
                request.getUuid(),
                request.getCarUuid(),
                request.getReceiptOfficeUuid(),
                request.getRestorationOfficeUuid(),
                request.getStart(),
                request.getEnd()
        ).flatMap(reservation -> {
            log.info("updated reservation with uuid: '{}'", reservation.uuid());
            return Mono.just(ResponseEntity.ok(conversionService.convert(reservation, ReservationResponse.class)));
        });
    }
}
