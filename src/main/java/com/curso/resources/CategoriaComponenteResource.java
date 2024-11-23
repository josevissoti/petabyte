package com.curso.resources;

import com.curso.domains.CategoriaComponente;
import com.curso.domains.dtos.CategoriaComponenteDTO;
import com.curso.services.CategoriaComponenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/categoriacomponente")
public class CategoriaComponenteResource {

    @Autowired
    private CategoriaComponenteService categoriaComponenteService;

    @GetMapping
    public ResponseEntity<List<CategoriaComponenteDTO>> findAll() {
        return ResponseEntity.ok().body(categoriaComponenteService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoriaComponenteDTO> findById(@PathVariable Integer id) {
        CategoriaComponente obj = this.categoriaComponenteService.findById(id);
        return ResponseEntity.ok().body(new CategoriaComponenteDTO(obj));
    }

    @GetMapping(value = "/descricao/{descricao}")
    public ResponseEntity<CategoriaComponenteDTO> findByDescricao(@PathVariable String descricao) {
        CategoriaComponente obj = this.categoriaComponenteService.findByDescricao(descricao);
        return ResponseEntity.ok().body(new CategoriaComponenteDTO(obj));
    }

    @PostMapping
    public ResponseEntity<CategoriaComponenteDTO> create(@RequestBody CategoriaComponenteDTO dto) {
        CategoriaComponente categoriaComponente = categoriaComponenteService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(categoriaComponente.getIdCategoriaComponente()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
