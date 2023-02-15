package com.crc.leasing.domain.service.query;

import com.crc.leasing.domain.model.office.Office;
import com.crc.leasing.domain.model.office.OfficeQueryRepository;
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
    OfficeQueryRepository officeQueryRepository;

    public List<Office> getOffices() {
        return officeQueryRepository.getOffices();
    }

    public Page<Office> getOffices(Pageable pageable) {
        return officeQueryRepository.getOffices(pageable);
    }

    public Office getOfficeByUuid(String uuid) {
        return officeQueryRepository.findByUuid(uuid);
    }
}
