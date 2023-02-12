package com.crc.leasing.infrastructure.database.jpa.office.entity;

import com.crc.leasing.infrastructure.database.jpa.AddressDAO;
import com.crc.leasing.infrastructure.database.jpa.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "office")
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OfficeDAO extends BaseEntity {

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "office_address_id")
    AddressDAO officeAddressDAO;
    @Column(name = "website_url")
    String websiteUrl;
    @Column(name = "office_ceo")
    String officeCeo;

    public OfficeDAO(AddressDAO officeAddressDAO, String websiteUrl, String officeCeo,
                     boolean deleted, String uuid) {
        this.officeAddressDAO = officeAddressDAO;
        this.websiteUrl = websiteUrl;
        this.officeCeo = officeCeo;
        this.setDeleted(deleted);
        super.uuid = uuid;
    }

    public void setUuid(String uuid) {
        super.setUuid(uuid);
    }
}
