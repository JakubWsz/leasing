package com.crc.leasing.infrastructure.database.jpa.reservation;

import com.crc.leasing.infrastructure.database.jpa.car.entity.CarDAO;
import com.crc.leasing.infrastructure.database.jpa.office.entity.OfficeDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReservationQueryDAO extends JpaRepository<OfficeDAO, Long> {

    @Query("SELECT r FROM ReservationDAO r WHERE r.startDate <= :startDate AND r.endDate >= :endDate AND r.carDAO = :car")
    List<ReservationDAO> getReservationsByStartAndEndDatesAndCar(
            LocalDateTime startDate, LocalDateTime endDate, CarDAO car
    );

    @Query("SELECT r.date FROM ReservationDAO r WHERE r.carDAO.id = :carId AND r.date IS NULL")
    List<LocalDateTime> getFreeDatesForCar(CarDAO carDAO);
}
