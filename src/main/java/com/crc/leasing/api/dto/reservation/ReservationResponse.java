package com.crc.leasing.api.dto.reservation;

import com.crc.leasing.api.dto.car.CarRequest;
import com.crc.leasing.api.dto.client.ClientRequest;
import com.crc.leasing.api.dto.employee.EmployeeRequest;
import com.crc.leasing.api.dto.office.OfficeRequest;
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
public class ReservationResponse {
    String uuid;
    ClientRequest client;
    OfficeRequest receipt;
    OfficeRequest restoration;
    CarRequest car;
    LocalDateTime startDate;
    LocalDateTime endDate;
    EmployeeRequest loaner;
    EmployeeRequest receiver;
}
