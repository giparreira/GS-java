package br.com.gs2espv.model;

public class Missao {

    /** Nome identificador da missão. */
    private String nome;

    /** Área de impacto na Terra (ex: Agricultura, Clima, Saúde). */
    private String areaImpacto;

    /** Descrição do objetivo principal da missão. */
    private String objetivo;

    /** ODS (Objetivo de Desenvolvimento Sustentável) relacionado (1–17). */
    private int ods;

    /** Tecnologia utilizada na missão (ex: Satélite, Sensor IoT). */
    private String tecnologia;

    /**
     * Grau de prioridade da missão (1 = mais alta, 5 = mais baixa).
     */
    private int prioridade;

    /** Status atual da missão. */
    private StatusMissao status;

    public Missao(String nome, String areaImpacto, String objetivo,
                  int ods, String tecnologia, int prioridade, StatusMissao status) {
        this.nome        = nome;
        this.areaImpacto = areaImpacto;
        this.objetivo    = objetivo;
        this.ods         = ods;
        this.tecnologia  = tecnologia;
        this.prioridade  = prioridade;
        this.status      = status;
    }

    public Missao(String nome, String areaImpacto, String objetivo,
                  int ods, String tecnologia, int prioridade) {
        this(nome, areaImpacto, objetivo, ods, tecnologia, prioridade, StatusMissao.PLANEJADA);
    }

    // ───────────────────────── Getters / Setters ─────────────────

    /** @return Nome da missão */
    public String getNome() { return nome; }

    /** @param nome Novo nome da missão */
    public void setNome(String nome) { this.nome = nome; }

    /** @return Área de impacto */
    public String getAreaImpacto() { return areaImpacto; }

    /** @param areaImpacto Nova área de impacto */
    public void setAreaImpacto(String areaImpacto) { this.areaImpacto = areaImpacto; }

    /** @return Objetivo da missão */
    public String getObjetivo() { return objetivo; }

    /** @param objetivo Novo objetivo */
    public void setObjetivo(String objetivo) { this.objetivo = objetivo; }

    /** @return ODS relacionado */
    public int getOds() { return ods; }

    /** @param ods Novo ODS (1–17) */
    public void setOds(int ods) { this.ods = ods; }

    /** @return Tecnologia utilizada */
    public String getTecnologia() { return tecnologia; }

    /** @param tecnologia Nova tecnologia */
    public void setTecnologia(String tecnologia) { this.tecnologia = tecnologia; }

    /** @return Grau de prioridade */
    public int getPrioridade() { return prioridade; }

    /** @param prioridade Novo grau de prioridade (1–5) */
    public void setPrioridade(int prioridade) { this.prioridade = prioridade; }

    /** @return Status atual da missão */
    public StatusMissao getStatus() { return status; }

    /** @param status Novo status da missão */
    public void setStatus(StatusMissao status) { this.status = status; }

    @Override
    public String toString() {
        return "================================================"
             + "  🚀 MISSÃO: " + nome + "\n"
             + "  📍 Área de Impacto : " + areaImpacto + "\n"
             + "  🎯 Objetivo        : " + objetivo + "\n"
             + "  🌱 ODS             : " + ods + "\n"
             + "  🛰️  Tecnologia      : " + tecnologia + "\n"
             + "  ⚡ Prioridade      : " + prioridade + " (1=alta / 5=baixa)\n"
             + "  📊 Status          : " + status.getDescricao() + "\n"
             + "================================================";
    }
}
