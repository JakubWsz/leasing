package com.crc.leasing.infrastructure.database.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public  interface QueryRepository<T, ID> extends JpaRepository<T,ID> {
}
