package br.com.gs2espv;

import br.com.gs2espv.model.Missao;
import br.com.gs2espv.model.StatusMissao;
import br.com.gs2espv.service.MissaoService;
import br.com.gs2espv.util.Console;

import java.util.List;

public class Main {

    private static final MissaoService servico = new MissaoService();

    public static void main(String[] args) {
        carregarDadosExemplo();
        exibirBoasVindas();

        int opcao;
        do {
            exibirMenu();
            opcao = Console.lerInt("  👉 Escolha uma opção: ");
            Console.linha();
            processarOpcao(opcao);
        } while (opcao != 0);

        Console.fechar();
    }

    private static void exibirBoasVindas() {
        Console.separador();
        System.out.println("  BEM-VINDO AO SISTEMA DE MISSÕES ESPACIAIS  ");
        System.out.println("          GS — 2ESPV | MarsLife");
        Console.separador();
        Console.linha();
    }

    private static void exibirMenu() {
        Console.separador();
        System.out.println("  📋  MENU PRINCIPAL");
        Console.separador();
        System.out.println("  1 - Cadastrar missão espacial");
        System.out.println("  2 - Listar todas as missões");
        System.out.println("  3 - Buscar missão por nome");
        System.out.println("  4 - Buscar missões por área de impacto");
        System.out.println("  5 - Alterar status de uma missão");
        System.out.println("  6 - Exibir resumo geral");
        System.out.println("  0 - Sair");
        Console.separador();
    }

    private static void processarOpcao(int opcao) {
        switch (opcao) {
            case 1 -> cadastrarMissao();
            case 2 -> listarMissoes();
            case 3 -> buscarPorNome();
            case 4 -> buscarPorArea();
            case 5 -> alterarStatus();
            case 6 -> exibirResumo();
            case 0 -> System.out.println("  👋  Encerrando o sistema. Até logo, astronauta!");
            default -> System.out.println("  ⚠️  Opção inválida. Tente novamente.");
        }
        Console.linha();
    }

    private static void cadastrarMissao() {
        System.out.println("   CADASTRO DE NOVA MISSÃO");
        Console.separador();

        String nome       = Console.lerString("  Nome da missão        : ");
        String area       = Console.lerString("  Área de impacto       : ");
        String objetivo   = Console.lerString("  Objetivo              : ");
        int    ods        = Console.lerIntNoIntervalo("  ODS relacionado (1-17): ", 1, 17);
        String tecnologia = Console.lerString("  Tecnologia utilizada  : ");
        int    prioridade = Console.lerIntNoIntervalo("  Prioridade (1-5)      : ", 1, 5);

        Missao missao = new Missao(nome, area, objetivo, ods, tecnologia, prioridade);
        boolean sucesso = servico.cadastrar(missao);

        Console.linha();
        if (sucesso) {
            System.out.println("  ✅  Missão \"" + nome + "\" cadastrada com sucesso!");
        } else {
            System.out.println("  ❌  Não foi possível cadastrar. Já existe uma missão com esse nome.");
        }
    }

    private static void listarMissoes() {
        System.out.println("   LISTA DE MISSÕES CADASTRADAS");
        Console.separador();

        List<Missao> lista = servico.listarTodas();
        if (lista.isEmpty()) {
            System.out.println("  ℹ️  Nenhuma missão cadastrada ainda.");
            return;
        }

        for (int i = 0; i < lista.size(); i++) {
            System.out.println("  [" + (i + 1) + "]");
            System.out.println(lista.get(i));
        }
        System.out.println("  Total: " + lista.size() + " missão(ões).");
    }

    private static void buscarPorNome() {
        System.out.println("   BUSCAR MISSÃO POR NOME");
        Console.separador();

        String nome = Console.lerString("  Digite o nome (ou parte): ");
        Missao resultado = servico.buscarPorNome(nome);

        Console.linha();
        if (resultado != null) {
            System.out.println("  ✅  Missão encontrada:\n");
            System.out.println(resultado);
        } else {
            System.out.println("  ❌  Nenhuma missão encontrada com o nome \"" + nome + "\".");
        }
    }

    private static void buscarPorArea() {
        System.out.println("    BUSCAR MISSÕES POR ÁREA DE IMPACTO");
        Console.separador();

        String area = Console.lerString("  Digite a área de impacto (ou parte): ");
        List<Missao> resultados = servico.buscarPorArea(area);

        Console.linha();
        if (resultados.isEmpty()) {
            System.out.println("  ❌  Nenhuma missão encontrada para a área \"" + area + "\".");
            return;
        }

        System.out.println("  ✅  " + resultados.size() + " missão(ões) encontrada(s):\n");
        for (Missao m : resultados) {
            System.out.println(m);
        }
    }

    private static void alterarStatus() {
        System.out.println("     ALTERAR STATUS DE MISSÃO");
        Console.separador();

        String nome = Console.lerString("  Nome da missão: ");
        Missao missao = servico.buscarPorNome(nome);

        if (missao == null) {
            System.out.println("  ❌  Missão não encontrada.");
            return;
        }

        System.out.println("\n  Status atual: " + missao.getStatus().getDescricao());
        System.out.println("\n  Selecione o novo status:");
        System.out.println("    1 - Planejada");
        System.out.println("    2 - Em Andamento");
        System.out.println("    3 - Concluída");
        System.out.println("    4 - Cancelada");

        int opcao = Console.lerIntNoIntervalo("  Opção: ", 1, 4);
        StatusMissao novoStatus = StatusMissao.fromOpcao(opcao);

        boolean sucesso = servico.alterarStatus(nome, novoStatus);
        Console.linha();
        if (sucesso) {
            System.out.println("  ✅  Status atualizado para: " + novoStatus.getDescricao());
        } else {
            System.out.println("  ❌  Não foi possível atualizar o status.");
        }
    }

    private static void exibirResumo() {
        System.out.println("    RESUMO GERAL DO SISTEMA");
        Console.separador();

        int total = servico.totalMissoes();

        if (total == 0) {
            System.out.println("  ℹ️  Nenhuma missão cadastrada ainda.");
            return;
        }

        System.out.println("  Total de missões cadastradas : " + total);
        Console.linha();
        System.out.println("  Por status:");
        System.out.println("    🔵 Planejada    : " + servico.contarPorStatus(StatusMissao.PLANEJADA));
        System.out.println("    🟡 Em Andamento : " + servico.contarPorStatus(StatusMissao.EM_ANDAMENTO));
        System.out.println("    🟢 Concluída    : " + servico.contarPorStatus(StatusMissao.CONCLUIDA));
        System.out.println("    🔴 Cancelada    : " + servico.contarPorStatus(StatusMissao.CANCELADA));

        Console.linha();
        Missao prioridade = servico.missaoMaiorPrioridade();
        if (prioridade != null) {
            System.out.println("  🏆  Missão com maior prioridade:");
            System.out.println(prioridade);
        }
    }

    private static void carregarDadosExemplo() {
        servico.cadastrar(new Missao(
            "AgroSat",
            "Agricultura",
            "Monitoramento de lavouras por satélite para otimizar irrigação",
            2, "Satélite óptico", 1, StatusMissao.EM_ANDAMENTO
        ));
        servico.cadastrar(new Missao(
            "AlertaFlood",
            "Prevenção de Desastres",
            "Detecção precoce de enchentes por sensores e IA",
            13, "Sensor IoT + ML", 2, StatusMissao.PLANEJADA
        ));
        servico.cadastrar(new Missao(
            "FlorestaSat",
            "Meio Ambiente",
            "Mapeamento de desmatamento na Amazônia em tempo real",
            15, "Satélite radar", 2, StatusMissao.EM_ANDAMENTO
        ));
        servico.cadastrar(new Missao(
            "ConectaRemoto",
            "Conectividade",
            "Levar internet de banda larga a comunidades ribeirinhas",
            9, "Satélite LEO", 3, StatusMissao.PLANEJADA
        ));
        servico.cadastrar(new Missao(
            "SaúdeEspacial",
            "Saúde",
            "Telemedicina apoiada por satélite para regiões isoladas",
            3, "Satélite geoestacionário", 2, StatusMissao.CONCLUIDA
        ));
    }
}
