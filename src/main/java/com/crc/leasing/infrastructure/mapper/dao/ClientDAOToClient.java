package com.crc.leasing.infrastructure.mapper.dao;

import com.crc.leasing.domain.model.client.Client;
import com.crc.leasing.infrastructure.database.jpa.client.entity.ClientDAO;
import org.springframework.core.convert.converter.Converter;

public class ClientDAOToClient implements Converter<ClientDAO, Client> {
    @Override
    public Client convert(ClientDAO clientDAO) {
        return new Client(
                clientDAO.getUuid(),
                clientDAO.getFirstname(),
                clientDAO.getLastname(),
                clientDAO.getEmail(),
                clientDAO.getBirthdate(),
                clientDAO.isDeleted()
        );
    }
}
