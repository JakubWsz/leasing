package com.crc.leasing.infrastructure.mapper.dto;

import com.crc.leasing.api.dto.client.ClientResponse;
import com.crc.leasing.domain.model.client.Client;
import org.springframework.core.convert.converter.Converter;

public class ClientToClientResponse implements Converter<Client, ClientResponse> {

    @Override
    public ClientResponse convert(Client client) {
        return ClientResponse.builder()
                .uuid(client.getUuid())
                .firstname(client.getFirstname())
                .lastname(client.getLastname())
                .email(client.getEmail())
                .birthdate(client.getBirthdate())
                .build();
    }
}
