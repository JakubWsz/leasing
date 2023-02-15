package com.crc.leasing.domain.model.address;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Address {
    String uuid;
    String streetAddress;
    String postalCode;
    String cityName;

    public Address(String streetAddress, String postalCode, String cityName) {
        this.streetAddress = streetAddress;
        this.postalCode = postalCode;
        this.cityName = cityName;
    }
}
