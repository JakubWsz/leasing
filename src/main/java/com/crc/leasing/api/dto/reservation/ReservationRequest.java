package com.crc.leasing.api.dto.reservation;

import com.crc.leasing.api.dto.car.CarRequest;
import com.crc.leasing.api.dto.client.ClientRequest;
import com.crc.leasing.api.dto.employee.EmployeeRequest;
import com.crc.leasing.api.dto.office.OfficeRequest;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReservationRequest {
    @Valid
    ClientRequest client;
    @Valid
    OfficeRequest receipt;
    @Valid
    OfficeRequest restoration;
    @Valid
    CarRequest car;
    LocalDateTime startDate;
    LocalDateTime endDate;
    @Valid
    EmployeeRequest loaner;
    @Valid
    EmployeeRequest receiver;
}
