package com.cotemig.backend.agendamentoBarbearias.controller;

import com.cotemig.backend.agendamentoBarbearias.model.Servico;
import com.cotemig.backend.agendamentoBarbearias.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ServicoRestController {

    @Autowired
    private ServicoService servicoService;

    @RequestMapping(value = "/rest/servicos/getAll", method = RequestMethod.GET)
    public List<Servico> getServicos(){
        return servicoService.getAllServicos();
    }

    @RequestMapping(value = "/rest/servicos/get/{id}", method = RequestMethod.GET)
    public Optional<Servico> getServico(@PathVariable("id") Integer id){
        return servicoService.getServicoById(id);
    }

    @RequestMapping(value = "/rest/servicos/deleteAll", method = RequestMethod.DELETE)
    public void deleteServicos(){
        servicoService.deleteAllServicos();
    }

    @RequestMapping(value = "/rest/servicos/delete/{id}", method = RequestMethod.DELETE)
    public void deleteServico(@PathVariable("id") Integer id){
        servicoService.deleteServicoById(id);
    }

    @RequestMapping(value = "/rest/servicos/update/{id}", method = RequestMethod.POST)
    public void updateServico(@RequestBody Servico servico, @PathVariable("id") Integer id){
        servicoService.updateServicoById(id, servico);
    }

    @RequestMapping(value = "/rest/servicos/insert", method = RequestMethod.POST)
    public void insertServico(@RequestBody Servico servico){
        servicoService.insertServico(servico);
    }
}
