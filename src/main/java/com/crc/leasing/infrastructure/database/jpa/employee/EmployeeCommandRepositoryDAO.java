package com.crc.leasing.infrastructure.database.jpa.employee;

import com.crc.leasing.infrastructure.database.jpa.employee.entity.EmployeeDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeCommandRepositoryDAO extends JpaRepository<EmployeeDAO, Long>{
}
