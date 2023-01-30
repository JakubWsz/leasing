package com.crc.leasing.infrastructure.database.jpa.reservation;

import com.crc.leasing.domain.model.reservation.Reservation;
import com.crc.leasing.domain.model.reservation.ReservationCommand;
import com.crc.leasing.infrastructure.mapper.DaoMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReservationCommandAdapter implements ReservationCommand {
    final ReservationCommandRepository rcr;
    final DaoMapper daoMapper;

    @Override
    public Mono<Reservation> save(Reservation reservation) {
        return Mono.fromCallable(() -> rcr.save(daoMapper.mapToReservationDao(reservation)))
                .map(r -> reservation);
    }
}
