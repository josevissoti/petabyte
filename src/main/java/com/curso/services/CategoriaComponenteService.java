package com.curso.services;

import com.curso.domains.CategoriaComponente;
import com.curso.domains.dtos.CategoriaComponenteDTO;
import com.curso.repositories.CategoriaComponenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public CategoriaComponente findById(int id){
        Optional<CategoriaComponente> obj = categoriaComponenteRepo.findById(id);
        return obj.orElse(null);
    }

    public CategoriaComponente findByDescricao(String descricao){
        Optional<CategoriaComponente> obj = categoriaComponenteRepo.findByDescricao(descricao);
        return obj.orElse(null);
    }

    public CategoriaComponente create(CategoriaComponenteDTO dto){
        dto.setIdCategoriaComponente(null);
        CategoriaComponente obj = new CategoriaComponente(dto);
        return categoriaComponenteRepo.save(obj);
    }

}
