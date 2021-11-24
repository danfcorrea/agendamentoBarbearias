package com.cotemig.backend.agendamentoBarbearias.service;

import com.cotemig.backend.agendamentoBarbearias.model.Agendamento;
import com.cotemig.backend.agendamentoBarbearias.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("agendamentoService")
public class AgendamentoServiceImpl implements AgendamentoService{

    @Qualifier("agendamentoRepository")
    @Autowired
    AgendamentoRepository agendamentoRepository;

    @Override
    public Optional<Agendamento> getAgendamentoById(Integer id) {
        return agendamentoRepository.findById(id);
    }

    @Override
    public List<Agendamento> getAllAgendamentos() {
        return agendamentoRepository.findAll();
    }

    @Override
    public void deleteAllAgendamentos() {
        agendamentoRepository.deleteAll();
    }

    @Override
    public void deleteAgendamentoById(Integer id) {
        agendamentoRepository.deleteById(id);
    }

    @Override
    public void updateAgendamentoById(Integer id, Agendamento agendamento) {
        Optional<Agendamento> getAgendamento =getAgendamentoById(id);
        getAgendamento.get().setData(agendamento.getData());
        getAgendamento.get().setHora(agendamento.getHora());
        getAgendamento.get().setServico(agendamento.getServico());
        getAgendamento.get().setProfissional(agendamento.getProfissional());
        getAgendamento.get().setCliente(agendamento.getCliente());
        agendamentoRepository.save(agendamento);
    }

    @Override
    public void updateAgendamento(Agendamento agendamento) {
        agendamentoRepository.save(agendamento);
    }

    @Override
    public void insertAgendamento(Agendamento agendamento) {
        agendamentoRepository.save(agendamento);
    }

    @Override
    public List<Agendamento> getAllAgendamentosByData(String data) {
        return agendamentoRepository.getAllAgendamentosByData(data);
    }

    @Override
    public List<Agendamento> getAllAgendamentosByAtendente(Integer idAtendente) {
        return agendamentoRepository.getAllAgendamentosByAtendente(idAtendente);
    }

    @Override
    public List<Agendamento> getAllAgendamentosByCliente(Integer idCliente) {
        return agendamentoRepository.getAllAgendamentosByCliente(idCliente);
    }

    @Override
    public List<Agendamento> getAllAgendamentosByProfissional(Integer idProfissional) {
        return agendamentoRepository.getAllAgendamentosByProfissional(idProfissional);
    }
}
