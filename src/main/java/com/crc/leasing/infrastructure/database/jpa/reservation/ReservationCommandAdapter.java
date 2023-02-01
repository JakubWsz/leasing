package com.crc.leasing.infrastructure.database.jpa.reservation;

import com.crc.leasing.domain.model.reservation.Reservation;
import com.crc.leasing.domain.model.reservation.ReservationCommand;
import com.crc.leasing.infrastructure.mapper.DaoMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReservationCommandAdapter implements ReservationCommand {
    final ReservationCommandDAO rcr;
    final DaoMapper daoMapper;

    @Override
    public Reservation save(Reservation reservation) {
        ReservationDAO reservationDAO = daoMapper.mapToReservationDao(reservation);
        return daoMapper.mapToReservation(rcr.save(reservationDAO));
    }
}
