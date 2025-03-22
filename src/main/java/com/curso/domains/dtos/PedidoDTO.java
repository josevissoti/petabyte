package com.curso.domains.dtos;

import com.curso.domains.Pedido;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public class PedidoDTO {

    private UUID idPedido;

    @NotNull(message = "O campo descricao é requerido")
    private String descricao;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataInicio;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataEntrega;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate prazoMaximo;

    @NotNull(message = "O campo tipoEntrega é requerido")
    private Integer tipoEntrega;
    @NotNull(message = "O campo statusPedido requerido")
    private Integer statusPedido;

    @NotNull(message = "O campo funcionario é requerido")
    private Long funcionario;
    @NotNull(message = "O campo usuario é requerido")
    private Long usuario;
    private String nomeFuncionario;
    private String nomeUsuario;

    public PedidoDTO() {
    }

    public PedidoDTO(Pedido pedido) {
        this.idPedido = pedido.getIdPedido();
        this.descricao = pedido.getDescricao();
        this.dataInicio = pedido.getDataInicio();
        this.dataEntrega = pedido.getDataEntrega();
        this.prazoMaximo = pedido.getPrazoMaximo();
        this.tipoEntrega = pedido.getTipoEntrega().getId();
        this.statusPedido = pedido.getStatusPedido().getId();
        this.funcionario = pedido.getFuncionario().getIdPessoa();
        this.usuario = pedido.getUsuario().getIdPessoa();
        this.nomeFuncionario = pedido.getFuncionario().getNome();
        this.nomeUsuario = pedido.getUsuario().getNome();
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

    public Integer getTipoEntrega() {
        return tipoEntrega;
    }

    public void setTipoEntrega(Integer tipoEntrega) {
        this.tipoEntrega = tipoEntrega;
    }

    public Integer getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(Integer statusPedido) {
        this.statusPedido = statusPedido;
    }

    public Long getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Long funcionario) {
        this.funcionario = funcionario;
    }

    public Long getUsuario() {
        return usuario;
    }

    public void setUsuario(Long usuario) {
        this.usuario = usuario;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
}
