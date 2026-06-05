package br.com.gs2espv.model;

public enum StatusMissao {

    PLANEJADA("Planejada"),

    EM_ANDAMENTO("Em Andamento"),

    CONCLUIDA("Concluída"),

    CANCELADA("Cancelada");


    private final String descricao;


    StatusMissao(String descricao) {
        this.descricao = descricao;
    }


    public String getDescricao() {
        return descricao;
    }


    public static StatusMissao fromOpcao(int opcao) {
        return switch (opcao) {
            case 1 -> PLANEJADA;
            case 2 -> EM_ANDAMENTO;
            case 3 -> CONCLUIDA;
            case 4 -> CANCELADA;
            default -> null;
        };
    }
}
