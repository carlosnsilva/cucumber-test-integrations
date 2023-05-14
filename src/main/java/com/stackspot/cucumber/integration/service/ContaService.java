package com.stackspot.cucumber.integration.service;

import com.stackspot.cucumber.integration.model.Conta;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ContaService {

    private RestTemplate clientConta = new RestTemplate();
    private static String url = "http://localhost:8081/v1/busca/conta/";

    public ResponseEntity<Conta> getConta(String cpf) throws Exception {
        ResponseEntity<Conta> response = clientConta.getForEntity(url + cpf, Conta.class);

        if (response.getStatusCode() == HttpStatus.OK){
            return response;
        }
        else{
            throw new Exception("Cliente sem conta");
        }

    }
}
