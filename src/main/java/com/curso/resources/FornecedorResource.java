package com.curso.resources;

import com.curso.domains.Fornecedor;
import com.curso.domains.dtos.FornecedorDTO;
import com.curso.services.FornecedorService;
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
@RequestMapping(value = "/fornecedor")
@Tag(name = "Fornecedor", description = "API para gerenciamento de Fornecedores")
public class FornecedorResource {

    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping
    @Operation(summary = "Listar todos os Fornecedores",
            description = "Retorna uma Lista com todos os Fornecedores cadastrados")
    public ResponseEntity<List<FornecedorDTO>> findAll() {
        return ResponseEntity.ok().body(fornecedorService.findAll());
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Busca um Fornecedor por ID",
            description = "Realiza a busca de um Fornecedor por ID")
    public ResponseEntity<FornecedorDTO> findById(@PathVariable Integer id) {
        Fornecedor obj = this.fornecedorService.findById(id);
        return ResponseEntity.ok().body(new FornecedorDTO(obj));
    }

    @GetMapping(value = "/razaoSocial/{razaoSocial}")
    @Operation(summary = "Busca um Fornecedor por Razão Social",
            description = "Realiza a busca de um Fornecedor por Razão Social")
    public ResponseEntity<FornecedorDTO> findByRazaoSocial(@PathVariable String razaoSocial) {
        Fornecedor obj = this.fornecedorService.findByRazaoSocial(razaoSocial);
        return ResponseEntity.ok().body(new FornecedorDTO(obj));
    }

    @PostMapping
    @Operation(summary = "Criar um novo Fornecedor",
            description = "Cria um novo Fornecedor com base nos dados fornecidos")
    public ResponseEntity<FornecedorDTO> create(@Valid @RequestBody FornecedorDTO dto) {
        Fornecedor fornecedor = fornecedorService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}")
                .buildAndExpand(fornecedor.getIdFornecedor()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    @Operation(summary = "Altera um Fornecedor",
            description = "Altera um Fornecedor existente")
    public ResponseEntity<FornecedorDTO> update(@PathVariable Integer id, @Valid @RequestBody FornecedorDTO objDto){
        Fornecedor Obj = fornecedorService.update(id, objDto);
        return ResponseEntity.ok().body(new FornecedorDTO(Obj));
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Deletar um Fornecedor",
            description = "Remove um Fornecedor a partir de seu ID")
    public ResponseEntity<FornecedorDTO> delete(@PathVariable Integer id){
        fornecedorService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
