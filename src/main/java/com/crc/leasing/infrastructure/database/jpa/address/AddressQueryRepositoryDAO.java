package com.crc.leasing.infrastructure.database.jpa.address;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressQueryRepositoryDAO extends JpaRepository<AddressDAO, Long> {
    Optional<AddressDAO> findByUuid(String uuid);
}
