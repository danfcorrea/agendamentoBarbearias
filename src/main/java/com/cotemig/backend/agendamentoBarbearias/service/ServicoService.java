package com.cotemig.backend.agendamentoBarbearias.service;

import com.cotemig.backend.agendamentoBarbearias.model.Servico;

import java.util.List;
import java.util.Optional;

public interface ServicoService {
    Optional<Servico> getServicoById(Integer id);
    List<Servico> getAllServicos();
    void deleteAllServicos();
    void deleteServicoById(Integer id);
    void updateServicoById(Integer id, Servico servico);
    void updateServico(Servico servico);
    void insertServico(Servico servico);
}
