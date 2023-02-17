package com.crc.leasing.api.handler;

import com.crc.leasing.domain.model.reservation.Reservation;
import com.crc.leasing.domain.service.query.ReservationQueryService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ReservationQueryHandler {
    ReservationQueryService reservationQueryService;

    public Mono<List<Reservation>> handle(LocalDate from, LocalDate to) {
        return reservationQueryService.getReservationsByDateRange(from, to);
    }

    public Mono<Page<Reservation>> handle(LocalDate from, LocalDate to, Pageable pageable) {
        return reservationQueryService.getPagedReservationsByDateRange(from, to, pageable);
    }

    public Mono<Reservation> handle(@PathVariable String uuid) {
        return reservationQueryService.getReservationByUuid(uuid);
    }

}
