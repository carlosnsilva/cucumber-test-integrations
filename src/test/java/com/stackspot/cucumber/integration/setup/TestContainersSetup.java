package com.stackspot.cucumber.integration.setup;

import org.springframework.core.env.ConfigurableEnvironment;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;

public class TestContainersSetup {

    @Container
    static PostgreSQLContainer postgresqlContainer = new PostgreSQLContainer();

    public static void initTestContainers(ConfigurableEnvironment configEnv) {
        postgresqlContainer.addEnv("POSTGRES_DEFAULT_URL", configEnv.getProperty("spring.datasource.url"));
        postgresqlContainer.addEnv("POSTGRES_DEFAULT_USER", configEnv.getProperty("spring.datasource.username"));
        postgresqlContainer.addEnv("POSTGRES_DEFAULT_PASS", configEnv.getProperty("spring.datasource.password"));
        postgresqlContainer.start();
    }

    public static String getPostgresqlDBContainerUrl() {
        return postgresqlContainer.getJdbcUrl();
    }

}
