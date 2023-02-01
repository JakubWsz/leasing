package com.crc.leasing.api.controller.command;

import com.crc.leasing.api.dto.reservation.ReservationRequest;
import com.crc.leasing.api.dto.reservation.ReservationResponse;
import com.crc.leasing.domain.model.reservation.Reservation;
import com.crc.leasing.domain.service.command.ReservationCommandService;
import com.crc.leasing.infrastructure.mapper.DtoMapper;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservation")
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ReservationCommandController {
    ReservationCommandService reservationCommandService;
    DtoMapper dtoMapper;

    @PostMapping
    public ResponseEntity<ReservationResponse> createReservation(@RequestBody @Valid ReservationRequest request) {
        Reservation reservation = reservationCommandService.createReservation(
                dtoMapper.mapToClient(request.getClient()),
                dtoMapper.mapToOffice(request.getReceipt()),
                dtoMapper.mapToOffice(request.getRestoration()),
                dtoMapper.mapToCar(request.getCar()),
                request.getStartDate(), request.getEndDate(),
                dtoMapper.mapToEmployee(request.getLoaner()),
                dtoMapper.mapToEmployee(request.getReceiver())
        );
        log.info("created reservation with uuid: '{}'", reservation.getUuid());
        return ResponseEntity.ok(dtoMapper.mapToReservationResponse(reservation));
    }
}
