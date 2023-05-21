package com.stackspot.cucumber.integration.setup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.ConfigurableEnvironment;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.containers.output.Slf4jLogConsumer;
import org.testcontainers.junit.jupiter.Container;

public class TestContainersSetup {

    @Container
    static PostgreSQLContainer postgresqlContainer = new PostgreSQLContainer("postgres:11.1")
            .withDatabaseName("test")
            .withUsername("postgres")
            .withPassword("password");

    private static final Logger POSTGRES_LOGGER = LoggerFactory.getLogger("container.postgresql");

    private static final String POSTGRES_DEFAULT_URL = "POSTGRES_DEFAULT_URL";
    private static final String POSTGRES_DEFAULT_USER = "POSTGRES_DEFAULT_USER";
    private static final String POSTGRES_DEFAULT_PASS = "POSTGRES_DEFAULT_PASS";

    public static void initTestContainers(ConfigurableEnvironment configEnv) {
        postgresqlContainer.addEnv(POSTGRES_DEFAULT_URL, configEnv.getProperty("spring.datasource.url"));
        postgresqlContainer.addEnv(POSTGRES_DEFAULT_USER, configEnv.getProperty("spring.datasource.username"));
        postgresqlContainer.addEnv(POSTGRES_DEFAULT_PASS, configEnv.getProperty("spring.datasource.password"));

        postgresqlContainer.start();
        postgresqlContainer.followOutput(new Slf4jLogConsumer(POSTGRES_LOGGER));
    }

    public static String getPostgresqlDBContainerUrl() {
        return postgresqlContainer.getJdbcUrl();
    }

}
