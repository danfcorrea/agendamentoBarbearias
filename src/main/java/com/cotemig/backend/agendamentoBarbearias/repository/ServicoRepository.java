package com.cotemig.backend.agendamentoBarbearias.repository;

import com.cotemig.backend.agendamentoBarbearias.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("servicoRepository")
public interface ServicoRepository extends JpaRepository<Servico, Integer> {
}
