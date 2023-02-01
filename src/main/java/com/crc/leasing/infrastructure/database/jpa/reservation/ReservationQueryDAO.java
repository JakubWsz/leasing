package com.crc.leasing.infrastructure.database.jpa.reservation;

import com.crc.leasing.infrastructure.database.jpa.office.entity.OfficeDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationQueryDAO extends JpaRepository<OfficeDAO,Long> {
}
