package com.curso.repositories;

import com.curso.domains.Componente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ComponenteRepository extends JpaRepository<Componente, Long> {

    Optional<Componente> findByDescricao(String descricao);
}
