package com.cotemig.backend.agendamentoBarbearias.repository;

import com.cotemig.backend.agendamentoBarbearias.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("agendamentoRepository")
public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {

    @Query(value = "SELECT * FROM AGENDAMENTO WHERE data = ?1", nativeQuery = true)
    List<Agendamento> getAllAgendamentosByData(String data);

    @Query(value = "SELECT * FROM AGENDAMENTO WHERE atendente = ?1", nativeQuery = true)
    List<Agendamento> getAllAgendamentosByAtendente(Integer idAtendente);

    @Query(value = "SELECT * FROM AGENDAMENTO WHERE cliente = ?1", nativeQuery = true)
    List<Agendamento> getAllAgendamentosByCliente(Integer idCiente);

    @Query(value = "SELECT * FROM AGENDAMENTO WHERE profissional = ?1", nativeQuery = true)
    List<Agendamento> getAllAgendamentosByProfissional(Integer idPofissional);
}
