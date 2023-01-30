package com.crc.leasing.api.dto.office;

import com.crc.leasing.api.dto.AddressDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record OfficeResponse(@NotNull @NotEmpty @NotBlank String id, @NotNull AddressDto addressDTO,
                             @NotNull @NotEmpty @NotBlank String websiteURL,
                             @NotNull @NotEmpty @NotBlank String officeCEO) {
}
