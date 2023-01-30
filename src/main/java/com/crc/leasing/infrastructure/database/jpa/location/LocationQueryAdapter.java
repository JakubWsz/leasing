package com.crc.leasing.infrastructure.database.jpa.location;

import com.crc.leasing.domain.model.office.OfficeRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequiredArgsConstructor
public class LocationQueryAdapter implements OfficeRepository {
    final Logger LOGGER = LoggerFactory.getLogger(LocationQueryAdapter.class);
    private final LocationQueryRepository oqr;

}