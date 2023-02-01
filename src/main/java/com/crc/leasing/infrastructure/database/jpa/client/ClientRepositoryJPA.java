package com.crc.leasing.infrastructure.database.jpa.client;

import com.crc.leasing.infrastructure.database.jpa.client.entity.ClientDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ClientRepositoryJPA extends JpaRepository<ClientDAO, Long> , JpaSpecificationExecutor<ClientDAO> {

}
