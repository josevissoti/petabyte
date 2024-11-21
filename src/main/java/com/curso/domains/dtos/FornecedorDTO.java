package com.curso.domains.dtos;

import com.curso.domains.Fornecedor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class FornecedorDTO {

    private Integer idForncedor;

    @NotNull(message = "O campo razão social não pode ser nulo")
    @NotBlank(message = "O campo razão social não pode estar vazio")
    private String razaoSocial;

    @NotNull(message = "O campo CNPJ não pode ser nulo")
    @NotBlank(message = "O campo CNPJ não pode estar vazio")
    private String cnpj;

    @NotNull(message = "O campo país não pode ser nulo")
    @NotBlank(message = "O campo país não pode estar vazio")
    private String pais;

    @NotNull(message = "O campo estado não pode ser nulo")
    @NotBlank(message = "O campo estado não pode estar vazio")
    private String estado;

    @NotNull(message = "O campo cidade não pode ser nulo")
    @NotBlank(message = "O campo cidade não pode estar vazio")
    private String cidade;

    @NotNull(message = "O campo endereço não pode ser nulo")
    @NotBlank(message = "O campo endereço não pode estar vazio")
    private String endereco;

    private int status;

    public FornecedorDTO() {
    }

    public FornecedorDTO(Fornecedor fornecedor) {
        this.idForncedor = fornecedor.getIdFornecedor();
        this.razaoSocial = fornecedor.getRazaoSocial();
        this.cnpj = fornecedor.getCnpj();
        this.pais = fornecedor.getPais();
        this.estado = fornecedor.getEstado();
        this.cidade = fornecedor.getCidade();
        this.endereco = fornecedor.getEndereco();
        this.status = fornecedor.getStatus().getIdStatus();
    }

    public Integer getIdForncedor() {
        return idForncedor;
    }

    public void setIdForncedor(Integer idForncedor) {
        this.idForncedor = idForncedor;
    }

    public @NotNull(message = "O campo razão social não pode ser nulo") @NotBlank(message = "O campo razão social não pode estar vazio") String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(@NotNull(message = "O campo razão social não pode ser nulo") @NotBlank(message = "O campo razão social não pode estar vazio") String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public @NotNull(message = "O campo CNPJ não pode ser nulo") @NotBlank(message = "O campo CNPJ não pode estar vazio") String getCnpj() {
        return cnpj;
    }

    public void setCnpj(@NotNull(message = "O campo CNPJ não pode ser nulo") @NotBlank(message = "O campo CNPJ não pode estar vazio") String cnpj) {
        this.cnpj = cnpj;
    }

    public @NotNull(message = "O campo país não pode ser nulo") @NotBlank(message = "O campo país não pode estar vazio") String getPais() {
        return pais;
    }

    public void setPais(@NotNull(message = "O campo país não pode ser nulo") @NotBlank(message = "O campo país não pode estar vazio") String pais) {
        this.pais = pais;
    }

    public @NotNull(message = "O campo estado não pode ser nulo") @NotBlank(message = "O campo estado não pode estar vazio") String getEstado() {
        return estado;
    }

    public void setEstado(@NotNull(message = "O campo estado não pode ser nulo") @NotBlank(message = "O campo estado não pode estar vazio") String estado) {
        this.estado = estado;
    }

    public @NotNull(message = "O campo cidade não pode ser nulo") @NotBlank(message = "O campo cidade não pode estar vazio") String getCidade() {
        return cidade;
    }

    public void setCidade(@NotNull(message = "O campo cidade não pode ser nulo") @NotBlank(message = "O campo cidade não pode estar vazio") String cidade) {
        this.cidade = cidade;
    }

    public @NotNull(message = "O campo endereço não pode ser nulo") @NotBlank(message = "O campo endereço não pode estar vazio") String getEndereco() {
        return endereco;
    }

    public void setEndereco(@NotNull(message = "O campo endereço não pode ser nulo") @NotBlank(message = "O campo endereço não pode estar vazio") String endereco) {
        this.endereco = endereco;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
