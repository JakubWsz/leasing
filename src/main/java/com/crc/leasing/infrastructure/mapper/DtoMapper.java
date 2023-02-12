package com.crc.leasing.infrastructure.mapper;

import com.crc.leasing.api.dto.AddressDto;
import com.crc.leasing.api.dto.car.CarRequest;
import com.crc.leasing.api.dto.car.CarResponse;
import com.crc.leasing.api.dto.client.ClientRequest;
import com.crc.leasing.api.dto.employee.EmployeeRequest;
import com.crc.leasing.api.dto.office.OfficeRequest;
import com.crc.leasing.api.dto.office.OfficeResponse;
import com.crc.leasing.api.dto.reservation.ReservationRequest;
import com.crc.leasing.api.dto.reservation.ReservationResponse;
import com.crc.leasing.domain.model.Address;
import com.crc.leasing.domain.model.car.Car;
import com.crc.leasing.domain.model.client.Client;
import com.crc.leasing.domain.model.employee.Employee;
import com.crc.leasing.domain.model.office.Office;
import com.crc.leasing.domain.model.reservation.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface DtoMapper {

//    ReservationResponse mapToReservationResponse(Reservation reservation);

//    @Mapping(target = "price", constant = "null")
//    @Mapping(target = "uuid", constant = "uuid")
//    @Mapping(target = "client", source = "client")
//    @Mapping(target = "receipt", source = "receipt")
//    @Mapping(target = "restoration", source = "restoration")
//    @Mapping(target = "car", source = "car")
//    @Mapping(target = "loaner", source = "loaner")
//    @Mapping(target = "receiver", source = "receiver")
//    Reservation mapToReservation(ReservationRequest reservationRequest);


    @Mapping(target = "deleted", constant = "false")
    Client mapToClient(ClientRequest clientRequest);

    @Mapping(target = "address", source = "addressDto")
    @Mapping(target = "deleted", constant = "false")
    Office mapToOffice(OfficeRequest officeRequest);

    @Mapping(target = "addressDto", source = "address")
    OfficeResponse mapToOfficeResponse(Office office);

//    @Mapping(target = "deleted", constant = "false")
//    @Mapping(source = "officeU", target = "office")
//    Car mapToCar(CarRequest carRequest);

    @Mapping(source = "office.uuid", target = "officeUuid")
    CarResponse mapToCarResponse(Car car);

//    @Mapping(target = "address", source = "addressDto")
//    @Mapping(target = "deleted", constant = "false")
//    Employee mapToEmployee(EmployeeRequest employeeRequest);

    Address mapToAddress(AddressDto addressDto);

    AddressDto map(Address address);
}
