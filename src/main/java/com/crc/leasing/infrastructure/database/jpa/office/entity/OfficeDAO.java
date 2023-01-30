package com.crc.leasing.infrastructure.database.jpa.office.entity;

import com.crc.leasing.domain.model.Address;
import com.crc.leasing.infrastructure.database.jpa.BaseEntity;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@NoArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OfficeDAO extends BaseEntity {
    @Embedded
    Address officeAddress;
    String websiteUrl;
    String officeCeo;

    public OfficeDAO(Address officeAddress, String websiteUrl, String officeCeo,
                     boolean deleted) {
        this.officeAddress = officeAddress;
        this.websiteUrl = websiteUrl;
        this.officeCeo = officeCeo;
        this.setDeleted(deleted);
    }
}
