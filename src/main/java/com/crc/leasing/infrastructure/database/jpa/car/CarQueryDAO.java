package com.crc.leasing.infrastructure.database.jpa.car;

import com.crc.leasing.infrastructure.database.jpa.AddressDAO;
import com.crc.leasing.infrastructure.database.jpa.car.entity.CarDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarQueryDAO extends JpaRepository<CarDAO, Long> {
    Optional<CarDAO> findByUuid(String uuid);
}
