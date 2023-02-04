package com.crc.leasing.domain.model.reservation;

import com.crc.leasing.domain.model.car.Car;
import com.crc.leasing.domain.model.client.Client;
import com.crc.leasing.domain.model.employee.Employee;
import com.crc.leasing.domain.model.office.Office;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Reservation {
    String uuid;
    final Client client;
    final Office receipt;
    final Office restoration;
    final Car car;
    final LocalDateTime startDate;
    final LocalDateTime endDate;
    final Employee loaner;
    final Employee receiver;
    final BigDecimal price;
    LocalDateTime modificationDate;
    boolean deleted;
}
