package com.crc.leasing.domain.service.query;

import com.crc.leasing.domain.model.employee.Employee;
import com.crc.leasing.domain.model.employee.EmployeeQuery;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmployeeQueryService {
    EmployeeQuery employeeQuery;

    public Employee getEmployeeByUuid(String uuid) {
        return employeeQuery.findByUuid(uuid);
    }
}
