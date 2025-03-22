package com.curso.domains;

import com.curso.domains.enums.StatusPedido;
import com.curso.domains.enums.TipoEntrega;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idPedido;
    private String descricao;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataInicio = LocalDate.now();

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataEntrega;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate prazoMaximo;
    private TipoEntrega tipoEntrega;
    private StatusPedido statusPedido;

    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idfuncionario")
    private Funcionario funcionario;

    public Pedido() {
    }

    public Pedido(UUID idPedido, String descricao, LocalDate prazoMaximo, TipoEntrega tipoEntrega, StatusPedido statusPedido, Usuario usuario, Funcionario funcionario) {
        this.idPedido = idPedido;
        this.descricao = descricao;
        this.prazoMaximo = prazoMaximo;
        this.tipoEntrega = tipoEntrega;
        this.statusPedido = statusPedido;
        this.usuario = usuario;
        this.funcionario = funcionario;
    }

    public UUID getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(UUID idPedido) {
        this.idPedido = idPedido;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public LocalDate getPrazoMaximo() {
        return prazoMaximo;
    }

    public void setPrazoMaximo(LocalDate prazoMaximo) {
        this.prazoMaximo = prazoMaximo;
    }

    public TipoEntrega getTipoEntrega() {
        return tipoEntrega;
    }

    public void setTipoEntrega(TipoEntrega tipoEntrega) {
        this.tipoEntrega = tipoEntrega;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(idPedido, pedido.idPedido);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idPedido);
    }
}
