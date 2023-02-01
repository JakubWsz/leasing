package com.crc.leasing.infrastructure.database.jpa.client;

import com.crc.leasing.domain.model.client.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ClientRepositoryAdapterJPA implements ClientRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientRepositoryAdapterJPA.class);
    private final ClientRepositoryJPA clientRepositoryJPA;



}
