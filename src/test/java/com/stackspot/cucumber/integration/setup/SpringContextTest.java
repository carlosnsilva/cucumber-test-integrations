package com.stackspot.cucumber.integration.setup;

import com.stackspot.cucumber.integration.Application;
import io.cucumber.spring.CucumberContextConfiguration;
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

    @LocalServerPort
    protected int port;

    public String baseURI(){
        return "http://localhost:" + this.port;
    }

    @Test
    void whenSpringContextIsBootstrapped_thenNoExceptions() {
    }
}
