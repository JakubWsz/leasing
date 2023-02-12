package com.crc.leasing.infrastructure.database.jpa.employee;

import com.crc.leasing.domain.model.employee.Employee;
import com.crc.leasing.domain.model.employee.EmployeeQuery;
import com.crc.leasing.infrastructure.database.exception.DbExceptionCode;
import com.crc.leasing.infrastructure.mapper.DaoMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmployeeQueryAdapterJPA implements EmployeeQuery {

    EmployeeQueryDAO employeeQueryDAO;
    DaoMapper daoMapper;
    ConversionService conversionService;

    @Override
    public Employee findByUuid(String uuid) {
        return conversionService.convert(employeeQueryDAO.findByUuid(uuid)
                .orElseThrow(DbExceptionCode.EMPLOYEE_NOT_EXISTS::createException),Employee.class);
    }
}
