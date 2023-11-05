package com.stackspot.cucumber.integration.br.mapper;

import com.stackspot.cucumber.integration.mapper.ContaMapper;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static com.stackspot.cucumber.integration.br.mapper.ContaMapperMockFactory.*;


public class ContaMapperTest {

    private final ContaMapper mapper = new ContaMapper();

    @Test
    public void contaToContaTest(){
        final var input = criaContaDTOMockFactory();
        final var output = mapper.toConta(input);

        Assert.assertEquals(input.getStatus(), output.getStatus());
        Assert.assertEquals(input.getTipo(), output.getTipo());
    }

    @Test
    public void contaFromContaTest(){
        final var input = criaContaMockFactory();
        final var output = mapper.fromConta(input);

        Assert.assertEquals(input.getStatus(), output.getStatus());
        Assert.assertEquals(input.getTipo(), output.getTipo());
    }

}
