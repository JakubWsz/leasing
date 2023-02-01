package com.crc.leasing.infrastructure.database.jpa.reservation;

import com.crc.leasing.domain.model.reservation.ReservationQuery;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ReservationQueryAdapter implements ReservationQuery {
    final Logger LOGGER = LoggerFactory.getLogger(ReservationQueryAdapter.class);
    private final ReservationQueryDAO oqr;

}