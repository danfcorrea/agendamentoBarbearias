package com.cotemig.backend.agendamentoBarbearias.service;

import com.cotemig.backend.agendamentoBarbearias.model.Servico;
import com.cotemig.backend.agendamentoBarbearias.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("servicoService")
public class ServicoServiceImpl implements ServicoService{

    @Qualifier("servicoRepository")
    @Autowired
    ServicoRepository servicoRepository;

    @Override
    public Optional<Servico> getServicoById(Integer id) {
        return servicoRepository.findById(id);
    }

    @Override
    public List<Servico> getAllServicos() {
        return servicoRepository.findAll();
    }

    @Override
    public void deleteAllServicos() {
        servicoRepository.deleteAll();
    }

    @Override
    public void deleteServicoById(Integer id) {
        servicoRepository.deleteById(id);
    }

    @Override
    public void updateServicoById(Integer id, Servico servico) {
        Optional<Servico> getServico = getServicoById(id);
        getServico.get().setDescricao(servico.getDescricao());
        getServico.get().setValor(servico.getValor());
        servicoRepository.save(servico);
    }

    @Override
    public void updateServico(Servico servico) {
        servicoRepository.save(servico);
    }

    @Override
    public void insertServico(Servico servico) {
        servicoRepository.save(servico);
    }
}
