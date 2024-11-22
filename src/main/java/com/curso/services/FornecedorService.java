package com.curso.services;

import com.curso.domains.Fornecedor;
import com.curso.domains.dtos.FornecedorDTO;
import com.curso.repositories.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public Fornecedor findById(int id){
        Optional<Fornecedor> obj = fornecedorRepo.findById(id);
        return obj.orElse(null);
    }

    public Fornecedor findByRazaoSocial(String razaoSocial){
        Optional<Fornecedor> obj = fornecedorRepo.findByRazaoSocial(razaoSocial);
        return obj.orElse(null);
    }

    public Fornecedor create(FornecedorDTO dto){
        dto.setIdForncedor(null);
        Fornecedor obj = new Fornecedor(dto);
        return fornecedorRepo.save(obj);
    }

}
