package com.crc.leasing.domain.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Address {
    String streetAddress;
    String postalCode;
    String cityName;
}
