package com.crc.leasing.infrastructure.database.jpa.reservation;

import com.crc.leasing.infrastructure.database.jpa.BaseEntity;
import com.crc.leasing.infrastructure.database.jpa.car.entity.CarDAO;
import com.crc.leasing.infrastructure.database.jpa.client.entity.ClientDAO;
import com.crc.leasing.infrastructure.database.jpa.employee.entity.EmployeeDAO;
import com.crc.leasing.infrastructure.database.jpa.office.entity.OfficeDAO;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservation")
@NoArgsConstructor
@Getter
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
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "loaner_id")
    EmployeeDAO loaner;
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "receiver_id")
    EmployeeDAO receiver;

    @Column(name = "price")
    BigDecimal price;

    public ReservationDAO(ClientDAO clientDAO, OfficeDAO receipt, OfficeDAO restoration, CarDAO carDAO,
                          LocalDateTime startDate, LocalDateTime endDate, EmployeeDAO loaner, EmployeeDAO receiver,
                          BigDecimal price, String uuid) {
        this.clientDAO = clientDAO;
        this.receipt = receipt;
        this.restoration = restoration;
        this.carDAO = carDAO;
        this.startDate = startDate;
        this.endDate = endDate;
        this.loaner = loaner;
        this.receiver = receiver;
        this.price = price;
        super.uuid = uuid;
    }

    public void setClientDAO(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    public void setReceipt(OfficeDAO receipt) {
        this.receipt = receipt;
    }

    public void setRestoration(OfficeDAO restoration) {
        this.restoration = restoration;
    }

    public void setCarDAO(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    public void setLoaner(EmployeeDAO loaner) {
        this.loaner = loaner;
    }

    public void setReceiver(EmployeeDAO receiver) {
        this.receiver = receiver;
    }

}
