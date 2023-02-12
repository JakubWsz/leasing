package com.crc.leasing.infrastructure.database.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressCommandDAO extends JpaRepository<AddressDAO,Long> {
}
