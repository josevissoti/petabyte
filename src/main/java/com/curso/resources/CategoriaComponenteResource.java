package com.curso.resources;

import com.curso.domains.dtos.CategoriaComponenteDTO;
import com.curso.services.CategoriaComponenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categoriacomponente")
public class CategoriaComponenteResource {

    @Autowired
    private CategoriaComponenteService categoriaComponenteService;

    @GetMapping
    public ResponseEntity<List<CategoriaComponenteDTO>> findAll(){
        return ResponseEntity.ok().body(categoriaComponenteService.findAll());
    }

}
