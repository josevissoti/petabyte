package com.curso.resources;

import com.curso.domains.Funcionario;
import com.curso.domains.dtos.FuncionarioDTO;
import com.curso.services.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/funcionario")
public class FuncionarioResource {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<FuncionarioDTO>> findAll() {
        return ResponseEntity.ok().body(funcionarioService.fundAll());
    }

    @GetMapping(value = "/cpf/{cpf}")
    public ResponseEntity<FuncionarioDTO> findByCpf(@PathVariable String cpf) {
        Funcionario obj = this.funcionarioService.findByCpf(cpf);
        return ResponseEntity.ok().body(new FuncionarioDTO(obj));
    }

    @GetMapping(value = "/email/{email}")
    public ResponseEntity<FuncionarioDTO> findByEmail(@PathVariable String email) {
        Funcionario obj = this.funcionarioService.findByEmail(email);
        return ResponseEntity.ok().body(new FuncionarioDTO(obj));
    }

    @PostMapping
    public ResponseEntity<FuncionarioDTO> create(@Valid @RequestBody FuncionarioDTO objDto) {
        Funcionario newObj = funcionarioService.create(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getIdPessoa()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<FuncionarioDTO> update(@PathVariable Long id, @Valid @RequestBody FuncionarioDTO objDto) {
        Funcionario obj = funcionarioService.update(id, objDto);
        return ResponseEntity.ok().body(new FuncionarioDTO(obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<FuncionarioDTO> delete(@PathVariable Long id) {
        funcionarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
