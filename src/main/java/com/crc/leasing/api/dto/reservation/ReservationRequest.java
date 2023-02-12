package com.crc.leasing.api.dto.reservation;

import com.crc.leasing.api.dto.employee.EmployeeRequest;
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
    String loanerEmployeeUuid;
    String receiverEmployeeUuid;
}
