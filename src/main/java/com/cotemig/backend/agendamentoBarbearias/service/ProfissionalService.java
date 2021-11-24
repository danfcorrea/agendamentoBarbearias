package com.cotemig.backend.agendamentoBarbearias.service;

import com.cotemig.backend.agendamentoBarbearias.model.Profissional;

import java.util.List;
import java.util.Optional;

public interface ProfissionalService {
    Optional<Profissional> getProfissionalById(Integer id);
    List<Profissional> getAllProfissionais();
    void deleteAllProfissionais();
    void deleteProfissionalById(Integer id);
    void updateProfissionalById(Integer id, Profissional profissional);
    void updateProfissional(Profissional profissional);
    void insertProfissional(Profissional profissional);
    Optional<Profissional> getProfissionalByNome(String nome);
}
