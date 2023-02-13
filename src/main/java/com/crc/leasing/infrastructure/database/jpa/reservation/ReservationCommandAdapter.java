package com.crc.leasing.infrastructure.database.jpa.reservation;

import com.crc.leasing.domain.model.employee.Employee;
import com.crc.leasing.domain.model.reservation.Reservation;
import com.crc.leasing.domain.model.reservation.ReservationCommand;
import com.crc.leasing.infrastructure.database.exception.DbExceptionCode;
import com.crc.leasing.infrastructure.database.jpa.AddressDAO;
import com.crc.leasing.infrastructure.database.jpa.AddressQueryDAO;
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
import org.springframework.core.convert.ConversionService;
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
    ConversionService conversionService;
    ClientQueryDAO clientQueryDAO;
    CarQueryDAO carQueryDAO;
    EmployeeQueryDAO employeeQueryDAO;
    OfficeQueryDAO officeQueryDAO;
    AddressQueryDAO addressQueryDAO;

    @Override
    public Reservation save(Reservation reservation) {
        ClientDAO clientDAO = findClientDAOByUuid(reservation.getClient().getUuid());
        OfficeDAO officeReceiptDAO = findOfficeDAOByUuid(reservation.receipt().getUuid());
        OfficeDAO officeRestorationDAO = findOfficeDAOByUuid(reservation.restoration().getUuid());
        CarDAO carDAO = findCarDAOByUuid(reservation.getCar().getUuid());
        EmployeeDAO employeeLoanerDAO = findEmployeeDAOByUuid(reservation.getLoaner().getUuid());
        EmployeeDAO employeeReceiverDAO = findEmployeeDAOByUuid(reservation.receiver().getUuid());

        ReservationDAO reservationDAO = new ReservationDAO(clientDAO, officeReceiptDAO, officeRestorationDAO, carDAO,
                reservation.startDate(), reservation.getEndDate(), employeeLoanerDAO, employeeReceiverDAO,
                reservation.getPrice(), reservation.uuid());
        reservationCommandDAO.save(reservationDAO);

        return reservation;
    }

    @Override
    public Reservation update(String uuid, String carUuid, String receiptOfficeUuid, String restorationOfficeUuid,
                       LocalDateTime start, LocalDateTime end, BigDecimal price
    ) {
        OfficeDAO officeReceiptDAO = findOfficeDAOByUuid(receiptOfficeUuid);
        OfficeDAO officeRestorationDAO = findOfficeDAOByUuid(restorationOfficeUuid);
        CarDAO carDAO = findCarDAOByUuid(carUuid);

        ReservationDAO fromDb = reservationQueryDAO.findByUuid(uuid)
                .orElseThrow(DbExceptionCode.RESERVATION_NOT_EXIST::createException);

        ReservationDAO reservationDAO = new ReservationDAO(fromDb.getClientDAO(),officeReceiptDAO,officeRestorationDAO,
                carDAO,start,end,fromDb.getLoaner(),fromDb.getReceiver(),price,fromDb.getId(),fromDb.getUuid());
        reservationCommandDAO.save(reservationDAO);

        return conversionService.convert(reservationDAO,Reservation.class);

    }


    private CarDAO findCarDAOByUuid(String uuid) {
        return carQueryDAO.findByUuid(uuid)
                .orElseThrow(DbExceptionCode.CAR_NOT_EXISTS::createException);
    }

    private OfficeDAO findOfficeDAOByUuid(String uuid) {
        return officeQueryDAO.findByUuid(uuid)
                .orElseThrow(DbExceptionCode.OFFICE_NOT_EXISTS::createException);
    }

    private ClientDAO findClientDAOByUuid(String uuid) {
        return clientQueryDAO.findByUuid(uuid)
                .orElseThrow(DbExceptionCode.CLIENT_NOT_EXISTS::createException);
    }

    private EmployeeDAO findEmployeeDAOByUuid(String uuid) {
        return employeeQueryDAO.findByUuid(uuid)
                .orElseThrow(DbExceptionCode.EMPLOYEE_NOT_EXISTS::createException);
    }

}
