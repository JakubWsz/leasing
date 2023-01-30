package com.crc.leasing.domain.service.command;

import com.crc.leasing.domain.model.client.Client;
import com.crc.leasing.domain.model.location.Location;
import com.crc.leasing.domain.model.reservation.Reservation;
import com.crc.leasing.domain.model.reservation.ReservationCommand;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReservationCommandService {
    final ReservationCommand rc;

    public Mono<Reservation> createReservation(Client client, Location location, BigDecimal price) {
        return rc.save(new Reservation(client, location,price));
    }
}
