package com.crc.leasing.infrastructure.mapper.dto;

import com.crc.leasing.api.dto.car.CarResponse;
import com.crc.leasing.api.dto.client.ClientResponse;
import com.crc.leasing.api.dto.employee.EmployeeResponse;
import com.crc.leasing.api.dto.office.OfficeResponse;
import com.crc.leasing.api.dto.reservation.ReservationResponse;
import com.crc.leasing.domain.model.reservation.Reservation;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ReservationToReservationResponse implements Converter<Reservation, ReservationResponse> {

    ConversionService conversionService;

    @Override
    public ReservationResponse convert(Reservation reservation) {
        return ReservationResponse.builder()
                .uuid(reservation.uuid())
                .client(conversionService.convert(reservation.getClient(), ClientResponse.class))
                .receipt(conversionService.convert(reservation.getReceipt(), OfficeResponse.class))
                .restoration(conversionService.convert(reservation.getRestoration(), OfficeResponse.class))
                .car(conversionService.convert(reservation.getCar(), CarResponse.class))
                .startDate(reservation.getStartDate())
                .endDate(reservation.getEndDate())
                .loaner(conversionService.convert(reservation.getLoaner(), EmployeeResponse.class))
                .receiver(conversionService.convert(reservation.getReceiver(), EmployeeResponse.class))
                .price(reservation.getPrice())
                .build();
    }
}
