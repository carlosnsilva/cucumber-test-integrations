package com.stackspot.cucumber.integration.setup;

import com.stackspot.cucumber.integration.Application;
import io.cucumber.java.BeforeAll;
import io.cucumber.spring.CucumberContextConfiguration;
import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;


@CucumberContextConfiguration
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(
        initializers = { SpringBootContextInitializer.class },
        classes = {Application.class, CucumberTestContextConfig.class}
)
public
class SpringContextTest {

    @LocalServerPort // 1
    protected int port;

    public String baseURI(){
        return "http://localhost:" + this.port;
    }

    @Test
    void whenSpringContextIsBootstrapped_thenNoExceptions() {
    }
}