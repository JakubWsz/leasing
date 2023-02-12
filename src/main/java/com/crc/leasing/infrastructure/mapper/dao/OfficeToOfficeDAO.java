package com.crc.leasing.infrastructure.mapper.dao;

import com.crc.leasing.domain.model.office.Office;
import com.crc.leasing.infrastructure.database.jpa.AddressDAO;
import com.crc.leasing.infrastructure.database.jpa.office.entity.OfficeDAO;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OfficeToOfficeDAO implements Converter<Office, OfficeDAO> {
    ConversionService conversionService;

    @Override
    public OfficeDAO convert(Office office) {
        return new OfficeDAO(
                conversionService.convert(office.getAddress(), AddressDAO.class),
                office.getWebsiteUrl(),
                office.getOfficeCeo(),
                office.isDeleted(),
                office.getUuid()
        );
    }
}