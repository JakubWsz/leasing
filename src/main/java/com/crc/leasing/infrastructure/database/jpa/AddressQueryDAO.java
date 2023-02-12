package com.crc.leasing.infrastructure.database.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressQueryDAO extends JpaRepository<AddressDAO, Long> {
    Optional<AddressDAO> findByUuid(String uuid);
}
