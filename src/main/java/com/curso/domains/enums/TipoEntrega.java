package com.curso.domains.enums;

public enum TipoEntrega {
    EXPRESSO(0, "EXPRESSO"),
    NORMAL(1, "NORMAL"),
    INTERNACIONAL(2, "INTERNACIONAL");

    private Integer id;
    private String tipoEntrega;

    TipoEntrega(Integer id, String tipoEntrega) {
        this.id = id;
        this.tipoEntrega = tipoEntrega;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoEntrega() {
        return tipoEntrega;
    }

    public void setTipoEntrega(String tipoEntrega) {
        this.tipoEntrega = tipoEntrega;
    }

    public static TipoEntrega toEnum(Integer id) {
        if (id == null) return null;
        for (TipoEntrega x : TipoEntrega.values()) {
            if (id.equals(x.getId())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Tipo de Entrega inválida");
    }
}
