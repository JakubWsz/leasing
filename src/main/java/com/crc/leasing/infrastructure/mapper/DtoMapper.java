package com.crc.leasing.infrastructure.mapper;

import com.crc.leasing.api.dto.AddressDto;
import com.crc.leasing.api.dto.car.CarResponse;
import com.crc.leasing.api.dto.client.ClientResponse;
import com.crc.leasing.api.dto.employee.EmployeeResponse;
import com.crc.leasing.api.dto.office.OfficeResponse;
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

    AddressDto mapToAddressResponse(Address address);

    @Mapping(target = "addressDto", source = "address")
    OfficeResponse mapToOfficeResponse(Office office);

    @Mapping(source = "office.uuid", target = "officeUuid")
    CarResponse mapToCarResponse(Car car);

    ClientResponse mapToClientResponse(Client client);

    @Mapping(source = "address", target = "addressDto")
    @Mapping(source = "office.uuid", target = "officeUuid")
    EmployeeResponse mapToEmployeeResponse(Employee employee);

    @Mapping(target = "client", source = "reservation.client")
    @Mapping(target = "receipt", source = "reservation.receipt")
    @Mapping(target = "restoration", source = "reservation.restoration")
    @Mapping(target = "car", source = "reservation.car")
    @Mapping(target = "startDate", source = "reservation.startDate")
    @Mapping(target = "endDate", source = "reservation.endDate")
    @Mapping(target = "price", source = "reservation.price")
    @Mapping(target = "uuid", source = "reservation.uuid")
    ReservationResponse mapToReservationResponse(Reservation reservation);

}