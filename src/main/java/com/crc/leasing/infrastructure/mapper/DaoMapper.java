package com.crc.leasing.infrastructure.mapper;

import com.crc.leasing.domain.model.Address;
import com.crc.leasing.domain.model.car.Car;
import com.crc.leasing.domain.model.client.Client;
import com.crc.leasing.domain.model.employee.Employee;
import com.crc.leasing.domain.model.office.Office;
import com.crc.leasing.domain.model.reservation.Reservation;
import com.crc.leasing.infrastructure.database.jpa.AddressDAO;
import com.crc.leasing.infrastructure.database.jpa.car.entity.CarDAO;
import com.crc.leasing.infrastructure.database.jpa.client.entity.ClientDAO;
import com.crc.leasing.infrastructure.database.jpa.employee.entity.EmployeeDAO;
import com.crc.leasing.infrastructure.database.jpa.office.entity.OfficeDAO;
import com.crc.leasing.infrastructure.database.jpa.reservation.ReservationDAO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface DaoMapper {

//    @Mapping(target = "clientDAO", source = "client")
//    @Mapping(target = "receipt", source = "receipt")
//    @Mapping(target = "restoration", source = "restoration")
//    @Mapping(target = "carDAO", source = "car")
//    @Mapping(target = "loaner", source = "loaner")
//    @Mapping(target = "receiver", source = "receiver")
//    @Mapping(target = "id", ignore = true)
//    @Mapping(target = "modificationDate", ignore = true)
//    @Mapping(target = "deleted", constant = "false")
//    ReservationDAO mapToReservationDAO(Reservation reservation);

//    @Mapping(target = "client", source = "clientDAO")
//    @Mapping(target = "car", source = "carDAO")
//    Reservation mapToReservation(ReservationDAO save);

    @Mapping(target = "address", source = "officeAddressDAO")
    Office mapToOffice(OfficeDAO officeDAO);

    @Mapping(source = "officeDAO", target = "office")
    Car mapToCar(CarDAO carDAO);

    Client mapToClient(ClientDAO clientDAO);

    @Mapping(target = "streetAddress", source = "streetAddress")
    @Mapping(target = "postalCode", source = "postalCode")
    @Mapping(target = "cityName", source = "cityName")
    Address mapToAddress(AddressDAO addressDAO);

    @Mapping(target = "streetAddress", source = "streetAddress")
    @Mapping(target = "postalCode", source = "postalCode")
    @Mapping(target = "cityName", source = "cityName")
    @Mapping(target = "deleted", ignore = true)
    AddressDAO mapToAddressDAO(Address address);

//    @Mapping(source = "officeDAO", target = "office")
//    Employee mapToEmployee(EmployeeDAO employeeDAO);

//    @Mapping(target = "id", ignore = true)
//    @Mapping(target = "uuid", ignore = true)
//    @Mapping(target = "modificationDate", ignore = true)
//    @Mapping(target = "deleted", constant = "false")
//    ClientDAO mapToClientDAO(Client client);
//
@Mapping(target = "officeAddressDAO", source = "address")
    OfficeDAO mapToOfficeDAO(Office office);
//
//
@Mapping(source = "office", target = "officeDAO")
    CarDAO mapToCarDAO(Car car);
//
//    EmployeeDAO mapToEmployeeDAO(Employee employee);


}
