package com.crc.leasing.infrastructure.database.jpa.employee;

import com.crc.leasing.domain.model.employee.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class EmployeeRepositoryAdapterJPA implements EmployeeRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeRepositoryAdapterJPA.class);
    private final EmployeeRepositoryJPA employeeRepositoryJPA;

}
