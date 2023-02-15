package com.crc.leasing.infrastructure.database.jpa.car;

import com.crc.leasing.domain.model.car.Car;
import com.crc.leasing.domain.model.car.CarQueryRepository;
import com.crc.leasing.infrastructure.database.exception.DbExceptionCode;
import com.crc.leasing.infrastructure.mapper.DaoMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CarQueryRepositoryAdapter implements CarQueryRepository {
    CarQueryRepositoryDAO carQueryRepositoryDAO;
    DaoMapper daoMapper;

    @Override
    public List<Car> getCars() {
        return carQueryRepositoryDAO.findAll().stream()
                .map(daoMapper::mapToCar)
                .collect(Collectors.toList());
    }

    @Override
    public Page<Car> getCars(Pageable pageable) {
        return carQueryRepositoryDAO.findAll(pageable)
                .map(daoMapper::mapToCar);
    }

    @Override
    public Car getCarByUuid(String uuid) {
        return daoMapper.mapToCar(carQueryRepositoryDAO.findByUuid(uuid)
                .orElseThrow(DbExceptionCode.CAR_NOT_EXISTS::createException));
    }
}
