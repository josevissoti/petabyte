package com.curso.domains;

import com.curso.domains.enums.TipoPessoa;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "funcionario")
public class Funcionario extends Pessoa{

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

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
