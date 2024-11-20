package com.curso.repositories;

import com.curso.domains.CategoriaComponente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaComponenteRepository extends JpaRepository<CategoriaComponente, Integer> {

}
