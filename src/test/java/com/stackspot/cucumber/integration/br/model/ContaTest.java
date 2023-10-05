package com.stackspot.cucumber.integration.br.model;

import org.junit.jupiter.api.Test;

import com.stackspot.cucumber.integration.model.*;
import pl.pojo.tester.api.assertion.Method;

import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;

public class ContaTest {

    @Test
    public void testar_getter_setter(){
        assertPojoMethodsFor(Conta.class)
                .testing(Method.GETTER, Method.SETTER, Method.EQUALS, Method.CONSTRUCTOR, Method.TO_STRING);
    }
}
