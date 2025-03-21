package com.curso.domains;

import com.curso.domains.dtos.FuncionarioDTO;
import com.curso.domains.enums.TipoPessoa;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Funcionario extends Pessoa {

    @Id
    @OneToMany(mappedBy = "funcionario")
    private List<Pedido> pedidos = new ArrayList<>();

    public Funcionario(List<Pedido> pedidos) {
        super();
        addTipoPessoa(TipoPessoa.FUNCIONARIO);
    }

    public Funcionario(Long idPessoa, String nome, String cpf, LocalDate dataNascimento, String email, String senha) {
        super(idPessoa, nome, cpf, dataNascimento, email, senha);
        addTipoPessoa(TipoPessoa.FUNCIONARIO);
    }

    public Funcionario(FuncionarioDTO dto) {
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
        addTipoPessoa(TipoPessoa.FUNCIONARIO);
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
