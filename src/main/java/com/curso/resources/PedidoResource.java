package com.curso.resources;

import com.curso.domains.Pedido;
import com.curso.domains.dtos.PedidoDTO;
import com.curso.services.PedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/pedido")
public class PedidoResource {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<PedidoDTO>> findAll() {
        return ResponseEntity.ok().body(pedidoService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PedidoDTO> findById(@PathVariable UUID id) {
        Pedido obj = this.pedidoService.findById(id);
        return ResponseEntity.ok().body(new PedidoDTO(obj));
    }

    @PostMapping
    public ResponseEntity<PedidoDTO> create(@Valid @RequestBody PedidoDTO objDto) {
        Pedido newObj = pedidoService.create(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getIdPedido()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PedidoDTO> update(@PathVariable UUID id, @Valid @RequestBody PedidoDTO objDto) {
        Pedido obj = pedidoService.update(id, objDto);
        return ResponseEntity.ok().body(new PedidoDTO(obj));
    }
}
