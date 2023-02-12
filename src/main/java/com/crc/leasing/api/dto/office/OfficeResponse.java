package com.crc.leasing.api.dto.office;

import com.crc.leasing.api.dto.AddressDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OfficeResponse {
    @NotNull @NotEmpty @NotBlank
    String uuid;
    @NotNull
    AddressDto addressDto;
    @NotNull @NotEmpty @NotBlank
    String websiteUrl;
    @NotNull @NotEmpty @NotBlank
    String officeCeo;
}
