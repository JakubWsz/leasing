package com.crc.leasing.api.dto.reservation;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReservationOrDatesResponse {
    ReservationResponse reservationResponse;
    List<LocalDateTime> dates;

    public ReservationOrDatesResponse(ReservationResponse reservationResponse) {
        this.reservationResponse = reservationResponse;
    }

    public ReservationOrDatesResponse(List<LocalDateTime> dates) {
        this.dates = dates;
    }
}
