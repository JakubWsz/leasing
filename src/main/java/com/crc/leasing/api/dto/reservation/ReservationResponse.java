package com.crc.leasing.api.dto.reservation;

import com.crc.leasing.api.dto.car.CarResponse;
import com.crc.leasing.api.dto.client.ClientResponse;
import com.crc.leasing.api.dto.office.OfficeResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReservationResponse {
    String uuid;
    ClientResponse client;
    OfficeResponse receipt;
    OfficeResponse restoration;
    CarResponse car;
    LocalDateTime startDate;
    LocalDateTime endDate;
    BigDecimal price;
}
