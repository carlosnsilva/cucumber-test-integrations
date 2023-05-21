package com.stackspot.cucumber.integration.integration.setup;

import com.stackspot.cucumber.integration.Application;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(initializers = {SpringBootContextInitializer.class})
public class CucumberSpringConfiguration {
}
