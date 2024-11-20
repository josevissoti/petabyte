package com.curso.domains;

import com.curso.domains.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
@Table(name = "fornecedor")
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_fornecedor")
    private Integer idFornecedor;

    @NotBlank @NotNull
    private String razaoSocial;

    @NotBlank @NotNull
    private String cnpj;

    @NotBlank @NotNull
    private String pais;

    @NotBlank @NotNull
    private String estado;

    @NotBlank @NotNull
    private String cidade;

    @NotBlank @NotNull
    private String endereco;

    @Enumerated(EnumType.ORDINAL)
    @JoinColumn(name = "status")
    private Status status;

    public Fornecedor() {
    }

    public Fornecedor(Integer idFornecedor, String razaoSocial, String cnpj, String pais, String estado, String cidade, String endereco, Status status) {
        this.idFornecedor = idFornecedor;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.pais = pais;
        this.estado = estado;
        this.cidade = cidade;
        this.endereco = endereco;
        this.status = status;
    }

    public Integer getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Integer idFornecedor) {
        this.idFornecedor = idFornecedor;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Fornecedor that = (Fornecedor) o;
        return Objects.equals(idFornecedor, that.idFornecedor) && Objects.equals(razaoSocial, that.razaoSocial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFornecedor, razaoSocial);
    }
}
