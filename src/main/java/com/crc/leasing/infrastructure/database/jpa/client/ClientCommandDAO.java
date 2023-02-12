package com.crc.leasing.infrastructure.database.jpa.client;

import com.crc.leasing.infrastructure.database.jpa.client.entity.ClientDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientCommandDAO extends JpaRepository<ClientDAO, Long> {
}
