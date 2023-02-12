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
public record Reservation(String uuid, Client client, Office receipt, Office restoration, Car car,
                          LocalDateTime startDate, LocalDateTime endDate, Employee loaner, Employee receiver,
                          BigDecimal price) {
}
