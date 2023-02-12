package com.crc.leasing.api.controller.query;

import com.crc.leasing.api.dto.office.OfficeResponse;
import com.crc.leasing.domain.service.query.OfficeQueryService;
import com.crc.leasing.infrastructure.mapper.DtoMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/office")
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OfficeQueryController {
    OfficeQueryService officeQueryService;
    DtoMapper dtoMapper;

    @GetMapping
    public ResponseEntity<List<OfficeResponse>> getCars() {
        List<OfficeResponse> cars = officeQueryService.getOffices().stream()
                .map(dtoMapper::mapToOfficeResponse)
                .toList();
        log.info("cars list retrieved");
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/paged")
    public ResponseEntity<Page<OfficeResponse>> getCars(Pageable pageable) {
        Page<OfficeResponse> cars = officeQueryService.getOffices(pageable)
                .map(dtoMapper::mapToOfficeResponse);
        log.info("cars list retrieved");
        return ResponseEntity.ok(cars);
    }
}
