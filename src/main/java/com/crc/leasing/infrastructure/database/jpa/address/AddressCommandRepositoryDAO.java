package com.crc.leasing.infrastructure.database.jpa.address;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressCommandRepositoryDAO extends JpaRepository<AddressDAO,Long> {
}
