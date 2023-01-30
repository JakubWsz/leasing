package com.crc.leasing.domain.model.location;

import com.crc.leasing.infrastructure.database.jpa.office.entity.OfficeDAO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Location {
    OfficeDAO receipt;
    OfficeDAO restoration;
    boolean deleted;
}
