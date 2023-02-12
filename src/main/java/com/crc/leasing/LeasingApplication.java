package com.crc.leasing;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//(scanBasePackages = {"com.crc.leasing.infrastructure.database.jpa"})
//@EnableJpaRepositories(basePackages = {"com.crc.leasing.infrastructure.database.jpa"})
//@EntityScan(basePackages = {"com.crc.leasing.infrastructure.database.jpa"})
//@MapperScan("com.crc.leasing.infrastructure.mapper")
public class LeasingApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeasingApplication.class, args);
    }

}
