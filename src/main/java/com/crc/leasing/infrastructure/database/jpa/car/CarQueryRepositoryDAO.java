package com.crc.leasing.infrastructure.database.jpa.car;

import com.crc.leasing.infrastructure.database.jpa.car.entity.CarDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarQueryRepositoryDAO extends JpaRepository<CarDAO, Long> {
    Optional<CarDAO> findByUuid(String uuid);
}
