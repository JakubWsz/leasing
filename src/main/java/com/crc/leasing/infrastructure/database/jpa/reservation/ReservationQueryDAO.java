package com.crc.leasing.infrastructure.database.jpa.reservation;

import com.crc.leasing.infrastructure.database.jpa.AddressDAO;
import com.crc.leasing.infrastructure.database.jpa.car.entity.CarDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationQueryDAO extends JpaRepository<ReservationDAO, Long> {
    Optional<ReservationDAO> findByUuid(String uuid);
    @Query("SELECT r FROM ReservationDAO r WHERE r.startDate <= :startDate AND r.endDate >= :endDate AND r.carDAO = :car")
    List<ReservationDAO> getReservationsByStartAndEndDatesAndCar(
            LocalDateTime startDate, LocalDateTime endDate, CarDAO car
    );

//    @Query("SELECT r.startDate FROM ReservationDAO r WHERE r.carDAO.id = :carId AND r.startDate IS NULL")
//    List<LocalDateTime> getFreeDatesForCar(CarDAO carDAO);
}
