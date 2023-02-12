package com.crc.leasing.infrastructure.database.jpa.office;

import com.crc.leasing.domain.model.office.Office;
import com.crc.leasing.domain.model.office.OfficeQuery;
import com.crc.leasing.infrastructure.database.exception.DbExceptionCode;
import com.crc.leasing.infrastructure.mapper.DaoMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
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
    ConversionService conversionService;

    @Override
    public List<Office> getOffices() {
        List<Office> collect = officeQueryDAO.findAll().stream()
                .map(daoMapper::mapToOffice)
                .collect(Collectors.toList());
        return collect;
    }

    @Override
    public Page<Office> getOffices(Pageable pageable) {
        Page<Office> map = officeQueryDAO.findAll(pageable)
                .map(daoMapper::mapToOffice);
        return map;
    }

    @Override
    public Office findByUuid(String uuid) {
        return daoMapper.mapToOffice(officeQueryDAO.findByUuid(uuid)
                .orElseThrow(DbExceptionCode.OFFICE_NOT_EXISTS::createException));
    }
}