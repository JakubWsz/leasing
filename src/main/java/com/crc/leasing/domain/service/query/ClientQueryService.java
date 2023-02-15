package com.crc.leasing.domain.service.query;

import com.crc.leasing.domain.model.client.Client;
import com.crc.leasing.domain.model.client.ClientQueryRepository;
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
    ClientQueryRepository clientQueryRepository;

    public Client getCarByUuid(String uuid){
        return clientQueryRepository.getClientByUuid(uuid);
    }
}
