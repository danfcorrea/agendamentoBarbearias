package com.cotemig.backend.agendamentoBarbearias.repository;

import com.cotemig.backend.agendamentoBarbearias.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("clienteRepository")
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Query(value = "SELECT * FROM CLIENTE WHERE nome = ?1", nativeQuery = true)
    Optional<Cliente> getClienteByNome(String nome);
}
