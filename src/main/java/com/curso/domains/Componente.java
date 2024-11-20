package com.curso.domains;

import com.curso.domains.enums.Condicao;
import com.curso.domains.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "componente")
public class Componente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_componente")
    private Long idComponente;

    @NotBlank @NotNull
    private String descricao;

    @NotBlank @NotNull
    private String modelo;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFabricacao;

    @Digits(integer = 15, fraction = 2)
    private BigDecimal valor;

    @Digits(integer = 3, fraction = 2)
    private BigDecimal desconto;

    private int estoque;

    @ManyToOne
    @JoinColumn(name = "idcategoriacomponente")
    private CategoriaComponente categoriaComponente;

    @ManyToOne
    @JoinColumn(name = "idfornecedor")
    private Fornecedor fornecedor;

    @Enumerated(EnumType.ORDINAL)
    @JoinColumn(name = "status")
    private Status status;

    @Enumerated(EnumType.ORDINAL)
    @JoinColumn(name = "condicao")
    private Condicao condicao;

    public Componente() {
    }

    public Componente(Long idComponente, String descricao, String modelo, LocalDate dataFabricacao, BigDecimal valor, BigDecimal desconto, int estoque, CategoriaComponente categoriaComponente, Fornecedor fornecedor, Status status, Condicao condicao) {
        this.idComponente = idComponente;
        this.descricao = descricao;
        this.modelo = modelo;
        this.dataFabricacao = dataFabricacao;
        this.valor = valor;
        this.desconto = desconto;
        this.estoque = estoque;
        this.categoriaComponente = categoriaComponente;
        this.fornecedor = fornecedor;
        this.status = status;
        this.condicao = condicao;
    }

    public Long getIdComponente() {
        return idComponente;
    }

    public void setIdComponente(Long idComponente) {
        this.idComponente = idComponente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(LocalDate dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public CategoriaComponente getCategoriaComponente() {
        return categoriaComponente;
    }

    public void setCategoriaComponente(CategoriaComponente categoriaComponente) {
        this.categoriaComponente = categoriaComponente;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Condicao getCondicao() {
        return condicao;
    }

    public void setCondicao(Condicao condicao) {
        this.condicao = condicao;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Componente that = (Componente) o;
        return Objects.equals(idComponente, that.idComponente) && Objects.equals(descricao, that.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idComponente, descricao);
    }
}
