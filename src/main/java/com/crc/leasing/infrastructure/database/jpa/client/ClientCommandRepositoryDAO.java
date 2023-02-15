package com.crc.leasing.infrastructure.database.jpa.client;

import com.crc.leasing.infrastructure.database.jpa.client.entity.ClientDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientCommandRepositoryDAO extends JpaRepository<ClientDAO, Long> {
}
