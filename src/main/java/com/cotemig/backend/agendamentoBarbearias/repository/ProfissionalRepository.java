package com.cotemig.backend.agendamentoBarbearias.repository;

import com.cotemig.backend.agendamentoBarbearias.model.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("profissionalRepository")
public interface ProfissionalRepository extends JpaRepository<Profissional, Integer> {

    @Query(value = "SELECT * FROM PROFISSIONAL WHERE nome = ?1", nativeQuery = true)
    Optional<Profissional> getProfissionalByNome(String nome);
}
