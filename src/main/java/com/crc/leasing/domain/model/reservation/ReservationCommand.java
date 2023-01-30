package com.crc.leasing.domain.model.reservation;

import reactor.core.publisher.Mono;

public interface ReservationCommand {
    Mono<Reservation> save(Reservation reservation);
}
