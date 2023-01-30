package com.crc.leasing.infrastructure.database.jpa.client;

import com.crc.leasing.infrastructure.database.jpa.client.entity.ClientDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface ClientRepositoryJPA extends JpaRepository<ClientDAO, Long> , JpaSpecificationExecutor<ClientDAO> {
    boolean existsByEmail(String email);
    Optional<ClientDAO> findByDomainId(String id);
}
