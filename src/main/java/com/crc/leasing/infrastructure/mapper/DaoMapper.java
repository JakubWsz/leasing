package com.crc.leasing.infrastructure.mapper;

import com.crc.leasing.domain.model.reservation.Reservation;
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

    @Mapping(target = "deleted", source = "deleted")
    @Mapping(target = "clientDAO", source = "client")
    @Mapping(target = "locationDAO", source = "location")
    ReservationDAO mapToReservationDao(Reservation reservation);
}
