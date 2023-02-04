package com.crc.leasing.api.controller.query;

import com.crc.leasing.api.dto.car.CarResponse;
import com.crc.leasing.domain.service.query.CarQueryService;
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
@RequestMapping("/car")
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CarQueryController {
    CarQueryService carQueryService;
    DtoMapper dtoMapper;

    @GetMapping
    public ResponseEntity<List<CarResponse>> getCars() {
        List<CarResponse> cars = carQueryService.getCars().stream()
                .map(dtoMapper::mapToCarResponse)
                .toList();
        log.info("cars list retrieved");
        return ResponseEntity.ok(cars);
    }
    @GetMapping("/paged")
    public ResponseEntity<Page<CarResponse>> getCars(Pageable pageable) {
        Page<CarResponse> cars = carQueryService.getCars(pageable)
                .map(dtoMapper::mapToCarResponse);
        log.info("cars list retrieved");
        return ResponseEntity.ok(cars);
    }
}
