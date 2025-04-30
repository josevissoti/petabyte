package com.curso.resources;

import com.curso.domains.Componente;
import com.curso.domains.dtos.ComponenteDTO;
import com.curso.services.ComponenteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/componente")
@Tag(name = "Componente", description = "API para gerenciamento de Componentes de Computador")
public class ComponenteResource {

    @Autowired
    private ComponenteService componenteService;

    @GetMapping
    @Operation(summary = "Listar todos os Componentes",
            description = "Retorna uma Lista com todos os Componentes cadastrados")
    public ResponseEntity<List<ComponenteDTO>> findAll() {
        return ResponseEntity.ok().body(componenteService.findAll());
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Busca um Componente por ID",
            description = "Realiza a busca de um Componente por ID")
    public ResponseEntity<ComponenteDTO> findById(@PathVariable Long id) {
        Componente obj = this.componenteService.findById(id);
        return ResponseEntity.ok().body(new ComponenteDTO(obj));
    }

    @GetMapping(value = "/descricao/{descricao}")
    @Operation(summary = "Busca um Componente por Descrição",
            description = "Realiza a busca de um Componente por Descrição")
    public ResponseEntity<ComponenteDTO> findByDescricao(@PathVariable String descricao) {
        Componente obj = this.componenteService.findByDescricao(descricao);
        return ResponseEntity.ok().body(new ComponenteDTO(obj));
    }

    @PostMapping
    @Operation(summary = "Criar um novo Componente",
            description = "Cria um novo Componente com base nos dados fornecidos")
    public ResponseEntity<ComponenteDTO> create(@Valid @RequestBody ComponenteDTO dto){
        Componente componente = componenteService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(componente.getIdComponente()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    @Operation(summary = "Altera um Componente",
            description = "Altera um Componente existente")
    public ResponseEntity<ComponenteDTO> update(@PathVariable Long id, @Valid @RequestBody ComponenteDTO objDto){
        Componente Obj = componenteService.update(id, objDto);
        return ResponseEntity.ok().body(new ComponenteDTO(Obj));
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Deletar um Componente",
            description = "Remove um Componente a partir de seu ID")
    public ResponseEntity<ComponenteDTO> delete(@PathVariable Long id){
        componenteService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
