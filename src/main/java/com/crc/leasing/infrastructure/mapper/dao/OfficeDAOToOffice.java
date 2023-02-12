package com.crc.leasing.infrastructure.mapper.dao;

import com.crc.leasing.domain.model.Address;
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
public class OfficeDAOToOffice implements Converter<OfficeDAO,Office > {
    ConversionService conversionService;

    @Override
    public Office convert(OfficeDAO officeDAO) {
        return new Office(
                officeDAO.getUuid(),
                conversionService.convert(officeDAO.getOfficeAddressDAO(), Address.class),
                officeDAO.getWebsiteUrl(),
                officeDAO.getOfficeCeo(),
                officeDAO.isDeleted()
        );
    }
}