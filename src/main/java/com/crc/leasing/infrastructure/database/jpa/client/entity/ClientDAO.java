package com.crc.leasing.infrastructure.database.jpa.client.entity;

import com.crc.leasing.infrastructure.database.jpa.BaseEntity;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;

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
    LocalDate birthdate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ClientDAO clientDAO = (ClientDAO) o;
        return getId() != null && Objects.equals(getId(), clientDAO.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
