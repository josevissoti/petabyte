package com.curso.services;

import com.curso.domains.CategoriaComponente;
import com.curso.domains.Componente;
import com.curso.domains.Fornecedor;
import com.curso.domains.enums.Condicao;
import com.curso.domains.enums.Status;
import com.curso.repositories.CategoriaComponenteRepository;
import com.curso.repositories.ComponenteRepository;
import com.curso.repositories.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

@Service
public class DBService {

    @Autowired
    private CategoriaComponenteRepository categoriaComponenteRepo;

    @Autowired
    private FornecedorRepository fornecedorRepo;

    @Autowired
    private ComponenteRepository componenteRepo;

    public void initDB() {

        CategoriaComponente categoriaComponente01 = new CategoriaComponente(null, "SSD");
        CategoriaComponente categoriaComponente02 = new CategoriaComponente(null, "Processador");
        CategoriaComponente categoriaComponente03 = new CategoriaComponente(null, "Placa de vídeo");

        Fornecedor fornecedor01 = new Fornecedor(null, "AMD", "147910124", "Brasil", "Rio de Janeiro", "Rio de Janeiro", "Rua Belo Horizonte n176", Status.ATIVO);
        Fornecedor fornecedor02 = new Fornecedor(null, "NVidia", "840148054", "Brasil", "São Paulo", "Campinas", "Av. Liberdade n738", Status.ATIVO);
        Fornecedor fornecedor03 = new Fornecedor(null, "Kingston", "749302647", "EUA", "New York", "New York", "St. Mark's Place N30", Status.ATIVO);

        Componente componente01 = new Componente(null, "GeForce RTX 4080", "GDDR6X", LocalDate.of(2022, Month.DECEMBER, 05), new BigDecimal("15000.00"), new BigDecimal("20"), 50, categoriaComponente03, fornecedor02, Status.ATIVO, Condicao.NOVO);
        Componente componente02 = new Componente(null, "SSD Kingston 1TB", "A400", LocalDate.of(2020, Month.APRIL, 21), new BigDecimal("219.99"), new BigDecimal("10.00"), 400, categoriaComponente01, fornecedor03, Status.ATIVO, Condicao.SEMIUSADO);
        Componente componente03 = new Componente(null, "Ryzen 5", "5600G", LocalDate.of(2019, Month.JULY, 12), new BigDecimal("1199.99"), new BigDecimal("15.50"), 267, categoriaComponente02, fornecedor01, Status.ATIVO, Condicao.USADO);

        categoriaComponenteRepo.save(categoriaComponente01);
        categoriaComponenteRepo.save(categoriaComponente02);
        categoriaComponenteRepo.save(categoriaComponente03);
        fornecedorRepo.save(fornecedor01);
        fornecedorRepo.save(fornecedor02);
        fornecedorRepo.save(fornecedor03);
        componenteRepo.save(componente01);
        componenteRepo.save(componente02);
        componenteRepo.save(componente03);

    }

}
