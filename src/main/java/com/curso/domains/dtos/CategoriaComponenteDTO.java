package com.curso.domains.dtos;

import com.curso.domains.CategoriaComponente;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CategoriaComponenteDTO {

    private Integer idCategoriaComponente;

    @NotNull(message = "O campo descrição não pode ser nulo")
    @NotBlank(message = "O campo descrição não pode estar vazio")
    private String descricao;

    public CategoriaComponenteDTO() {
    }

    public CategoriaComponenteDTO(CategoriaComponente categoriaComponente) {
        this.idCategoriaComponente = categoriaComponente.getIdCategoriaComponente();
        this.descricao = categoriaComponente.getDescricao();
    }

    public Integer getIdCategoriaComponente() {
        return idCategoriaComponente;
    }

    public void setIdCategoriaComponente(Integer idCategoriaComponente) {
        this.idCategoriaComponente = idCategoriaComponente;
    }

    public @NotNull(message = "O campo descrição não pode ser nulo") @NotBlank(message = "O campo descrição não pode estar vazio") String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotNull(message = "O campo descrição não pode ser nulo") @NotBlank(message = "O campo descrição não pode estar vazio") String descricao) {
        this.descricao = descricao;
    }
}
