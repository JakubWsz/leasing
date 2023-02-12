package com.crc.leasing.infrastructure.mapper.dao;

import com.crc.leasing.domain.model.Address;
import com.crc.leasing.infrastructure.database.jpa.AddressDAO;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.core.convert.converter.Converter;
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AddressToAddressDAO implements Converter<Address, AddressDAO>{

    @Override
    public AddressDAO convert(Address address) {
        return new AddressDAO(
                address.getStreetAddress(),
                address.getPostalCode(),
                address.getCityName()
        );
    }
}

