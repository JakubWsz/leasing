package com.crc.leasing.infrastructure.database.jpa.reservation;

import com.crc.leasing.domain.model.reservation.Reservation;
import com.crc.leasing.domain.model.reservation.ReservationCommand;
import com.crc.leasing.infrastructure.database.exception.DbExceptionCode;
import com.crc.leasing.infrastructure.database.jpa.BaseEntity;
import com.crc.leasing.infrastructure.database.jpa.car.CarQueryDAO;
import com.crc.leasing.infrastructure.database.jpa.car.entity.CarDAO;
import com.crc.leasing.infrastructure.database.jpa.client.ClientQueryDAO;
import com.crc.leasing.infrastructure.database.jpa.client.entity.ClientDAO;
import com.crc.leasing.infrastructure.database.jpa.employee.EmployeeQueryDAO;
import com.crc.leasing.infrastructure.database.jpa.employee.entity.EmployeeDAO;
import com.crc.leasing.infrastructure.database.jpa.office.OfficeQueryDAO;
import com.crc.leasing.infrastructure.database.jpa.office.entity.OfficeDAO;
import com.crc.leasing.infrastructure.mapper.DaoMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Repository
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ReservationCommandAdapter implements ReservationCommand {
    ReservationCommandDAO reservationCommandDAO;
    ReservationQueryDAO reservationQueryDAO;
    DaoMapper daoMapper;
    ClientQueryDAO clientQueryDAO;
    CarQueryDAO carQueryDAO;
    EmployeeQueryDAO employeeQueryDAO;
    OfficeQueryDAO officeQueryDAO;

    @Override
    public Reservation save(Reservation reservation) {
        ReservationDAO reservationDAO = new ReservationDAO(
                findDAOByUuid(reservation.getClient().getUuid(), ClientDAO.class),
                findDAOByUuid(reservation.getReceipt().getUuid(), OfficeDAO.class),
                findDAOByUuid(reservation.getRestoration().getUuid(), OfficeDAO.class),
                findDAOByUuid(reservation.getCar().getUuid(), CarDAO.class),
                reservation.getStartDate(), reservation.getEndDate(), reservation.getPrice(), reservation.getUuid());
        reservationCommandDAO.save(reservationDAO);

        return reservation;
    }

    @Override
    public Reservation update(String uuid, String carUuid, String receiptOfficeUuid, String restorationOfficeUuid,
                              LocalDateTime start, LocalDateTime end, BigDecimal price
    ) {
        ReservationDAO fromDb = reservationQueryDAO.findByUuid(uuid)
                .orElseThrow(DbExceptionCode.RESERVATION_NOT_EXIST::createException);

        ReservationDAO reservationDAO = new ReservationDAO(
                fromDb.getClientDAO(),
                findDAOByUuid(receiptOfficeUuid, OfficeDAO.class),
                findDAOByUuid(restorationOfficeUuid, OfficeDAO.class),
                findDAOByUuid(carUuid, CarDAO.class),
                start, end, price, fromDb.getId(), fromDb.getUuid());
        reservationCommandDAO.save(reservationDAO);

        return daoMapper.mapToReservation(reservationDAO);
//        return conversionService.convert(reservationDAO, Reservation.class);
    }


    private <T extends BaseEntity> T findDAOByUuid(String uuid, Class<T> daoClass) {
        if (daoClass.equals(CarDAO.class)) {
            return daoClass.cast(carQueryDAO.findByUuid(uuid)
                    .orElseThrow(DbExceptionCode.CAR_NOT_EXISTS::createException));
        } else if (daoClass.equals(OfficeDAO.class)) {
            return daoClass.cast(officeQueryDAO.findByUuid(uuid)
                    .orElseThrow(DbExceptionCode.OFFICE_NOT_EXISTS::createException));
        } else if (daoClass.equals(ClientDAO.class)) {
            return daoClass.cast(clientQueryDAO.findByUuid(uuid)
                    .orElseThrow(DbExceptionCode.CLIENT_NOT_EXISTS::createException));
        } else if (daoClass.equals(EmployeeDAO.class)) {
            return daoClass.cast(employeeQueryDAO.findByUuid(uuid)
                    .orElseThrow(DbExceptionCode.EMPLOYEE_NOT_EXISTS::createException));
        } else {
            throw new IllegalArgumentException("Unknown DAO class: " + daoClass);
        }
    }

}
