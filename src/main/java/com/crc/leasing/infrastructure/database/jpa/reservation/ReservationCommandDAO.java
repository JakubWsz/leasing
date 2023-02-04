package com.crc.leasing.infrastructure.database.jpa.reservation;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ReservationCommandDAO extends JpaRepository<ReservationDAO, Long> {
}
