package com.cotemig.backend.agendamentoBarbearias.service;

import com.cotemig.backend.agendamentoBarbearias.model.Atendente;
import com.cotemig.backend.agendamentoBarbearias.repository.AtendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("atendenteService")
public class AtendenteServiceImpl implements AtendenteService{

    @Qualifier("atendenteRepository")
    @Autowired
    AtendenteRepository atendenteRepository;

    @Override
    public Optional<Atendente> getAtendenteById(Integer id) {
        return atendenteRepository.findById(id);
    }

    @Override
    public List<Atendente> getAllAtendentes() {
        return atendenteRepository.findAll();
    }

    @Override
    public void deleteAllAtendentes() {
        atendenteRepository.deleteAll();
    }

    @Override
    public void deleteAtendenteById(Integer id) {
        atendenteRepository.deleteById(id);
    }

    @Override
    public void updateAtendenteById(Integer id, Atendente atendente) {
        Optional<Atendente> getAtendente = getAtendenteById(id);
        getAtendente.get().setNome(atendente.getNome());
        atendenteRepository.save(atendente);
    }

    @Override
    public void updateAtendente(Atendente atendente) {
        atendenteRepository.save(atendente);
    }

    @Override
    public void insertAtendente(Atendente atendente) {
        atendenteRepository.save(atendente);
    }

    @Override
    public Optional<Atendente> getAtendenteByNome(String nome) {
        return atendenteRepository.getAtendenteByNome(nome);
    }
}
