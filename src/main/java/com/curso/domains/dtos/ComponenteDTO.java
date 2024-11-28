package com.curso.domains.dtos;

import com.curso.domains.Componente;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ComponenteDTO {

    private Long idComponente;

    @NotNull(message = "O campo descrição não pode ser nulo")
    @NotBlank(message = "O campo descrição não pode estar vazio")
    private String descricao;

    @NotNull(message = "O campo modelo não pode ser nulo")
    @NotBlank(message = "O campo modelo não pode estar vazio")
    private String modelo;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFabricacao;

    @NotNull(message = "O campo valor não pode ser nulo")
    @Digits(integer = 15, fraction = 2)
    private BigDecimal valor;

    @NotNull(message = "O campo desconto não pode ser nulo")
    @Digits(integer = 3, fraction = 2)
    private BigDecimal desconto;

    private int estoque;

    @NotNull(message = "O campo Categoria Componente é requerido")
    private int categoriaComponente;
    private String descricaoCategoriaComponente;

    @NotNull(message = "O campo Fornecedor é requerido")
    private int fornecedor;
    private String razaoSocial;
    private String cnpj;
    private String pais;
    private String estado;
    private String cidade;
    private String endereco;

    private int status;
    private int condicao;

    public ComponenteDTO() {
    }

    public ComponenteDTO(Componente componente) {
        this.idComponente = componente.getIdComponente();
        this.descricao = componente.getDescricao();
        this.modelo = componente.getModelo();
        this.dataFabricacao = componente.getDataFabricacao();
        this.valor = componente.getValor();
        this.desconto = componente.getDesconto();
        this.estoque = componente.getEstoque();
        this.categoriaComponente = componente.getCategoriaComponente().getIdCategoriaComponente();
        this.descricaoCategoriaComponente = componente.getCategoriaComponente().getDescricao();
        this.fornecedor = componente.getFornecedor().getIdFornecedor();
        this.razaoSocial = componente.getFornecedor().getRazaoSocial();
        this.cnpj = componente.getFornecedor().getCnpj();
        this.pais = componente.getFornecedor().getPais();
        this.estado = componente.getFornecedor().getEstado();
        this.cidade = componente.getFornecedor().getCidade();
        this.endereco = componente.getFornecedor().getEndereco();
        this.status = componente.getStatus().getIdStatus();
        this.condicao = componente.getCondicao().getIdCondicao();
    }

    public Long getIdComponente() {
        return idComponente;
    }

    public void setIdComponente(Long idComponente) {
        this.idComponente = idComponente;
    }

    public @NotNull(message = "O campo descrição não pode ser nulo") @NotBlank(message = "O campo descrição não pode estar vazio") String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotNull(message = "O campo descrição não pode ser nulo") @NotBlank(message = "O campo descrição não pode estar vazio") String descricao) {
        this.descricao = descricao;
    }

    public @NotNull(message = "O campo modelo não pode ser nulo") @NotBlank(message = "O campo modelo não pode estar vazio") String getModelo() {
        return modelo;
    }

    public void setModelo(@NotNull(message = "O campo modelo não pode ser nulo") @NotBlank(message = "O campo modelo não pode estar vazio") String modelo) {
        this.modelo = modelo;
    }

    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(LocalDate dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public @Digits(integer = 15, fraction = 2) BigDecimal getValor() {
        return valor;
    }

    public void setValor(@Digits(integer = 15, fraction = 2) BigDecimal valor) {
        this.valor = valor;
    }

    public @Digits(integer = 3, fraction = 2) BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(@Digits(integer = 3, fraction = 2) BigDecimal desconto) {
        this.desconto = desconto;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    @NotNull(message = "O campo Categoria Componente é requerido")
    public int getCategoriaComponente() {
        return categoriaComponente;
    }

    public void setCategoriaComponente(@NotNull(message = "O campo Categoria Componente é requerido") int categoriaComponente) {
        this.categoriaComponente = categoriaComponente;
    }

    public String getDescricaoCategoriaComponente() {
        return descricaoCategoriaComponente;
    }

    public void setDescricaoCategoriaComponente(String descricaoCategoriaComponente) {
        this.descricaoCategoriaComponente = descricaoCategoriaComponente;
    }

    @NotNull(message = "O campo Fornecedor é requerido")
    public int getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(@NotNull(message = "O campo Fornecedor é requerido") int fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCondicao() {
        return condicao;
    }

    public void setCondicao(int condicao) {
        this.condicao = condicao;
    }
}
