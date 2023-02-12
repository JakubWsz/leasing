package com.crc.leasing.infrastructure.database.jpa.client;

import com.crc.leasing.infrastructure.database.jpa.AddressDAO;
import com.crc.leasing.infrastructure.database.jpa.client.entity.ClientDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface ClientQueryDAO extends JpaRepository<ClientDAO, Long>, JpaSpecificationExecutor<ClientDAO> {
    Optional<ClientDAO> findByUuid(String uuid);
}
