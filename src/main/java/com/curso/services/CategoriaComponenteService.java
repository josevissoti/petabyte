package com.curso.services;

import com.curso.domains.CategoriaComponente;
import com.curso.domains.dtos.CategoriaComponenteDTO;
import com.curso.repositories.CategoriaComponenteRepository;
import com.curso.services.exceptions.DataIntegrityViolationException;
import com.curso.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaComponenteService {

    @Autowired
    private CategoriaComponenteRepository categoriaComponenteRepo;

    public List<CategoriaComponenteDTO> findAll() {
        return categoriaComponenteRepo.findAll().stream()
                .map(obj -> new CategoriaComponenteDTO(obj))
                .collect(Collectors.toList());
    }

    public CategoriaComponente findById(int id) {
        Optional<CategoriaComponente> obj = categoriaComponenteRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Categoria de Componente não enontrada. ID: " + id));
    }

    public CategoriaComponente findByDescricao(String descricao) {
        Optional<CategoriaComponente> obj = categoriaComponenteRepo.findByDescricao(descricao);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Categoria de Componente não encontrada. Descrição: " + descricao));
    }

    public CategoriaComponente create(CategoriaComponenteDTO dto) {
        dto.setIdCategoriaComponente(null);
        validaCategoriaComponente(dto);
        CategoriaComponente obj = new CategoriaComponente(dto);
        return categoriaComponenteRepo.save(obj);
    }

    public void validaCategoriaComponente(CategoriaComponenteDTO dto){
        Optional<CategoriaComponente> obj = categoriaComponenteRepo.findByDescricao(dto.getDescricao());
        if(obj.isPresent() && obj.get().getIdCategoriaComponente() != dto.getIdCategoriaComponente()){
            throw new DataIntegrityViolationException("Descrição já cadastrada");
        }
    }

    public CategoriaComponente update(Integer id, CategoriaComponenteDTO objDto){
        objDto.setIdCategoriaComponente(id);
        CategoriaComponente oldObj = findById(id);
        validaCategoriaComponente(objDto);
        oldObj = new CategoriaComponente(objDto);
        return categoriaComponenteRepo.save(oldObj);
    }

    public void delete(Integer id){
        CategoriaComponente obj = findById(id);
        if(obj.getComponentes().size() > 0){
            throw new DataIntegrityViolationException("Categoria de Componente não pode ser deletada pois possuí Componentes vinculádos");
        }
        categoriaComponenteRepo.deleteById(id);
    }

}
