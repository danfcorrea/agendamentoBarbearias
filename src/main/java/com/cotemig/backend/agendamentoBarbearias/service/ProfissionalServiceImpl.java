package com.cotemig.backend.agendamentoBarbearias.service;

import com.cotemig.backend.agendamentoBarbearias.model.Profissional;
import com.cotemig.backend.agendamentoBarbearias.repository.ProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("profissionalService")
public class ProfissionalServiceImpl implements ProfissionalService{

    @Qualifier("profissionalRepository")
    @Autowired
    ProfissionalRepository profissionalRepository;

    @Override
    public Optional<Profissional> getProfissionalById(Integer id) {
        return profissionalRepository.findById(id);
    }

    @Override
    public List<Profissional> getAllProfissionais() {
        return profissionalRepository.findAll();
    }

    @Override
    public void deleteAllProfissionais() {
        profissionalRepository.deleteAll();
    }

    @Override
    public void deleteProfissionalById(Integer id) {
        profissionalRepository.deleteById(id);
    }

    @Override
    public void updateProfissionalById(Integer id, Profissional profissional) {
        Optional<Profissional> getProfissional = getProfissionalById(id);
        getProfissional.get().setNome(profissional.getNome());
        getProfissional.get().setFuncao(profissional.getFuncao());
        profissionalRepository.save(profissional);
    }

    @Override
    public void updateProfissional(Profissional profissional) {
        profissionalRepository.save(profissional);
    }

    @Override
    public void insertProfissional(Profissional profissional) {
        profissionalRepository.save(profissional);
    }

    @Override
    public Optional<Profissional> getProfissionalByNome(String nome) {
        return profissionalRepository.getProfissionalByNome(nome);
    }
}
