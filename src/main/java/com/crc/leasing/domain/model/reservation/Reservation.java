package com.crc.leasing.domain.model.reservation;

import com.crc.leasing.domain.model.client.Client;
import com.crc.leasing.domain.model.location.Location;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Reservation {
    String domainId;
    final Client client;
    Location location;
    BigDecimal price;
    boolean deleted;

    public Reservation(Client client, Location location, BigDecimal price) {
        this.client = client;
        this.location = location;
        this.price = price;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
