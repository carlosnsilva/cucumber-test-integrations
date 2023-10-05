package com.stackspot.cucumber.integration.br.mapper;

import com.stackspot.cucumber.integration.mapper.ClienteMapper;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static com.stackspot.cucumber.integration.br.mapper.ClienteMapperMockFactory.clienteMockFactory;

public class ClienteMapperTest {

    private final ClienteMapper mapper = new ClienteMapper(null);

    @Test
    public void clienteToFromTest(){
        final var input = clienteMockFactory();
        System.out.println(input);
        final var output = mapper.fromDTO(input);

        Assert.assertEquals(input.getCpf(), output.getCpf());
        Assert.assertEquals(input.getNome(), output.getNome());

    }
}
