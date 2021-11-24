package com.cotemig.backend.agendamentoBarbearias.repository;

import com.cotemig.backend.agendamentoBarbearias.model.Atendente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("atendenteRepository")
public interface AtendenteRepository extends JpaRepository<Atendente, Integer> {

    @Query(value = "SELECT * FROM ATENDENTE WHERE nome = ?1", nativeQuery = true)
    Optional<Atendente> getAtendenteByNome(String nome);
}
