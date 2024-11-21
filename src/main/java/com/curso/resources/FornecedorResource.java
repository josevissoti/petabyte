package com.curso.resources;

import com.curso.domains.dtos.FornecedorDTO;
import com.curso.services.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/fornecedor")
public class FornecedorResource {

    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping
    public ResponseEntity<List<FornecedorDTO>> findAll(){
        return ResponseEntity.ok().body(fornecedorService.findAll());
    }

}
