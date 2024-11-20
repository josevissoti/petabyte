package com.curso.domains;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
@Table(name = "categoriacomponente")
public class CategoriaComponente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_categoriacomponente")
    private Integer idCategoriaComponente;

    @NotBlank @NotNull
    private String descricao;

    public CategoriaComponente() {
    }

    public CategoriaComponente(Integer idCategoriaComponente, String descricao) {
        this.idCategoriaComponente = idCategoriaComponente;
        this.descricao = descricao;
    }

    public Integer getIdCategoriaComponente() {
        return idCategoriaComponente;
    }

    public void setIdCategoriaComponente(Integer idCategoriaComponente) {
        this.idCategoriaComponente = idCategoriaComponente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CategoriaComponente that = (CategoriaComponente) o;
        return Objects.equals(idCategoriaComponente, that.idCategoriaComponente) && Objects.equals(descricao, that.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCategoriaComponente, descricao);
    }
}
