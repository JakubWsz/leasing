package com.crc.leasing.domain.model.employee;

public interface EmployeeQuery {
    Employee findByUuid(String uuid);
}
