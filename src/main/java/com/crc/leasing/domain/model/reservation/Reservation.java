package com.crc.leasing.domain.model.reservation;

import com.crc.leasing.domain.model.car.Car;
import com.crc.leasing.domain.model.client.Client;
import com.crc.leasing.domain.model.office.Office;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Reservation {
    String uuid;
    Client client;
    Office receipt;
    Office restoration;
    Car car;
    LocalDateTime startDate;
    LocalDateTime endDate;
    BigDecimal price;
}
