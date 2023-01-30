package com.crc.leasing.infrastructure.database.jpa.reservation;

import com.crc.leasing.infrastructure.database.jpa.CommandRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationCommandRepository extends CommandRepository<ReservationDAO, Long> {
}
