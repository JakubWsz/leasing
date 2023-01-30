package com.crc.leasing.infrastructure.database.jpa.office;

import com.crc.leasing.infrastructure.database.jpa.QueryRepository;
import com.crc.leasing.infrastructure.database.jpa.office.entity.OfficeDAO;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeQueryRepository extends QueryRepository<OfficeDAO,Long> {
}
