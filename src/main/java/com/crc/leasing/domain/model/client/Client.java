package com.crc.leasing.domain.model.client;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@AllArgsConstructor
@Builder
@Getter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Client {
    final String uuid;
    final String firstname;
    final String lastname;
    final String email;
    final LocalDate birthdate;
    boolean deleted;
}
