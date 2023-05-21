package com.stackspot.cucumber.integration.bdd.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VersionStepDefinitions {

    @When("the client calls \\/version")
    public void the_client_calls_version() {
    }
    @Then("the client receives status code of {int}")
    public void the_client_receives_status_code_of(Integer status) {
        assertEquals(200, status);
    }
    @Then("the client receives server version {double}")
    public void the_client_receives_server_version(Double version) {
        assertEquals(1.0, version);
    }
}
