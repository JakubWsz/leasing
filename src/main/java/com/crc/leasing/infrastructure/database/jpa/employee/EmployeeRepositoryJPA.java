package com.crc.leasing.infrastructure.database.jpa.employee;

import com.crc.leasing.infrastructure.database.jpa.employee.entity.EmployeeDAO;
import com.crc.leasing.infrastructure.filter.specification.EmployeeSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface EmployeeRepositoryJPA extends JpaRepository<EmployeeDAO,Long>, JpaSpecificationExecutor<EmployeeDAO> {
}
