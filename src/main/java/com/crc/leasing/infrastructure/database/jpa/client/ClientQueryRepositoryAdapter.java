package com.crc.leasing.infrastructure.database.jpa.client;

import com.crc.leasing.domain.model.client.Client;
import com.crc.leasing.domain.model.client.ClientQueryRepository;
import com.crc.leasing.infrastructure.database.exception.DbExceptionCode;
import com.crc.leasing.infrastructure.mapper.DaoMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ClientQueryRepositoryAdapter implements ClientQueryRepository {
    ClientQueryRepositoryDAO clientQueryRepositoryDAO;
    DaoMapper daoMapper;

    @Override
    public Client getClientByUuid(String uuid) {
        return daoMapper.mapToClient(clientQueryRepositoryDAO.findByUuid(uuid)
                .orElseThrow(DbExceptionCode.CLIENT_NOT_EXISTS::createException));
    }
}
