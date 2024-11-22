package com.curso.services;

import com.curso.domains.Componente;
import com.curso.domains.dtos.ComponenteDTO;
import com.curso.repositories.ComponenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public Componente findById(Long id){
        Optional<Componente> obj = componenteRepo.findById(id);
        return obj.orElse(null);
    }

    public Componente findByDescricao(String descricao){
        Optional<Componente> obj = componenteRepo.findByDescricao(descricao);
        return obj.orElse(null);
    }
}
