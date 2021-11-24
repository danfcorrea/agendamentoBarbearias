package com.cotemig.backend.agendamentoBarbearias.controller;

import com.cotemig.backend.agendamentoBarbearias.model.Cliente;
import com.cotemig.backend.agendamentoBarbearias.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClienteRestController {

    @Autowired
    private ClienteService clienteService;

    @RequestMapping(value = "/rest/clientes/getAll", method = RequestMethod.GET)
    public List<Cliente> getClientes(){
        return clienteService.getAllClientes();
    }

    @RequestMapping(value = "/rest/clientes/get/{id}", method = RequestMethod.GET)
    public Optional<Cliente> getCliente(@PathVariable("id") Integer id){
        return clienteService.getClienteById(id);
    }

    @RequestMapping(value = "/rest/clientes/get/{nome}", method = RequestMethod.GET)
    public Optional<Cliente> getByNome(@PathVariable("nome") String nome){
        return clienteService.getClienteByNome(nome);
    }

    @RequestMapping(value = "/rest/clientes/deleteAll", method = RequestMethod.DELETE)
    public void deleteClientes(){
        clienteService.deleteAllClientes();
    }

    @RequestMapping(value = "/rest/clientes/delete/{id}", method = RequestMethod.DELETE)
    public void deleteCliente(@PathVariable("id") Integer id){
        clienteService.deleteClienteById(id);
    }

    @RequestMapping(value = "/rest/clientes/update/{id}", method = RequestMethod.POST)
    public void updateCliente(@RequestBody Cliente cliente, @PathVariable("id") Integer id){
        clienteService.updateClienteById(id, cliente);
    }

    @RequestMapping(value = "/rest/clientes/insert", method = RequestMethod.POST)
    public void insertCliente(@RequestBody Cliente cliente){
        clienteService.insertCliente(cliente);
    }
}
