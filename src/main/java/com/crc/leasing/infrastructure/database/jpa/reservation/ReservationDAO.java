package com.crc.leasing.infrastructure.database.jpa.reservation;

import com.crc.leasing.infrastructure.database.jpa.BaseEntity;
import com.crc.leasing.infrastructure.database.jpa.car.entity.CarDAO;
import com.crc.leasing.infrastructure.database.jpa.client.entity.ClientDAO;
import com.crc.leasing.infrastructure.database.jpa.employee.entity.EmployeeDAO;
import com.crc.leasing.infrastructure.database.jpa.office.entity.OfficeDAO;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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

    @ManyToOne
    @JoinColumn(name = "client_dao_id")
    ClientDAO clientDAO;
    @ManyToOne
    @JoinColumn(name = "receipt_id")
    OfficeDAO receipt;
    @ManyToOne
    @JoinColumn(name = "restoration_id")
    OfficeDAO restoration;
    @ManyToOne
    @JoinColumn(name = "car_dao_id")
    CarDAO carDAO;
    LocalDateTime startDate;
    LocalDateTime endDate;
    @ManyToOne
    @JoinColumn(name = "loaner_id")
    EmployeeDAO loaner;
    @ManyToOne
    @JoinColumn(name = "receiver_id")
    EmployeeDAO receiver;
    BigDecimal price;

    public void setClientDAO(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }
}
