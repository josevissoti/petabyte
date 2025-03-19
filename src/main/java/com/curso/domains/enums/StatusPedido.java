package com.curso.domains.enums;

public enum StatusPedido {
    DISTRIBUIDORA(0, "DISTRIBUIDORA"),
    CAMINHO(1, "CAMINHO"),
    ENTREGUE(2, "ENTREGUE");

    private Integer id;
    private String tipoStatusPedido;

    StatusPedido(Integer id, String tipoStatusPedido) {
        this.id = id;
        this.tipoStatusPedido = tipoStatusPedido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoStatusPedido() {
        return tipoStatusPedido;
    }

    public void setTipoStatusPedido(String tipoStatusPedido) {
        this.tipoStatusPedido = tipoStatusPedido;
    }

    public static StatusPedido toEnum(Integer id) {
        if (id == null) return null;
        for (StatusPedido x : StatusPedido.values()) {
            if (id.equals(x.getId())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Status de Pedido inválido");
    }
}
