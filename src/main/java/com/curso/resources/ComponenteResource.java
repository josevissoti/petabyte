package com.curso.resources;

import com.curso.domains.Componente;
import com.curso.domains.dtos.ComponenteDTO;
import com.curso.services.ComponenteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/componente")
public class ComponenteResource {

    @Autowired
    private ComponenteService componenteService;

    @GetMapping
    public ResponseEntity<List<ComponenteDTO>> findAll() {
        return ResponseEntity.ok().body(componenteService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ComponenteDTO> findById(@PathVariable Long id) {
        Componente obj = this.componenteService.findById(id);
        return ResponseEntity.ok().body(new ComponenteDTO(obj));
    }

    @GetMapping(value = "/descricao/{descricao}")
    public ResponseEntity<ComponenteDTO> findByDescricao(@PathVariable String descricao) {
        Componente obj = this.componenteService.findByDescricao(descricao);
        return ResponseEntity.ok().body(new ComponenteDTO(obj));
    }

    @PostMapping
    public ResponseEntity<ComponenteDTO> create(@Valid @RequestBody ComponenteDTO dto){
        Componente componente = componenteService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(componente.getIdComponente()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ComponenteDTO> update(@PathVariable Long id, @Valid @RequestBody ComponenteDTO objDto){
        Componente Obj = componenteService.update(id, objDto);
        return ResponseEntity.ok().body(new ComponenteDTO(Obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ComponenteDTO> delete(@PathVariable Long id){
        componenteService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
