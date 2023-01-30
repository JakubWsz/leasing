package com.crc.leasing.infrastructure.database.jpa.reservation;

import com.crc.leasing.domain.model.office.OfficeRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequiredArgsConstructor
public class ReservationQueryAdapter implements OfficeRepository {
    final Logger LOGGER = LoggerFactory.getLogger(ReservationQueryAdapter.class);
    private final ReservationQueryRepository oqr;

}