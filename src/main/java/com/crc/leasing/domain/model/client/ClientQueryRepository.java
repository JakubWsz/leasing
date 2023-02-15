package com.crc.leasing.domain.model.client;

public interface ClientQueryRepository {

    Client getClientByUuid(String uuid);
}
