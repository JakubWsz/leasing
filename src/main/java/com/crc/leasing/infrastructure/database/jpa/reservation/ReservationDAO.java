package com.crc.leasing.infrastructure.database.jpa.reservation;

import com.crc.leasing.infrastructure.database.jpa.BaseEntity;
import com.crc.leasing.infrastructure.database.jpa.car.entity.CarDAO;
import com.crc.leasing.infrastructure.database.jpa.client.entity.ClientDAO;
import com.crc.leasing.infrastructure.database.jpa.office.entity.OfficeDAO;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservation")
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReservationDAO extends BaseEntity {

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "client_dao_id")
    ClientDAO clientDAO;
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "receipt_id")
    OfficeDAO receipt;
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "restoration_id")
    OfficeDAO restoration;
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "car_dao_id")
    CarDAO carDAO;
    @Column(name = "start_date")
    LocalDateTime startDate;
    @Column(name = "end_date")
    LocalDateTime endDate;
    @Column(name = "price")
    BigDecimal price;

    public ReservationDAO(ClientDAO clientDAO, OfficeDAO receipt, OfficeDAO restoration, CarDAO carDAO,
                          LocalDateTime startDate, LocalDateTime endDate, BigDecimal price, String uuid) {
        this.clientDAO = clientDAO;
        this.receipt = receipt;
        this.restoration = restoration;
        this.carDAO = carDAO;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        super.uuid = uuid;
    }

    public ReservationDAO(ClientDAO clientDAO, OfficeDAO receipt, OfficeDAO restoration, CarDAO carDAO,
                          LocalDateTime startDate, LocalDateTime endDate, BigDecimal price, Long id, String uuid) {
        this.clientDAO = clientDAO;
        this.receipt = receipt;
        this.restoration = restoration;
        this.carDAO = carDAO;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        super.id = id;
        super.uuid = uuid;
    }
}
