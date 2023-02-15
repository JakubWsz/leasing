package com.crc.leasing.infrastructure.mapper;

import com.crc.leasing.domain.model.address.Address;
import com.crc.leasing.domain.model.car.Car;
import com.crc.leasing.domain.model.client.Client;
import com.crc.leasing.domain.model.employee.Employee;
import com.crc.leasing.domain.model.office.Office;
import com.crc.leasing.domain.model.reservation.Reservation;
import com.crc.leasing.infrastructure.database.jpa.address.AddressDAO;
import com.crc.leasing.infrastructure.database.jpa.car.entity.CarDAO;
import com.crc.leasing.infrastructure.database.jpa.client.entity.ClientDAO;
import com.crc.leasing.infrastructure.database.jpa.employee.entity.EmployeeDAO;
import com.crc.leasing.infrastructure.database.jpa.office.entity.OfficeDAO;
import com.crc.leasing.infrastructure.database.jpa.reservation.ReservationDAO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface DaoMapper {

    @Mapping(target = "super.id", ignore = true)
    Address mapTooAddress(AddressDAO addressDAO);

    @Mapping(target = "streetAddress", source = "streetAddress")
    @Mapping(target = "postalCode", source = "postalCode")
    @Mapping(target = "cityName", source = "cityName")
    @Mapping(target = "deleted", ignore = true)
    AddressDAO mapToAddressDAO(Address address);

    @Mapping(source = "officeAddressDAO", target = "address")
    Office mapToOffice(OfficeDAO officeDAO);

    @Mapping(source = "address", target = "officeAddressDAO")
    OfficeDAO mapToOfficeDAO(Office office);

    @Mapping(source = "officeDAO", target = "office")
    Car mapToCar(CarDAO carDAO);

    @Mapping(source = "office", target = "officeDAO")
    CarDAO mapToCarDAO(Car car);

    Client mapToClient(ClientDAO clientDAO);

    ClientDAO mapToClientDAO(Client client);

    @Mapping(source = "addressDAO", target = "address")
    @Mapping(source = "officeDAO", target = "office")
    Employee mapToEmployee(EmployeeDAO employeeDAO);

    @Mapping(source = "address", target = "addressDAO")
    @Mapping(source = "office", target = "officeDAO")
    EmployeeDAO mapToEmployeeDAO(Employee employee);

    @Mapping(source = "clientDAO", target = "client")
    @Mapping(source = "carDAO", target = "car")
    @Mapping(source = "receipt", target = "receipt")
    @Mapping(source = "restoration", target = "restoration")
    Reservation mapToReservation(ReservationDAO reservationDAO);

    @Mapping(source = "client", target = "clientDAO")
    @Mapping(source = "car", target = "carDAO")
    @Mapping(source = "receipt", target = "receipt")
    @Mapping(source = "restoration", target = "restoration")
    @Mapping(target = "deleted", ignore = true)
    ReservationDAO mapToReservationDAO(Reservation reservation);
}