package com.cotemig.backend.agendamentoBarbearias.controller;

import com.cotemig.backend.agendamentoBarbearias.model.Agendamento;
import com.cotemig.backend.agendamentoBarbearias.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AgendamentoRestController {

    @Autowired
    private AgendamentoService agendamentoService;

    @RequestMapping(value = "/rest/agendamentos/getAll", method = RequestMethod.GET)
    public List<Agendamento> getAgendamentos(){
        return agendamentoService.getAllAgendamentos();
    }

    @RequestMapping(value = "/rest/agendamentos/get/{id}", method = RequestMethod.GET)
    public Optional<Agendamento> getAgendamento(@PathVariable("id") Integer id){
        return agendamentoService.getAgendamentoById(id);
    }

    @RequestMapping(value = "/rest/agendamentos/getAllByData/{data}", method = RequestMethod.GET)
    public List<Agendamento> getAllByData(@PathVariable("data") String data) {
        return agendamentoService.getAllAgendamentosByData(data);
    }

    @RequestMapping(value = "/rest/agendamentos/getAllByAtendente/{id}", method = RequestMethod.GET)
    public List<Agendamento> getAllByAtendente(@PathVariable("id") Integer id) {
        return agendamentoService.getAllAgendamentosByAtendente(id);
    }

    @RequestMapping(value = "/rest/agendamentos/getAllByCliente/{id}", method = RequestMethod.GET)
    public List<Agendamento> getAllByCliente(@PathVariable("id") Integer id) {
        return agendamentoService.getAllAgendamentosByCliente(id);
    }

    @RequestMapping(value = "/rest/agendamentos/getAllByProfissional/{id}", method = RequestMethod.GET)
    public List<Agendamento> getAllByData(@PathVariable("id") Integer id) {
        return agendamentoService.getAllAgendamentosByProfissional(id);
    }

    @RequestMapping(value = "/rest/agendamentos/deleteAll", method = RequestMethod.DELETE)
    public void deleteAgendamentos(){
        agendamentoService.deleteAllAgendamentos();
    }

    @RequestMapping(value = "/rest/agendamentos/delete/{id}", method = RequestMethod.DELETE)
    public void deleteAgendamento(@PathVariable("id") Integer id){
        agendamentoService.deleteAgendamentoById(id);
    }

    @RequestMapping(value = "/rest/agendamentos/update/{id}", method = RequestMethod.POST)
    public void updateAgendamento(@RequestBody Agendamento agendamento, @PathVariable("id") Integer id){
        agendamentoService.updateAgendamentoById(id, agendamento);
    }

    @RequestMapping(value = "/rest/agendamentos/insert", method = RequestMethod.POST)
    public void insertAgendamento(@RequestBody Agendamento agendamento){
        agendamentoService.insertAgendamento(agendamento);
    }


}
