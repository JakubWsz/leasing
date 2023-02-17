package com.crc.leasing.api.controller.query;

import com.crc.leasing.api.dto.reservation.ReservationResponse;
import com.crc.leasing.api.handler.ReservationQueryHandler;
import com.crc.leasing.infrastructure.mapper.DtoMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reservation")
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ReservationQueryController {
    ReservationQueryHandler reservationQueryHandler;
    DtoMapper dtoMapper;

    @GetMapping
    public Mono<List<ReservationResponse>> getReservationsByDateRange(
            @RequestParam LocalDate from, @RequestParam LocalDate to) {
        return reservationQueryHandler.handle(from, to)
                .map(reservations -> reservations.stream()
                        .map(dtoMapper::mapToReservationResponse)
                        .collect(Collectors.toList()));
    }

    @GetMapping("/paged")
    public Mono<Page<ReservationResponse>> getPagedReservationsByDateRange(
            @RequestParam LocalDate from, @RequestParam LocalDate to, Pageable pageable
    ) {
        return reservationQueryHandler.handle(from, to, pageable)
                .map(reservations -> reservations.map(dtoMapper::mapToReservationResponse));
    }

    @GetMapping("/{uuid}")
    public Mono<ReservationResponse> getReservationByUuid(@PathVariable String uuid) {
        return reservationQueryHandler.handle(uuid)
                .map(dtoMapper::mapToReservationResponse);
    }
}
