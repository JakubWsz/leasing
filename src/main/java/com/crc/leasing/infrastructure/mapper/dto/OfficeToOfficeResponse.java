package com.crc.leasing.infrastructure.mapper.dto;

import com.crc.leasing.api.dto.AddressDto;
import com.crc.leasing.api.dto.office.OfficeResponse;
import com.crc.leasing.domain.model.office.Office;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OfficeToOfficeResponse implements Converter<Office, OfficeResponse> {

    ConversionService conversionService;

    @Override
    public OfficeResponse convert(Office office) {
        return OfficeResponse.builder()
                .uuid(office.getUuid())
                .addressDto(conversionService.convert(office.getAddress(), AddressDto.class))
                .officeCeo(office.getOfficeCeo())
                .websiteUrl(office.getWebsiteUrl())
                .build();
    }
}
