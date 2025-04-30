package com.curso.resources;

import com.curso.domains.Funcionario;
import com.curso.domains.dtos.FuncionarioDTO;
import com.curso.services.FuncionarioService;
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
@RequestMapping(value = "/funcionario")
@Tag(name = "Funcionario", description = "API para gerenciamento de Funcionarios")
public class FuncionarioResource {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    @Operation(summary = "Listar todos os Funcionarios",
            description = "Retorna uma Lista com todos os Funcionarios cadastrados")
    public ResponseEntity<List<FuncionarioDTO>> findAll() {
        return ResponseEntity.ok().body(funcionarioService.findAll());
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Busca um Funcionario por ID",
            description = "Realiza a busca de um Funcionario por ID")
    public ResponseEntity<FuncionarioDTO> findById(@PathVariable Long id) {
        Funcionario obj = this.funcionarioService.findById(id);
        return ResponseEntity.ok().body(new FuncionarioDTO(obj));
    }

    @GetMapping(value = "/cpf/{cpf}")
    @Operation(summary = "Busca um Funcionario por CPF",
            description = "Realiza a busca de um Funcionario por CPF")
    public ResponseEntity<FuncionarioDTO> findByCpf(@PathVariable String cpf) {
        Funcionario obj = this.funcionarioService.findByCpf(cpf);
        return ResponseEntity.ok().body(new FuncionarioDTO(obj));
    }

    @GetMapping(value = "/email/{email}")
    @Operation(summary = "Busca um Funcionario por Email",
            description = "Realiza a busca de um Funcionario por Email")
    public ResponseEntity<FuncionarioDTO> findByEmail(@PathVariable String email) {
        Funcionario obj = this.funcionarioService.findByEmail(email);
        return ResponseEntity.ok().body(new FuncionarioDTO(obj));
    }

    @PostMapping
    @Operation(summary = "Criar um novo Funcionario",
            description = "Cria um novo Funcionario com base nos dados fornecidos")
    public ResponseEntity<FuncionarioDTO> create(@Valid @RequestBody FuncionarioDTO objDto) {
        Funcionario newObj = funcionarioService.create(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getIdPessoa()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    @Operation(summary = "Altera um Funcionario",
            description = "Altera um Funcionario existente")
    public ResponseEntity<FuncionarioDTO> update(@PathVariable Long id, @Valid @RequestBody FuncionarioDTO objDto) {
        Funcionario obj = funcionarioService.update(id, objDto);
        return ResponseEntity.ok().body(new FuncionarioDTO(obj));
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Deletar um Funcionario",
            description = "Remove um Funcionario a partir de seu ID")
    public ResponseEntity<FuncionarioDTO> delete(@PathVariable Long id) {
        funcionarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
