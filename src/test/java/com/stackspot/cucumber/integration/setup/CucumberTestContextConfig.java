package com.stackspot.cucumber.integration.setup;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;

@TestConfiguration
@ComponentScan(basePackages = {"bdd"})
public class CucumberTestContextConfig {

}