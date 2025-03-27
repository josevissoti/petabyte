package com.curso.domains.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.curso.domains.Veiculo;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public class VeiculoDTO {

    private Long idVeiculo;

    @NotNull(message = "O campo descricao não pode ser nulo")
    @NotBlank(message = "O campo descricao não pode ser vazio")
    private String descricao;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAquisicao;

    @NotNull(message = "O campo valorAquisicoo não pode ser nulo")
    @Digits(integer = 15, fraction = 3)
    private BigDecimal valorAquisicao;

    @NotNull(message = "O campo nomeProprietario não pode ser nulo")
    @NotBlank(message = "O campo nomeProprietario não pode ser vazio")
    private String nomeProprietario;

    @NotNull(message = "O campo cpfProprietario não pode ser nulo")
    @NotBlank(message = "O campo cpfProprietario não pode ser vazio")
    private String cpfProprietario;

    public VeiculoDTO() {
    }

    public VeiculoDTO(Veiculo veiculo) {
        this.idVeiculo = veiculo.getIdVeiculo();
        this.descricao = veiculo.getDescricao();
        this.dataAquisicao = veiculo.getDataAquisicao();
        this.valorAquisicao = veiculo.getValorAquisicao();
        this.nomeProprietario = veiculo.getNomeProprietario();
        this.cpfProprietario = veiculo.getCpfProprietario();
    }

    public Long getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(Long idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(LocalDate dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    public BigDecimal getValorAquisicao() {
        return valorAquisicao;
    }

    public void setValorAquisicao(BigDecimal valorAquisicao) {
        this.valorAquisicao = valorAquisicao;
    }

    public String getNomeProprietario() {
        return nomeProprietario;
    }

    public void setNomeProprietario(String nomeProprietario) {
        this.nomeProprietario = nomeProprietario;
    }

    public String getCpfProprietario() {
        return cpfProprietario;
    }

    public void setCpfProprietario(String cpfProprietario) {
        this.cpfProprietario = cpfProprietario;
    }
}
