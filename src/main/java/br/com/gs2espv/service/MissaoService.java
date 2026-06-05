package br.com.gs2espv.service;

import br.com.gs2espv.model.Missao;
import br.com.gs2espv.model.StatusMissao;

import java.util.ArrayList;
import java.util.List;

public class MissaoService {

    private final List<Missao> missoes;

    public MissaoService() {
        this.missoes = new ArrayList<>();
    }

    public boolean cadastrar(Missao missao) {
        if (missao == null) return false;
        if (buscarPorNome(missao.getNome()) != null) return false; // nome duplicado
        missoes.add(missao);
        return true;
    }


    public List<Missao> listarTodas() {
        return new ArrayList<>(missoes);
    }

    public Missao buscarPorNome(String nome) {
        if (nome == null || nome.isBlank()) return null;
        String nomeLower = nome.strip().toLowerCase();
        for (Missao m : missoes) {
            if (m.getNome().toLowerCase().contains(nomeLower)) {
                return m;
            }
        }
        return null;
    }

    public List<Missao> buscarPorArea(String area) {
        List<Missao> resultado = new ArrayList<>();
        if (area == null || area.isBlank()) return resultado;
        String areaLower = area.strip().toLowerCase();
        for (Missao m : missoes) {
            if (m.getAreaImpacto().toLowerCase().contains(areaLower)) {
                resultado.add(m);
            }
        }
        return resultado;
    }

    public boolean alterarStatus(String nome, StatusMissao novoStatus) {
        Missao missao = buscarPorNome(nome);
        if (missao == null || novoStatus == null) return false;
        missao.setStatus(novoStatus);
        return true;
    }


    public int totalMissoes() {
        return missoes.size();
    }

    public int contarPorStatus(StatusMissao status) {
        int count = 0;
        for (Missao m : missoes) {
            if (m.getStatus() == status) count++;
        }
        return count;
    }

    public Missao missaoMaiorPrioridade() {
        if (missoes.isEmpty()) return null;
        Missao maior = missoes.get(0);
        for (Missao m : missoes) {
            if (m.getPrioridade() < maior.getPrioridade()) {
                maior = m;
            }
        }
        return maior;
    }
}
