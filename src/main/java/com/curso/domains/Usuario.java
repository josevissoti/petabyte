package com.curso.domains;

import com.curso.domains.dtos.UsuarioDTO;
import com.curso.domains.enums.TipoPessoa;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public Usuario(UsuarioDTO dto) {
        this.idPessoa = dto.getIdPessoa();
        this.nome = dto.getNome();
        this.cpf = dto.getCpf();
        this.dataNascimento = dto.getDataNascimento();
        this.email = dto.getEmail();
        this.senha = dto.getSenha();
        this.dataCriacao = dto.getDataCriacao();
        this.tipoPessoa = dto.getTipoPessoa().stream()
                .map(x -> x.getId()).collect(Collectors.toSet());
        addTipoPessoa(TipoPessoa.USUARIO);
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
