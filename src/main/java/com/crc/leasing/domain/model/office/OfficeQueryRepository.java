package com.crc.leasing.domain.model.office;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OfficeQueryRepository {

    List<Office> getOffices();

    Page<Office> getOffices(Pageable pageable);

    Office findByUuid(String uuid);
}
