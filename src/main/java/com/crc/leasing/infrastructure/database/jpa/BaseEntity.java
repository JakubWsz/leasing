package com.crc.leasing.infrastructure.database.jpa;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;

import java.time.LocalDateTime;
import java.util.Objects;

@MappedSuperclass
@ToString
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseEntity {
    @Id
    @SequenceGenerator(name = "idGeneratorSeq", sequenceName = "idSequence")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "idGeneratorSeq")
    @Column(name = "id")
    Long id;

    @Column(name = "uuid")
    protected String uuid;

    @Column(name = "modification_date")
    LocalDateTime modificationDate;

    @Column(name = "deleted",nullable = false)
    boolean deleted;

    public String getUuid() {
        return uuid;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public Long getId() {
        return id;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    protected void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BaseEntity that = (BaseEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
