package com.crc.leasing.infrastructure.database.jpa.location;

import com.crc.leasing.infrastructure.database.jpa.QueryRepository;
import com.crc.leasing.infrastructure.database.jpa.office.entity.OfficeDAO;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationQueryRepository extends QueryRepository<OfficeDAO,Long> {
}
