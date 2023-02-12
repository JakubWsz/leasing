package com.crc.leasing.infrastructure.mapper.dao;

import com.crc.leasing.domain.model.client.Client;
import com.crc.leasing.infrastructure.database.jpa.client.entity.ClientDAO;
import org.springframework.core.convert.converter.Converter;

public class ClientToClientDAO implements Converter<Client, ClientDAO> {
    @Override
    public ClientDAO convert(Client client) {
        return new ClientDAO(
                client.getFirstname(),
                client.getLastname(),
                client.getEmail(),
                client.getBirthdate(),
                client.getUuid());
    }
}
