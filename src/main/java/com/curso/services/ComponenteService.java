package com.curso.services;

import com.curso.domains.CategoriaComponente;
import com.curso.domains.Componente;
import com.curso.domains.Fornecedor;
import com.curso.domains.dtos.ComponenteDTO;
import com.curso.repositories.CategoriaComponenteRepository;
import com.curso.repositories.ComponenteRepository;
import com.curso.repositories.FornecedorRepository;
import com.curso.services.exceptions.DataIntegrityViolationException;
import com.curso.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ComponenteService {

    @Autowired
    private ComponenteRepository componenteRepo;

    @Autowired
    private CategoriaComponenteRepository categoriaComponenteRepo;

    @Autowired
    private FornecedorRepository fornecedorRepo;

    public List<ComponenteDTO> findAll() {
        return componenteRepo.findAll().stream()
                .map(obj -> new ComponenteDTO(obj))
                .collect(Collectors.toList());
    }

    public Componente findById(Long id) {
        Optional<Componente> obj = componenteRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Componente não encontrado. ID: " + id));
    }

    public Componente findByDescricao(String descricao) {
        Optional<Componente> obj = componenteRepo.findByDescricao(descricao);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Componente não encontrado. Descrição: " + descricao));
    }

    public Componente create(ComponenteDTO dto){
        dto.setIdComponente(null);
        validaComponente(dto);
        Componente obj = new Componente(dto);
        return componenteRepo.save(obj);
    }

    public void validaComponente(ComponenteDTO dto){
        Optional<Componente> obj = componenteRepo.findByDescricao(dto.getDescricao());
        if(obj.isPresent() && obj.get().getIdComponente() != dto.getIdComponente()){
            throw new DataIntegrityViolationException("Descrição já cadastrada");
        }

        Optional<CategoriaComponente> categoriaComponente = categoriaComponenteRepo.findById(dto.getCategoriaComponente());
        if (!categoriaComponente.isPresent()){
            throw new DataIntegrityViolationException("Categoria de Componente - " + dto.getCategoriaComponente() + " não está cadastrada.");
        }

        Optional<Fornecedor> fornecedor = fornecedorRepo.findById(dto.getFornecedor());
        if(!fornecedor.isPresent()){
            throw new DataIntegrityViolationException("Fornecedor - " + dto.getFornecedor() + " não está cadastrado.");
        }
    }

    public Componente update(Long id, ComponenteDTO objDto){
        objDto.setIdComponente(id);
        Componente oldObj = findById(id);
        validaComponente(objDto);
        oldObj = new Componente(objDto);
        return componenteRepo.save(oldObj);
    }

    public void delete(Long id){
        Componente obj = findById(id);
        componenteRepo.deleteById(id);
    }
}
