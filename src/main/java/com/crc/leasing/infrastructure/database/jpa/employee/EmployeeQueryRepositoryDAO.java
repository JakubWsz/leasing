package com.crc.leasing.infrastructure.database.jpa.employee;

import com.crc.leasing.infrastructure.database.jpa.employee.entity.EmployeeDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface EmployeeQueryRepositoryDAO extends JpaRepository<EmployeeDAO, Long>, JpaSpecificationExecutor<EmployeeDAO> {
    Optional<EmployeeDAO> findByUuid(String uuid);
}
