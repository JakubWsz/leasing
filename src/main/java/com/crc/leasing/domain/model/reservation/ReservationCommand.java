package com.crc.leasing.domain.model.reservation;

import com.crc.leasing.infrastructure.database.jpa.reservation.ReservationDAO;

public interface ReservationCommand {
    Reservation save(Reservation mapToReservation);
}
