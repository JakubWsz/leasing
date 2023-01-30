package com.crc.leasing.infrastructure.mapper;

import com.crc.leasing.api.dto.ReservationResponse;
import com.crc.leasing.domain.model.reservation.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface DtoMapper {

    ReservationResponse mapToReservationResponse(Reservation reservation);
    Reservation mapToReservation(Reservation reservation);
}
