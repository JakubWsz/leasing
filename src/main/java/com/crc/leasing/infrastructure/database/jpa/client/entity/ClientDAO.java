package com.crc.leasing.infrastructure.database.jpa.client.entity;

import com.crc.leasing.infrastructure.database.jpa.BaseEntity;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClientDAO extends BaseEntity {
    String firstname;
    String lastname;
    String email;
    String password;
    LocalDate birthdate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ClientDAO client = (ClientDAO) o;
        return Objects.equals(firstname, client.firstname) && Objects.equals(lastname, client.lastname) && Objects.equals(email, client.email) && Objects.equals(password, client.password) && Objects.equals(birthdate, client.birthdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), firstname, lastname, email, password, birthdate);
    }
}
