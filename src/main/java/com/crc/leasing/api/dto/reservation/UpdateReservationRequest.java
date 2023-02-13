package com.crc.leasing.api.dto.reservation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class UpdateReservationRequest {
    String uuid;
    String receiptOfficeUuid;
    String restorationOfficeUuid;
    String carUuid;
    LocalDateTime start;
    LocalDateTime end;
}
