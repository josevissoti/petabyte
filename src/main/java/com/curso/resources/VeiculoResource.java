package com.curso.resources;

import com.curso.domains.Veiculo;
import com.curso.domains.dtos.VeiculoDTO;
import com.curso.services.VeiculoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/veiculo")
public class VeiculoResource {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping
    public ResponseEntity<List<VeiculoDTO>> findAll() {
        return ResponseEntity.ok().body(veiculoService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<VeiculoDTO> findById(@PathVariable Long id) {
        Veiculo obj = this.veiculoService.findById(id);
        return ResponseEntity.ok().body(new VeiculoDTO(obj));
    }

    @GetMapping(value = "/cpfProprietario/{cpfProprietario}")
    public ResponseEntity<VeiculoDTO> findByCpfProprietario(@PathVariable String cpfProprietario) {
        Veiculo obj = this.veiculoService.findByCpfProprietario(cpfProprietario);
        return ResponseEntity.ok().body(new VeiculoDTO(obj));
    }

    @PostMapping
    public ResponseEntity<VeiculoDTO> create(@Valid @RequestBody VeiculoDTO veiculoDTO) {
        Veiculo veiculo = veiculoService.create(veiculoDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(veiculo.getIdVeiculo()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<VeiculoDTO> update(@PathVariable Long id, @Valid @RequestBody VeiculoDTO objDTO) {
        Veiculo veiculo = veiculoService.update(id, objDTO);
        return ResponseEntity.ok().body(new VeiculoDTO(veiculo));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<VeiculoDTO> delete(@PathVariable Long id) {
        veiculoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
