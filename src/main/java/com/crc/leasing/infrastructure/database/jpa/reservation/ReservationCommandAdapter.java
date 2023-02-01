package com.crc.leasing.infrastructure.database.jpa.reservation;

import com.crc.leasing.domain.model.reservation.Reservation;
import com.crc.leasing.domain.model.reservation.ReservationCommand;
import com.crc.leasing.infrastructure.mapper.DaoMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ReservationCommandAdapter implements ReservationCommand {
    ReservationCommandDAO rcr;
    DaoMapper daoMapper;

    @Override
    public Reservation save(Reservation reservation) {
        ReservationDAO reservationDAO = daoMapper.mapToReservationDAO(reservation);
        return daoMapper.mapToReservation(rcr.save(reservationDAO));
    }
}
