package com.crc.leasing.infrastructure.mapper.dao;

import com.crc.leasing.domain.model.employee.Employee;
import com.crc.leasing.infrastructure.database.jpa.AddressDAO;
import com.crc.leasing.infrastructure.database.jpa.employee.entity.EmployeeDAO;
import com.crc.leasing.infrastructure.database.jpa.office.entity.OfficeDAO;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmployeeToEmployeeDAO implements Converter<Employee, EmployeeDAO> {
    ConversionService conversionService;

    @Override
    public EmployeeDAO convert(Employee employee) {
        return new EmployeeDAO(
                employee.getFirstname(),
                employee.getLastname(),
                conversionService.convert(employee.getAddress(), AddressDAO.class),
                employee.getPesel(),
                employee.getAccountNumber(),
                employee.getSalaryAmount(),
                employee.getContractType(),
                employee.getPosition(),
                conversionService.convert(employee.getOffice(), OfficeDAO.class),
                employee.isDeleted(),
                employee.getUuid()
        );
    }
}
