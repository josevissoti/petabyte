package com.curso.resources;

import com.curso.domains.CategoriaComponente;
import com.curso.domains.dtos.CategoriaComponenteDTO;
import com.curso.services.CategoriaComponenteService;
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
@RequestMapping(value = "/categoriacomponente")
@Tag(name = "Categoria Componente", description = "API para gerenciamento de Categorias de Componentes")
public class CategoriaComponenteResource {

    @Autowired
    private CategoriaComponenteService categoriaComponenteService;

    @GetMapping
    @Operation(summary = "Listar todas as Categorias de Componentes",
            description = "Retorna uma Lista com todas as Categorias de Componentes cadastradas")
    public ResponseEntity<List<CategoriaComponenteDTO>> findAll() {
        return ResponseEntity.ok().body(categoriaComponenteService.findAll());
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Busca uma Categoria de Componente por ID",
            description = "Realiza a busca de uma Categoria de Componente por ID")
    public ResponseEntity<CategoriaComponenteDTO> findById(@PathVariable Integer id) {
        CategoriaComponente obj = this.categoriaComponenteService.findById(id);
        return ResponseEntity.ok().body(new CategoriaComponenteDTO(obj));
    }

    @GetMapping(value = "/descricao/{descricao}")
    @Operation(summary = "Busca uma Categoria de Componente por descrição",
            description = "Realiza a busca de uma Categoria de Componente por Descrição")
    public ResponseEntity<CategoriaComponenteDTO> findByDescricao(@PathVariable String descricao) {
        CategoriaComponente obj = this.categoriaComponenteService.findByDescricao(descricao);
        return ResponseEntity.ok().body(new CategoriaComponenteDTO(obj));
    }

    @PostMapping
    @Operation(summary = "Criar uma nova Categoria de Componente",
            description = "Cria uma nova Categoria de Componente com base nos dados fornecidos")
    public ResponseEntity<CategoriaComponenteDTO> create(@Valid @RequestBody CategoriaComponenteDTO dto) {
        CategoriaComponente categoriaComponente = categoriaComponenteService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(categoriaComponente.getIdCategoriaComponente()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    @Operation(summary = "Altera uma Categoria de Componente",
            description = "Altera uma Categoria de Componente existente")
    public ResponseEntity<CategoriaComponenteDTO> update(@PathVariable Integer id, @Valid @RequestBody CategoriaComponenteDTO objDto){
        CategoriaComponente Obj = categoriaComponenteService.update(id, objDto);
        return ResponseEntity.ok().body(new CategoriaComponenteDTO(Obj));
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Deletar uma Categoria de Componente",
            description = "Remove uma Categoria de Componente a partir de seu ID")
    public ResponseEntity<CategoriaComponenteDTO> delete(@PathVariable Integer id){
        categoriaComponenteService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
