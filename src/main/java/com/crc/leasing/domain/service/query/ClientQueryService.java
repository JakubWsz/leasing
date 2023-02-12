package com.crc.leasing.domain.service.query;

import com.crc.leasing.domain.model.car.CarQuery;
import com.crc.leasing.domain.model.client.Client;
import com.crc.leasing.domain.model.client.ClientQuery;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ClientQueryService {
    ClientQuery clientQuery;

    public Client getCarByUuid(String uuid){
        return clientQuery.getClientByUuid(uuid);
    }
}
