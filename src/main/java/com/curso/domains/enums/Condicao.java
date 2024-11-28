package com.curso.domains.enums;

public enum Condicao {
    NOVO(0, "NOVO"),
    SEMIUSADO(1, "SEMIUSADO"),
    USADO(2, "USADO");

    private int idCondicao;
    private String situacao;

    Condicao(int idCondicao, String situacao) {
        this.idCondicao = idCondicao;
        this.situacao = situacao;
    }

    public int getIdCondicao() {
        return idCondicao;
    }

    public void setIdCondicao(int idCondicao) {
        this.idCondicao = idCondicao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public static Condicao toEnum(Integer idCondicao) {
        if (idCondicao == null) return null;
        for (Condicao x : Condicao.values()) {
            if (idCondicao.equals(x.getIdCondicao())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Condição inválida");
    }
}
