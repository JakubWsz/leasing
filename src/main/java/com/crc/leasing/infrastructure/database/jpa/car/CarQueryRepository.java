package com.crc.leasing.infrastructure.database.jpa.car;

import com.crc.leasing.infrastructure.database.jpa.QueryRepository;
import com.crc.leasing.infrastructure.database.jpa.car.entity.CarDAO;

public interface CarQueryRepository extends QueryRepository<CarDAO,Integer> {
}
