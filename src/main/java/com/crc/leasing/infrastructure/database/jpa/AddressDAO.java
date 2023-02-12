package com.crc.leasing.infrastructure.database.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "address")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddressDAO extends BaseEntity{
    String streetAddress;
    String postalCode;
    String cityName;
}
