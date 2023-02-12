package com.crc.leasing.infrastructure.mapper.dao;

import com.crc.leasing.domain.model.Address;
import com.crc.leasing.domain.model.employee.Employee;
import com.crc.leasing.domain.model.office.Office;
import com.crc.leasing.infrastructure.database.jpa.employee.entity.EmployeeDAO;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmployeeDAOToEmployee implements Converter<EmployeeDAO, Employee> {
    ConversionService conversionService;


    @Override
    public Employee convert(EmployeeDAO employeeDAO) {
        return new Employee(
                employeeDAO.getUuid(),
                employeeDAO.getFirstname(),
                employeeDAO.getLastname(),
                conversionService.convert( employeeDAO.getAddressDAO(), Address.class),
                employeeDAO.getPesel(),
                employeeDAO.getAccountNumber(),
                employeeDAO.getSalaryAmount(),
                employeeDAO.getContractType(),
                employeeDAO.getPosition(),
                conversionService.convert( employeeDAO.getOfficeDAO(), Office.class),
                employeeDAO.isDeleted()
        );
    }
}