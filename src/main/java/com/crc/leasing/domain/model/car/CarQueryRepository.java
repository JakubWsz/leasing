package com.crc.leasing.domain.model.car;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CarQueryRepository {
    List<Car> getCars();

    Page<Car> getCars(Pageable pageable);

    Car getCarByUuid(String uuid);
}
