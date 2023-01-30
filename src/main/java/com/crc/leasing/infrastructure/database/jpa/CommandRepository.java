package com.crc.leasing.infrastructure.database.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandRepository<T, ID> extends JpaRepository<T,ID> {
}
