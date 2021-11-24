package com.cotemig.backend.agendamentoBarbearias.service;

import com.cotemig.backend.agendamentoBarbearias.model.Atendente;
import java.util.List;
import java.util.Optional;

public interface AtendenteService {
    Optional<Atendente> getAtendenteById(Integer id);
    List<Atendente> getAllAtendentes();
    void deleteAllAtendentes();
    void deleteAtendenteById(Integer id);
    void updateAtendenteById(Integer id, Atendente atendente);
    void updateAtendente(Atendente atendente);
    void insertAtendente(Atendente atendente);
    Optional<Atendente> getAtendenteByNome(String nome);
}
