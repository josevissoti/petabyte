package com.curso.services;

import com.curso.domains.dtos.ComponenteDTO;
import com.curso.repositories.ComponenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComponenteService {

    @Autowired
    private ComponenteRepository componenteRepo;

    public List<ComponenteDTO> findAll(){
        return componenteRepo.findAll().stream()
                .map(obj -> new ComponenteDTO(obj))
                .collect(Collectors.toList());
    }
}
