package com.crc.leasing.infrastructure.database.jpa.location;

import com.crc.leasing.infrastructure.database.jpa.BaseEntity;
import com.crc.leasing.infrastructure.database.jpa.office.entity.OfficeDAO;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LocationDAO extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "receipt_id")
    OfficeDAO receipt;
    @ManyToOne
    @JoinColumn(name = "restoration_id")
    OfficeDAO restoration;
}
