package com.crc.leasing.domain.model.reservation;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface ReservationCommand {
    Reservation save(Reservation mapToReservation);


    Reservation update(String uuid, String carUuid, String receiptOfficeUuid, String restorationOfficeUuid,
                LocalDateTime start, LocalDateTime end, BigDecimal price);

    void delete(String uuid);
}
