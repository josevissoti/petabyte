package com.curso.resources;

import com.curso.domains.Componente;
import com.curso.domains.dtos.ComponenteDTO;
import com.curso.services.ComponenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/componente")
public class ComponenteResource {

    @Autowired
    private ComponenteService componenteService;

    @GetMapping
    public ResponseEntity<List<ComponenteDTO>> findAll(){
        return ResponseEntity.ok().body(componenteService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ComponenteDTO> findById(@PathVariable Long id){
        Componente obj = this.componenteService.findById(id);
        return ResponseEntity.ok().body(new ComponenteDTO(obj));
    }

    @GetMapping(value = "/descricao/{descricao}")
    public ResponseEntity<ComponenteDTO> findByDescricao(@PathVariable String descricao){
        Componente obj = this.componenteService.findByDescricao(descricao);
        return ResponseEntity.ok().body(new ComponenteDTO(obj));
    }

}
