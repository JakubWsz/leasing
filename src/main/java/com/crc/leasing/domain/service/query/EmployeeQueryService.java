package com.crc.leasing.domain.service.query;

import com.crc.leasing.domain.model.employee.Employee;
import com.crc.leasing.domain.model.employee.EmployeeQueryRepository;
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
    EmployeeQueryRepository employeeQueryRepository;

    public Employee getEmployeeByUuid(String uuid) {
        return employeeQueryRepository.findByUuid(uuid);
    }
}
