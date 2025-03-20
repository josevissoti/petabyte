package com.curso.domains;

import com.curso.domains.enums.TipoPessoa;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario extends Pessoa {

    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<Pedido> pedidos = new ArrayList<>();

    public Usuario() {
        super();
        addTipoPessoa(TipoPessoa.USUARIO);
    }

    public Usuario(Long idPessoa, String nome, String cpf, LocalDate dataNascimento, String email, String senha) {
        super(idPessoa, nome, cpf, dataNascimento, email, senha);
        addTipoPessoa(TipoPessoa.USUARIO);
    }
}
