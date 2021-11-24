package com.cotemig.backend.agendamentoBarbearias.controller;

import com.cotemig.backend.agendamentoBarbearias.model.Atendente;
import com.cotemig.backend.agendamentoBarbearias.service.AtendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AtendenteRestController {

    @Autowired
    private AtendenteService atendenteService;

    @RequestMapping(value = "/rest/atendentes/getAll", method = RequestMethod.GET)
    public List<Atendente> getAtendentes(){
        return atendenteService.getAllAtendentes();
    }

    @RequestMapping(value = "/rest/atendentes/get/{id}", method = RequestMethod.GET)
    public Optional<Atendente> getAtendente(@PathVariable("id") Integer id){
        return atendenteService.getAtendenteById(id);
    }

    @RequestMapping(value = "/rest/atendentes/get/{nome}", method = RequestMethod.GET)
    public Optional<Atendente> getByNome(@PathVariable("nome") String nome){
        return atendenteService.getAtendenteByNome(nome);
    }

    @RequestMapping(value = "/rest/atendentes/deleteAll", method = RequestMethod.DELETE)
    public void deleteAtendentes(){
        atendenteService.deleteAllAtendentes();
    }

    @RequestMapping(value = "/rest/atendentes/delete/{id}", method = RequestMethod.DELETE)
    public void deleteAtendente(@PathVariable("id") Integer id){
        atendenteService.deleteAtendenteById(id);
    }

    @RequestMapping(value = "/rest/atendentes/update/{id}", method = RequestMethod.POST)
    public void updateAtendente(@RequestBody Atendente atendente, @PathVariable("id") Integer id){
        atendenteService.updateAtendenteById(id, atendente);
    }

    @RequestMapping(value = "/rest/atendentes/insert", method = RequestMethod.POST)
    public void insertAtendente(@RequestBody Atendente atendente){
        atendenteService.insertAtendente(atendente);
    }
}
