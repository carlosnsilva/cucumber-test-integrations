package com.stackspot.cucumber.integration.integration.setup;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class SpringBootContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Value("path.docker.compose")
    private String composePath;

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {

        // Initialize and start test containers
        TestContainersSetup.initTestContainers(composePath);

    }
}
