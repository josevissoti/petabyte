package com.curso.services;

import com.curso.domains.dtos.CategoriaComponenteDTO;
import com.curso.repositories.CategoriaComponenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaComponenteService {

    @Autowired
    private CategoriaComponenteRepository categoriaComponenteRepo;

    public List<CategoriaComponenteDTO> findAll(){
        return categoriaComponenteRepo.findAll().stream()
                .map(obj -> new CategoriaComponenteDTO(obj))
                .collect(Collectors.toList());
    }

}
