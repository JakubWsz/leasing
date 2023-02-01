package com.crc.leasing.domain.service.query;

import com.crc.leasing.domain.model.car.Car;
import com.crc.leasing.domain.model.office.Office;
import com.crc.leasing.domain.model.office.OfficeQuery;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OfficeQueryService {
    OfficeQuery officeQuery;

    public List<Office> getCars() {
        return officeQuery.getOffices();
    }

    public Page<Office> getCars(Pageable pageable) {
        return officeQuery.getOffices(pageable);
    }
}
