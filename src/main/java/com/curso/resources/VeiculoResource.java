package com.curso.resources;

import com.curso.domains.Veiculo;
import com.curso.domains.dtos.VeiculoDTO;
import com.curso.services.VeiculoService;
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
@RequestMapping(value = "/veiculo")
@Tag(name = "Veiculo", description = "API para gerenciamento de Veiculos")
public class VeiculoResource {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping
    @Operation(summary = "Listar todos os Veiculos",
            description = "Retorna uma Lista com todos os Veiculos cadastrados")
    public ResponseEntity<List<VeiculoDTO>> findAll() {
        return ResponseEntity.ok().body(veiculoService.findAll());
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Busca um Veiculo por ID",
            description = "Realiza a busca de um Veiculo por ID")
    public ResponseEntity<VeiculoDTO> findById(@PathVariable Long id) {
        Veiculo obj = this.veiculoService.findById(id);
        return ResponseEntity.ok().body(new VeiculoDTO(obj));
    }

    @GetMapping(value = "/cpfProprietario/{cpfProprietario}")
    @Operation(summary = "Busca um Veiculo por CPF do Proprietário",
            description = "Realiza a busca de um Veiculo por CPF do Proprietário")
    public ResponseEntity<VeiculoDTO> findByCpfProprietario(@PathVariable String cpfProprietario) {
        Veiculo obj = this.veiculoService.findByCpfProprietario(cpfProprietario);
        return ResponseEntity.ok().body(new VeiculoDTO(obj));
    }

    @PostMapping
    @Operation(summary = "Criar um novo Veiculo",
            description = "Cria um novo Veiculo com base nos dados fornecidos")
    public ResponseEntity<VeiculoDTO> create(@Valid @RequestBody VeiculoDTO veiculoDTO) {
        Veiculo veiculo = veiculoService.create(veiculoDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(veiculo.getIdVeiculo()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    @Operation(summary = "Altera um Veiculo",
            description = "Altera um Veiculo existente")
    public ResponseEntity<VeiculoDTO> update(@PathVariable Long id, @Valid @RequestBody VeiculoDTO objDTO) {
        Veiculo veiculo = veiculoService.update(id, objDTO);
        return ResponseEntity.ok().body(new VeiculoDTO(veiculo));
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Deletar um Veiculo",
            description = "Remove um Veiculo a partir de seu ID")
    public ResponseEntity<VeiculoDTO> delete(@PathVariable Long id) {
        veiculoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
