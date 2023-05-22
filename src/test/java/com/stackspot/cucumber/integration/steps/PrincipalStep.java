package com.stackspot.cucumber.integration.steps;

import io.cucumber.java.pt.*;

public class PrincipalStep {
    @Dado("o endpoint {string} {string} {string} {string}")
    public void o_endpoint(String string, String string2, String string3, String string4) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Quando("envia a requisicao {string}")
    public void envia_a_requisicao(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Entao("devera retornar statusCode {string}")
    public void devera_retornar_status_code(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Entao("o payload contendo a resposta da requisicao {string}")
    public void o_payload_contendo_a_resposta_da_requisicao(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
