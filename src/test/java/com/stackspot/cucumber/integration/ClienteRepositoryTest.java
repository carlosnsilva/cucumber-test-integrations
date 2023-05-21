package com.stackspot.cucumber.integration;

import com.stackspot.cucumber.integration.model.Cliente;
import com.stackspot.cucumber.integration.model.Conta;
import com.stackspot.cucumber.integration.repository.ClienteRepository;
import com.stackspot.cucumber.integration.repository.ContaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // deactivate the default behaviour
@DataJpaTest
class ClienteRepositoryTest {

    @Container
    static PostgreSQLContainer postgresqlContainer = new PostgreSQLContainer("postgres:11.1")
            .withDatabaseName("test")
            .withUsername("postgres")
            .withPassword("password");

    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgresqlContainer::getJdbcUrl);
        registry.add("spring.datasource.username", postgresqlContainer::getUsername);
        registry.add("spring.datasource.password", postgresqlContainer::getPassword);
    }

    @Autowired
    private ContaRepository contaRepository;
    @Autowired
    private ClienteRepository clienterepository;

    @Test
    void should_be_able_to_get_senior_consultant_by_technology(){
        //arrange
        Conta conta1 = new Conta();
        conta1.setTipo(Conta.ContaTipo.CORRENTE);
        conta1.setStatus(Conta.ContaStatus.ATIVA);

        Conta conta2 = new Conta();
        conta2.setTipo(Conta.ContaTipo.POUPANCA);
        conta2.setStatus(Conta.ContaStatus.ATIVA);

        Conta savedConte1 = contaRepository.save(conta1);
        Conta savedConte2 = contaRepository.save(conta2);

        assertNotNull(savedConte1.getId());
        assertNotNull(savedConte2.getId());


        Cliente cliente1 = new Cliente();
        cliente1.setCpf("cpf1");
        cliente1.setNome("Cliente1");
        cliente1.setEmail("cliente1@test.com");
        cliente1.setConta(conta1);

        Cliente cliente2 = new Cliente();
        cliente2.setCpf("cpf2");
        cliente2.setNome("Cliente2");
        cliente2.setEmail("cliente2@test.com");
        cliente2.setConta(conta2);

        Cliente savedCliente1 = clienterepository.save(cliente1);
        Cliente savedCliente2 = clienterepository.save(cliente2);

        assertNotNull(savedCliente1.getId());
        assertNotNull(savedCliente2.getId());

        //act
        List<Cliente> clientes = clienterepository.findAll();
        //assert
        assertEquals(2, clientes.size());
        assertEquals("Cliente1", clientes.get(0).getNome());
    }
}
