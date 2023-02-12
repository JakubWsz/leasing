package com.crc.leasing.infrastructure.mapper.dto;

import com.crc.leasing.api.dto.AddressDto;
import com.crc.leasing.api.dto.employee.EmployeeResponse;
import com.crc.leasing.domain.model.employee.Employee;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmployeeToEmployeeResponse implements Converter<Employee, EmployeeResponse> {

    ConversionService conversionService;

    @Override
    public EmployeeResponse convert(Employee employee) {
        return EmployeeResponse.builder()
                .uuid(employee.getUuid())
                .firstname(employee.getFirstname())
                .lastname(employee.getLastname())
                .address(conversionService.convert(employee.getAddress(), AddressDto.class))
                .pesel(employee.getPesel())
                .accountNumber(employee.getAccountNumber())
                .salaryAmount(employee.getSalaryAmount())
                .contractType(employee.getContractType())
                .position(employee.getPosition())
                .officeUuid(employee.getOffice().getUuid())
                .build();
    }
}
