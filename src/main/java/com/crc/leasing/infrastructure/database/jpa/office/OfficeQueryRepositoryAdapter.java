package com.crc.leasing.infrastructure.database.jpa.office;

import com.crc.leasing.domain.model.office.Office;
import com.crc.leasing.domain.model.office.OfficeQueryRepository;
import com.crc.leasing.infrastructure.database.exception.DbExceptionCode;
import com.crc.leasing.infrastructure.mapper.DaoMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OfficeQueryRepositoryAdapter implements OfficeQueryRepository {
    OfficeQueryRepositoryDAO officeQueryRepositoryDAO;
    DaoMapper daoMapper;

    @Override
    public List<Office> getOffices() {
        return officeQueryRepositoryDAO.findAll().stream()
                .map(daoMapper::mapToOffice)
                .collect(Collectors.toList());
    }

    @Override
    public Page<Office> getOffices(Pageable pageable) {
        return officeQueryRepositoryDAO.findAll(pageable)
                .map(daoMapper::mapToOffice);
    }

    @Override
    public Office findByUuid(String uuid) {
        return daoMapper.mapToOffice(officeQueryRepositoryDAO.findByUuid(uuid)
                .orElseThrow(DbExceptionCode.OFFICE_NOT_EXISTS::createException));
    }
}