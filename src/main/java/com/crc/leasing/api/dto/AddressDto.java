package com.crc.leasing.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddressDto {
//    @NotNull(message = "Pole z ulicą nie może być puste.")
//    @NotEmpty(message = "Pole z ulicą nie może być puste.")
//    @NotBlank(message = "Pole z ulicą nie może być puste.")
//    @Pattern(regexp = "^[a-ząćęłńóśźżA-ZĄĆĘŁŃÓŚŹŻ\\s0-9]*$", message = "Nazwa lub numer ulicy są nieprawidłowe.")
    String streetAddress;
//    @NotNull(message = "Kod pocztowy nie może być pusty.")
//    @NotEmpty(message = "Kod pocztowy nie może być pusty.")
//    @NotBlank(message = "Kod pocztowy nie może być pusty.")
//    @Pattern(regexp = "^[0-9]{2}-[0-9]{3}", message = "Kod pocztowy jest nieprawidłowy.")
    String postalCode;
//    @NotNull(message = "Nazwa miasta nie może być pusta.")
//    @NotEmpty(message = "Nazwa miasta nie może być pusta.")
//    @NotBlank(message = "Nazwa miasta nie może być pusta.")
    String cityName;
}
