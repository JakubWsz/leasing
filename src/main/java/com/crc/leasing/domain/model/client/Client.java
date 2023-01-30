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
    final String domainId;
    final String firstname;
    final String lastname;
    String email;
    String password;
    final LocalDate birthdate;
    boolean deleted;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
