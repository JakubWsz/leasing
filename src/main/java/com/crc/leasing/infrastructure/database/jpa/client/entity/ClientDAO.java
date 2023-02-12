package com.crc.leasing.infrastructure.database.jpa.client.entity;

import com.crc.leasing.infrastructure.database.jpa.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "client")
@NoArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClientDAO extends BaseEntity {
    @Column(name = "firstname")
    String firstname;
    @Column(name = "lastname")
    String lastname;
    @Column(name = "email")
    String email;
    @Column(name = "birthdate")
    LocalDate birthdate;

    public ClientDAO(String firstname, String lastname, String email, LocalDate birthdate, String uuid) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.birthdate = birthdate;
        super.uuid = uuid;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

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

    public void setUuid(String uuid) {
        super.setUuid(uuid);
    }

    public String getUuid() {
        return super.getUuid();
    }
}
