package com.stackspot.cucumber.integration.bdd.steps;

import com.stackspot.cucumber.integration.setup.SpringContextTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClienteExistenteStep extends SpringContextTest {

    @When("o cliente chama mais de uma {string} passando o JSON")
    public void o_cliente_chama_mais_de_uma_passando_o_json(String basePath, String body) {
        var spec = new RequestSpecBuilder().setBaseUri(baseURI()).setBasePath(basePath).setContentType(ContentType.JSON)
                .setBody(body)
                .build();
        // 2x
        RestAssured.given(spec).post();
        RestAssured.given(spec).post();
    }

    @Then("cliente duplicado deve receber o status code {int}")
    public void cliente_duplicado_deve_receber_o_status_code(Integer status) {
        assertEquals(409, status);
    }
}
