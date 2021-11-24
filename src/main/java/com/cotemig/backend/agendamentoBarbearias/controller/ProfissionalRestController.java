package com.cotemig.backend.agendamentoBarbearias.controller;

import com.cotemig.backend.agendamentoBarbearias.model.Profissional;
import com.cotemig.backend.agendamentoBarbearias.service.ProfissionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProfissionalRestController {

    @Autowired
    private ProfissionalService profissionalService;

    @RequestMapping(value = "/rest/profissional/getAll", method = RequestMethod.GET)
    public List<Profissional> getProfissionais(){
        return profissionalService.getAllProfissionais();
    }

    @RequestMapping(value = "/rest/profissional/get/{id}", method = RequestMethod.GET)
    public Optional<Profissional> getProfissional(@PathVariable("id") Integer id){
        return profissionalService.getProfissionalById(id);
    }

    @RequestMapping(value = "/rest/profissional/get/{nome}", method = RequestMethod.GET)
    public Optional<Profissional> getByNome(@PathVariable("nome") String nome){
        return profissionalService.getProfissionalByNome(nome);
    }

    @RequestMapping(value = "/rest/profissional/deleteAll", method = RequestMethod.DELETE)
    public void deleteProfissionais(){
        profissionalService.deleteAllProfissionais();
    }

    @RequestMapping(value = "/rest/profissional/delete/{id}", method = RequestMethod.DELETE)
    public void deleteProfissional(@PathVariable("id") Integer id){
        profissionalService.deleteProfissionalById(id);
    }

    @RequestMapping(value = "/rest/profissional/update/{id}", method = RequestMethod.POST)
    public void updateProfissional(@RequestBody Profissional profissional, @PathVariable("id") Integer id){
        profissionalService.updateProfissionalById(id, profissional);
    }

    @RequestMapping(value = "/rest/profissional/insert", method = RequestMethod.POST)
    public void insertProfissional(@RequestBody Profissional profissional){
        profissionalService.insertProfissional(profissional);
    }
}
