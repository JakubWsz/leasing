package com.crc.leasing.infrastructure.database.jpa.address;

import com.crc.leasing.infrastructure.database.jpa.BaseEntity;
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
public class AddressDAO extends BaseEntity {
    String streetAddress;
    String postalCode;
    String cityName;

    public AddressDAO(String streetAddress, String postalCode, String cityName, Long id, String uuid) {
        this.streetAddress = streetAddress;
        this.postalCode = postalCode;
        this.cityName = cityName;
        super.id = id;
        super.uuid = uuid;
    }
}
