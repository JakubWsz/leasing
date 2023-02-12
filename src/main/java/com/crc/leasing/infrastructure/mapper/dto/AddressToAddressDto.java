package com.crc.leasing.infrastructure.mapper.dto;

import com.crc.leasing.api.dto.AddressDto;
import com.crc.leasing.domain.model.Address;
import org.springframework.core.convert.converter.Converter;

public class AddressToAddressDto implements Converter<Address, AddressDto> {
    @Override
    public AddressDto convert(Address address) {
        return AddressDto.builder()
                .streetAddress(address.getStreetAddress())
                .postalCode(address.getPostalCode())
                .cityName(address.getCityName())
                .build();
    }
}
