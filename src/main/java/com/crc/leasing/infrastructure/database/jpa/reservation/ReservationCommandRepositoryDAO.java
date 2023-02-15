package com.crc.leasing.infrastructure.database.jpa.reservation;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ReservationCommandRepositoryDAO extends JpaRepository<ReservationDAO, Long> {
}
