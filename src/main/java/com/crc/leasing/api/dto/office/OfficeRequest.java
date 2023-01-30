package com.crc.leasing.api.dto.office;

import com.crc.leasing.api.dto.AddressDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OfficeRequest {
    @NotNull(message = "Adres nie może być pusty.")
    @Valid
    AddressDto addressDto;
    @NotNull(message = "URL nie możę być pusty.")
    @NotEmpty(message = "URL nie możę być pusty.")
    @NotBlank(message = "URL nie możę być pusty.")
    @Pattern(regexp = "^(https?|ftp|file)://[-a-zA-Z0-9" +
            "+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]")
    String websiteUrl;
    @NotNull(message = "Imię i nazwisko dyrektora nie może być puste.")
    @NotEmpty(message = "Imię i nazwisko dyrektora nie może być puste.")
    @NotBlank(message = "Imię i nazwisko dyrektora nie może być puste.")
    String officeCeo;
}
