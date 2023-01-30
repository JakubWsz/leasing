package com.crc.leasing.infrastructure.database.jpa.reservation;

import com.crc.leasing.infrastructure.database.jpa.BaseEntity;
import com.crc.leasing.infrastructure.database.jpa.client.entity.ClientDAO;
import com.crc.leasing.infrastructure.database.jpa.location.LocationDAO;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReservationDAO extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "client_dao_id")
    ClientDAO clientDAO;
    @ManyToOne
    @JoinColumn(name = "location_dao_id")
    LocationDAO locationDAO;
    BigDecimal price;

    public ReservationDAO(ClientDAO clientDAO, LocationDAO locationDAO) {
        this.clientDAO = clientDAO;
        this.locationDAO = locationDAO;
    }

    public void setClientDAO(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    public void setLocationDAO(LocationDAO locationDAO) {
        this.locationDAO = locationDAO;
    }
}
