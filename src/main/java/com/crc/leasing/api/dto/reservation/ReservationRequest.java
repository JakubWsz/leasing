package com.crc.leasing.api.dto.reservation;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReservationRequest {
    String clientUuid;
    String receiptOfficeUuid;
    String restorationOfficeUuid;
    String carUuid;
    LocalDateTime start;
    LocalDateTime end;
}
