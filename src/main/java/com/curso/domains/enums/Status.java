package com.curso.domains.enums;

public enum Status {

    INATIVO(0, "INATIVO"),
    ATIVO(1, "ATIVO");

    private int idStatus;
    private String situacao;

    Status(int idStatus, String situacao) {
        this.idStatus = idStatus;
        this.situacao = situacao;
    }

    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public static Status toEnum(Integer idStatus) {
        if (idStatus == null) return null;
        for (Status x : Status.values()) {
            if (idStatus.equals(x.getIdStatus())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Status inválido");
    }
}
