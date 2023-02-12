//package com.crc.leasing.infrastructure.config;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//
//import javax.sql.DataSource;
//import java.util.Properties;
//import
//
//@Configuration
//@EnableJpaRepositories(basePackages = "com.crc.leasing.infrastructure.database.jpa")
//@EntityScan(basePackages = "com.crc.leasing.infrastructure.database.jpa")
//@ComponentScan(basePackages = "com.crc.leasing.infrastructure.database.jpa")
//public class JpaConfig {
//
//    @Autowired
//    private Environment env;
//
//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(env.getProperty("database.driverClassName"));
//        dataSource.setUrl(env.getProperty("database.url"));
//        dataSource.setUsername(env.getProperty("database.username"));
//        dataSource.setPassword(env.getProperty("database.password"));
//        return dataSource;
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource(dataSource());
//        em.setPackagesToScan("com.crc.leasing.infrastructure.database.jpa");
//        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//        em.setJpaProperties(hibernateProperties());
//        return em;
//    }
//
////    @Bean
////    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
////        return new JpaTransactionManager(emf);
////    }
//
//    private Properties hibernateProperties() {
//        Properties properties = new Properties();
//        properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
//        properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
//        properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
//        return properties;
//    }
//}