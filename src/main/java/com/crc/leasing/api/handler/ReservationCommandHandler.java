package com.crc.leasing.api.handler;

import com.crc.leasing.domain.model.reservation.Reservation;
import com.crc.leasing.domain.service.command.ReservationCommandService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Repository
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ReservationCommandHandler {
    ReservationCommandService reservationCommandService;

    public Mono<?> handleCreate(
            String clientUuid, String receiptOfficeUuid, String restorationOfficeUuid, String carUuid,
            LocalDateTime start, LocalDateTime end
    ) {
        return reservationCommandService.createReservationOrFreeDates(
                clientUuid, receiptOfficeUuid, restorationOfficeUuid, carUuid, start, end
        );
    }


    public Mono<?> handleUpdate(String uuid, String carUuid, String receiptOfficeUuid, String restorationOfficeUuid,
                                LocalDateTime start, LocalDateTime end
    ) {
        return reservationCommandService.updateReservationOrFreeDates(
                uuid, carUuid, receiptOfficeUuid, restorationOfficeUuid, start, end
        );
    }
}
