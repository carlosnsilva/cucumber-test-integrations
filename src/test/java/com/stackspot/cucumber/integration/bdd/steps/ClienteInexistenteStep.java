package com.stackspot.cucumber.integration.bdd.steps;

import com.stackspot.cucumber.integration.setup.SpringContextTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClienteInexistenteStep extends SpringContextTest {

    @When("o cliente chama {string} passando um id inexistente")
    public void oClienteChamaVClientesPassandoUmIdInexistente(String basePath) {
        var spec = new RequestSpecBuilder().setBaseUri(baseURI()).setBasePath(basePath)
                .build();
        RestAssured.given(spec).get();
    }

    @Then("deve retornar status code {int}")
    public void deveRetornarStatusCode(int status) {
        assertEquals(404, status);
    }

}
