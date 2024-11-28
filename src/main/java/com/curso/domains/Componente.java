package com.curso.domains;

import com.curso.domains.dtos.ComponenteDTO;
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

    @NotBlank
    @NotNull
    @Column(unique = true)
    private String descricao;

    @NotBlank
    @NotNull
    private String modelo;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFabricacao;

    @Digits(integer = 15, fraction = 2)
    private BigDecimal valor;

    @Digits(integer = 3, fraction = 2)
    private BigDecimal desconto;

    @Digits(integer = 15, fraction = 2)
    private BigDecimal valorDesconto;

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
        this.valor = BigDecimal.ZERO;
        this.desconto = BigDecimal.ZERO;
        this.valorDesconto = BigDecimal.ZERO;
        this.status = Status.ATIVO;
        this.condicao = Condicao.NOVO;
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

        this.valorDesconto = valor.subtract(valor.multiply(desconto.divide(new BigDecimal(100))))
                .setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public Componente(ComponenteDTO dto){
        this.idComponente = dto.getIdComponente();
        this.descricao = dto.getDescricao();
        this.modelo = dto.getModelo();
        this.dataFabricacao = dto.getDataFabricacao();
        this.valor = dto.getValor();
        this.desconto = dto.getDesconto();
        this.estoque = dto.getEstoque();

        this.status = Status.toEnum(dto.getStatus());
        this.condicao = Condicao.toEnum(dto.getCondicao());

        this.categoriaComponente = new CategoriaComponente();
        this.categoriaComponente.setIdCategoriaComponente(dto.getCategoriaComponente());

        this.fornecedor = new Fornecedor();
        this.fornecedor.setIdFornecedor(dto.getFornecedor());

        this.valorDesconto = valor.subtract(valor.multiply(desconto.divide(new BigDecimal(100))))
                .setScale(2, BigDecimal.ROUND_HALF_UP);
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

    public BigDecimal getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(BigDecimal valorDesconto) {
        this.valorDesconto = valorDesconto;
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
