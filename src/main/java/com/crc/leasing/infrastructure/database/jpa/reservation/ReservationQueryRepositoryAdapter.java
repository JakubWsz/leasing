package com.crc.leasing.infrastructure.database.jpa.reservation;

import com.crc.leasing.domain.model.car.Car;
import com.crc.leasing.domain.model.reservation.Reservation;
import com.crc.leasing.domain.model.reservation.ReservationQueryRepository;
import com.crc.leasing.infrastructure.database.exception.DbExceptionCode;
import com.crc.leasing.infrastructure.mapper.DaoMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ReservationQueryRepositoryAdapter implements ReservationQueryRepository {
    ReservationQueryRepositoryDAO reservationQueryRepositoryDAO;
    DaoMapper daoMapper;

    @Override
    public List<Reservation> getReservationsByStartAndEndDatesAndCar(
            LocalDateTime startDate, LocalDateTime endDate, Car car
    ) {
//        return reservationQueryDAO.getReservationsByStartAndEndDatesAndCar(
//                        startDate, endDate, daoMapper.mapToCarDAO(car))
//                .stream()
//                .map(daoMapper::mapToReservation)
//                .toList();
        return null;
    }

    @Override
    public List<LocalDateTime> getFreeDatesForCar(Car car) {
        return null;
//                reservationQueryDAO.getFreeDatesForCar(daoMapper.mapToCarDAO(car));
    }

    @Override
    public List<Reservation> getReservationsByDateRange(LocalDate from, LocalDate to) {
        return reservationQueryRepositoryDAO.findByStartDateBetweenAndDeletedFalse(from.atStartOfDay(), to.atStartOfDay()).stream()
                .map(daoMapper::mapToReservation)
                .collect(Collectors.toList());
    }

    @Override
    public Page<Reservation> getPagedReservationsByDateRange(LocalDate from, LocalDate to, Pageable pageable) {
        return reservationQueryRepositoryDAO.findByStartDateBetweenAndDeletedFalse(from.atStartOfDay(), to.atStartOfDay(), pageable)
                .map(daoMapper::mapToReservation);
    }

    @Override
    public Reservation getReservationByUuid(String uuid) {
        return daoMapper.mapToReservation(reservationQueryRepositoryDAO.findByUuidAndDeletedFalse(uuid)
                .orElseThrow(DbExceptionCode.RESERVATION_NOT_EXIST::createException));
    }
}