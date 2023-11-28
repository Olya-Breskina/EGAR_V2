package ru.podgoretskaya.employeeBase.controller;

import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.testcontainers.containers.Network;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.lifecycle.Startables;

import java.util.Collections;


public class CustomTestInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        Startables.deepStart(Collections.singleton(POSTGRES)).join();
        TestPropertyValues.of(
                "spring.profiles.active=Test",
                "spring.datasource.url=" + POSTGRES.getJdbcUrl(),
                "spring.datasource.username=" + POSTGRES.getUsername(),
                "spring.datasource.password=" + POSTGRES.getPassword(),
                "spring.liquibase.enabled=false",
                "app.accounting-client=" + "http://localhost:8081/accounting"
        ).applyTo(applicationContext.getEnvironment());
    }
    public static final Network NETWORK = Network.builder().build();
    public static final PostgreSQLContainer<?> POSTGRES = new PostgreSQLContainer<>("postgres:12.2-alpine")
            .withNetwork(NETWORK)
            .withDatabaseName("postgres")
            .withUsername("postgres")
            .withPassword("postgres");
}
