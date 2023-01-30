package com.crc.leasing.api.dto;

import com.crc.leasing.domain.model.client.Client;
import com.crc.leasing.domain.model.location.Location;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReservationResponse {
    String domainId;
    Client client;
    Location location;
    BigDecimal price;
}
