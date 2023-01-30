package com.crc.leasing.infrastructure.database.jpa.car;

import com.crc.leasing.domain.model.car.CarRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@AllArgsConstructor
public class CarQueryAdapter implements CarRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(CarQueryAdapter.class);
    private final CarQueryRepository carRepositoryJPA;


}
