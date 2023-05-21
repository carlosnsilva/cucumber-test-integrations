package com.stackspot.cucumber.integration.setup;

import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

import static com.stackspot.cucumber.integration.setup.TestContainersSetup.*;

public class SpringBootContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {

        // Initialize and start test containers
        TestContainersSetup.initTestContainers(configurableApplicationContext.getEnvironment());

        // Inject containers' hostname and port into application context
        var values = TestPropertyValues.of(
                "spring.datasource.url=" + getPostgresqlDBContainerUrl()
        );

        values.applyTo(configurableApplicationContext);
    }
}