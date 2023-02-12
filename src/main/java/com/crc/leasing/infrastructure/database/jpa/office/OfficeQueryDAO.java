package com.crc.leasing.infrastructure.database.jpa.office;

import com.crc.leasing.infrastructure.database.jpa.AddressDAO;
import com.crc.leasing.infrastructure.database.jpa.office.entity.OfficeDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface OfficeQueryDAO extends JpaRepository<OfficeDAO,Long> {
    Optional<OfficeDAO> findByUuid(String uuid);
}
