package com.crc.leasing.infrastructure.database.jpa.office;

import com.crc.leasing.domain.model.office.OfficeRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequiredArgsConstructor
public class OfficeQueryAdapter implements OfficeRepository {
    final Logger LOGGER = LoggerFactory.getLogger(OfficeQueryAdapter.class);
    private final OfficeQueryRepository oqr;

}