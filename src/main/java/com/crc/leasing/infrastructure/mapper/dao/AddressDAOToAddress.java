package com.crc.leasing.infrastructure.mapper.dao;

import com.crc.leasing.domain.model.Address;
import com.crc.leasing.infrastructure.database.jpa.AddressDAO;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.core.convert.converter.Converter;


@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AddressDAOToAddress implements Converter<AddressDAO,Address > {

    @Override
    public Address convert(AddressDAO addressDAO) {
        return new Address(
                addressDAO.getStreetAddress(),
                addressDAO.getPostalCode(),
                addressDAO.getCityName()
        );
    }
}
