package com.stackspot.cucumber.integration.bdd.steps;

import com.stackspot.cucumber.integration.dto.ClienteDTO;
import com.stackspot.cucumber.integration.setup.SpringContextTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import lombok.RequiredArgsConstructor;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RequiredArgsConstructor
public class ClienteCriandoContaStep extends SpringContextTest {

    private ObjectMapper objectMapper = new ObjectMapper();

    @When("o cliente chama {string} passando o JSON")
    public void o_cliente_chama_passando_o_json(String basePath, String body) {
        var spec = new RequestSpecBuilder().setBaseUri(baseURI()).setBasePath(basePath).setContentType(ContentType.JSON)
                .setBody(body)
                .build();
        RestAssured.given(spec).post();
    }
    @Then("recebera o status code {int}")
    public void receberaOStatusCode(int status) {
        assertEquals(200, status);
    }

    @Then("e response JSON")
    public void e_response_json(String json) throws IOException {
        assertNotNull(json);
        ClienteDTO response = objectMapper.readValue(json, ClienteDTO.class);
        assertEquals(1L, response.getId());
    }

}
