package com.crc.leasing.infrastructure.database.jpa.office;

import com.crc.leasing.infrastructure.database.jpa.office.entity.OfficeDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficeCommandRepositoryDAO extends JpaRepository<OfficeDAO,Long> {
}
