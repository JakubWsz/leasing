package com.crc.leasing.infrastructure.config;

import com.crc.leasing.infrastructure.mapper.dao.*;
import com.crc.leasing.infrastructure.mapper.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringConvertersConfig implements WebMvcConfigurer {
    @Lazy
    @Autowired
    private ConversionService conversionService;


    @Override
    public void addFormatters(FormatterRegistry registry) {
        //DAO
        registry.addConverter(new AddressToAddressDAO());
        registry.addConverter(new AddressDAOToAddress());
        registry.addConverter(new CarToCarDAO(conversionService));
        registry.addConverter(new ClientToClientDAO());
        registry.addConverter(new EmployeeToEmployeeDAO(conversionService));
        registry.addConverter(new EmployeeDAOToEmployee(conversionService));
        registry.addConverter(new OfficeToOfficeDAO(conversionService));
        registry.addConverter(new OfficeDAOToOffice(conversionService));
        registry.addConverter(new ReservationToReservationDAO(conversionService));

        //DTO
        registry.addConverter(new AddressToAddressDto());
        registry.addConverter(new CarToCarResponse());
        registry.addConverter(new ClientToClientResponse());
        registry.addConverter(new EmployeeToEmployeeResponse(conversionService));
        registry.addConverter(new OfficeToOfficeResponse(conversionService));
        registry.addConverter(new ReservationToReservationResponse(conversionService));

    }
}