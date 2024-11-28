package com.curso.services;

import com.curso.domains.Fornecedor;
import com.curso.domains.dtos.FornecedorDTO;
import com.curso.repositories.FornecedorRepository;
import com.curso.services.exceptions.DataIntegrityViolationException;
import com.curso.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepo;

    public List<FornecedorDTO> findAll() {
        return fornecedorRepo.findAll().stream()
                .map(obj -> new FornecedorDTO(obj))
                .collect(Collectors.toList());
    }

    public Fornecedor findById(int id) {
        Optional<Fornecedor> obj = fornecedorRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Fornecedor não encontrado. ID: " + id));
    }

    public Fornecedor findByRazaoSocial(String razaoSocial) {
        Optional<Fornecedor> obj = fornecedorRepo.findByRazaoSocial(razaoSocial);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Fornecedor não encontrado. Razão social: " + razaoSocial));
    }

    public Fornecedor create(FornecedorDTO dto) {
        dto.setIdForncedor(null);
        validaFornecedor(dto);
        Fornecedor obj = new Fornecedor(dto);
        return fornecedorRepo.save(obj);
    }

    public void validaFornecedor(FornecedorDTO dto){
        Optional<Fornecedor> obj = fornecedorRepo.findByRazaoSocial(dto.getRazaoSocial());
        if(obj.isPresent() && obj.get().getIdFornecedor() != dto.getIdForncedor()){
            throw new DataIntegrityViolationException("Razão social já cadastrada");
        }
    }

    public Fornecedor update(Integer id, FornecedorDTO objDto){
        objDto.setIdForncedor(id);
        Fornecedor oldObj = findById(id);
        validaFornecedor(objDto);
        oldObj = new Fornecedor(objDto);
        return fornecedorRepo.save(oldObj);
    }

    public void delete(Integer id){
        Fornecedor obj = findById(id);
        if(obj.getComponentes().size() > 0){
            throw new DataIntegrityViolationException("Fornecedor não pode ser deletado pois possui Componentes vinculádos");
        }
        fornecedorRepo.deleteById(id);
    }

}
