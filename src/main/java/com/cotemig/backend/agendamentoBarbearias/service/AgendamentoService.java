package com.cotemig.backend.agendamentoBarbearias.service;

import com.cotemig.backend.agendamentoBarbearias.model.Agendamento;

import java.util.List;
import java.util.Optional;

public interface AgendamentoService {
    Optional<Agendamento> getAgendamentoById(Integer id);
    List<Agendamento> getAllAgendamentos();
    void deleteAllAgendamentos();
    void deleteAgendamentoById(Integer id);
    void updateAgendamentoById(Integer id, Agendamento agendamento);
    void updateAgendamento(Agendamento agendamento);
    void insertAgendamento(Agendamento agendamento);
    List<Agendamento> getAllAgendamentosByData(String data);
    List<Agendamento> getAllAgendamentosByAtendente(Integer idAtendente);
    List<Agendamento> getAllAgendamentosByCliente(Integer idCliente);
    List<Agendamento> getAllAgendamentosByProfissional(Integer idProfissional);
}
