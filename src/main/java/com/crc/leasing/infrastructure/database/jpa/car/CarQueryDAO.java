package com.crc.leasing.infrastructure.database.jpa.car;

import com.crc.leasing.infrastructure.database.jpa.car.entity.CarDAO;

public interface CarQueryDAO extends org.springframework.data.jpa.repository.JpaRepository<CarDAO, Integer> {
}
