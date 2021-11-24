package com.cotemig.backend.agendamentoBarbearias.service;

import com.cotemig.backend.agendamentoBarbearias.model.Cliente;
import java.util.List;
import java.util.Optional;

public interface ClienteService {
    Optional<Cliente> getClienteById(Integer id);
    List<Cliente> getAllClientes();
    void deleteAllClientes();
    void deleteClienteById(Integer id);
    void updateClienteById(Integer id, Cliente cliente);
    void updateCliente(Cliente cliente);
    void insertCliente(Cliente cliente);
    Optional<Cliente> getClienteByNome(String nome);
}
