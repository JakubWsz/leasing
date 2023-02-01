package com.crc.leasing.infrastructure.database.jpa.office;

import com.crc.leasing.domain.model.car.Car;
import com.crc.leasing.domain.model.office.Office;
import com.crc.leasing.domain.model.office.OfficeQuery;
import com.crc.leasing.infrastructure.mapper.DaoMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OfficeQueryAdapter implements OfficeQuery {
    OfficeQueryDAO officeQueryDAO;
    DaoMapper daoMapper;

    @Override
    public List<Office> getOffices() {
        return officeQueryDAO.findAll().stream()
                .map(daoMapper::mapToOffice)
                .collect(Collectors.toList());
    }

    @Override
    public Page<Office> getOffices(Pageable pageable) {
        return officeQueryDAO.findAll(pageable)
                .map(daoMapper::mapToOffice);
    }
}