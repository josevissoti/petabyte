package com.curso.services;

import com.curso.domains.dtos.FornecedorDTO;
import com.curso.repositories.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepo;

    public List<FornecedorDTO> findAll(){
        return fornecedorRepo.findAll().stream()
                .map(obj -> new FornecedorDTO(obj))
                .collect(Collectors.toList());
    }

}
