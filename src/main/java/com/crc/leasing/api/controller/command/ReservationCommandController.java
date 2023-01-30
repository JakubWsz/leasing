package com.crc.leasing.api.controller.command;

import com.crc.leasing.api.dto.ReservationRequest;
import com.crc.leasing.api.dto.ReservationResponse;
import com.crc.leasing.domain.model.reservation.Reservation;
import com.crc.leasing.domain.service.command.ReservationCommandService;
import com.crc.leasing.infrastructure.mapper.DtoMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/reservation")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ReservationCommandController {
    ReservationCommandService rcs;
    DtoMapper dtoMapper;

    @PostMapping
    public Mono<ResponseEntity<ReservationResponse>> createReservation(@RequestBody ReservationRequest request) {
//        Mono<Reservation> reservation =
//                Mono.just(new Reservation(request.getClient(), request.getLocation(), request.getPrice()));

        Mono<Reservation> reservationMono = rcs.createReservation(
                request.getClient(), request.getLocation(), request.getPrice()).subscribeWith();

        return Mono.just(ResponseEntity.ok(dtoMapper.mapToReservationResponse()));
    }
}
