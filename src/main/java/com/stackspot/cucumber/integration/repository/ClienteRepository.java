package com.stackspot.cucumber.integration.repository;

import com.stackspot.cucumber.integration.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
