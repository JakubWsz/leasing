package com.crc.leasing.domain.model.employee;

public interface EmployeeQueryRepository {
    Employee findByUuid(String uuid);
}
