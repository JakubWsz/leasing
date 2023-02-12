package com.crc.leasing.domain.service.query;

import com.crc.leasing.domain.model.car.Car;
import com.crc.leasing.domain.model.car.CarQuery;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CarQueryService {
    CarQuery carQuery;

    public List<Car> getCars() {
        return carQuery.getCars();
    }

    public Page<Car> getCars(Pageable pageable) {
        return carQuery.getCars(pageable);
    }

    public Car getCarByUuid(String uuid){
        return carQuery.getCarByUuid(uuid);
    }
}
