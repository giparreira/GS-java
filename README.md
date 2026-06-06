# 🚀 GS — 2ESPV | Sistema de Missões Espaciais Sustentáveis

> Simulação de cadastro, organização e consulta de missões espaciais com impacto positivo na Terra.

---

## 📋 Sobre o Projeto

O **GS 2ESPV** é uma aplicação console desenvolvida em **Java puro** como parte do Global Solution do 1º semestre. O sistema permite registrar e gerenciar projetos de missões espaciais voltadas à solução de problemas reais da sociedade, conectando tecnologia espacial com os **Objetivos de Desenvolvimento Sustentável (ODS)** da ONU.

---

## 🌍 Problema Escolhido

As missões cadastradas abrangem desafios como:

- **Monitoramento agrícola por satélite** — ODS 2 (Fome Zero)
- **Prevenção de desastres naturais** — ODS 13 (Ação Climática)
- **Monitoramento de desmatamento** — ODS 15 (Vida Terrestre)
- **Conectividade para regiões remotas** — ODS 9 (Infraestrutura)
- **Saúde em regiões isoladas** — ODS 3 (Saúde e Bem-Estar)

---

## 🛸 Funcionalidades

| Funcionalidade | Descrição |
|---|---|
| ➕ Cadastrar Missão | Registra nome, área, objetivo, ODS, tecnologia, prioridade e status |
| 📋 Listar Missões | Exibe todas as missões cadastradas formatadas |
| 🔍 Buscar por Nome | Pesquisa parcial e case-insensitive pelo nome da missão |
| 🔍 Buscar por Área | Filtra missões pela área de impacto |
| ✏️ Alterar Status | Atualiza o status de uma missão (Planejada → Em Andamento → Concluída / Cancelada) |
| 📊 Resumo Geral | Total de missões, contagem por status e missão de maior prioridade |

---

## 🗂️ Estrutura do Projeto

```
GS2ESPV/
├── src/
│   └── main/
│       └── java/
│           └── br/
│               └── com/
│                   └── gs2espv/
│                       ├── Main.java                  ← Ponto de entrada / Menu
│                       ├── model/
│                       │   ├── Missao.java             ← Entidade principal
│                       │   └── StatusMissao.java       ← Enum de status
│                       ├── service/
│                       │   └── MissaoService.java      ← Regras de negócio
│                       └── util/
│                           └── Console.java            ← Leitura segura do console
└── README.md
```

---

## ▶️ Como Executar

### Pré-requisitos

- **Java 17+** instalado ([Download](https://adoptium.net/))
- Terminal / Prompt de Comando

### Passo a passo

**1. Clone o repositório:**
```bash
git clone https://github.com/seu-usuario/GS2ESPV.git
cd GS2ESPV
```

**2. Compile o projeto:**
```bash
# Linux / macOS
javac -d out $(find src -name "*.java")

# Windows (PowerShell)
javac -d out (Get-ChildItem -Recurse -Filter *.java src | % FullName)
```

**3. Execute:**
```bash
java -cp out br.com.gs2espv.Main
```

> **Dica:** O sistema já inicia com 5 missões de exemplo para facilitar os testes.

---

## 🧩 Conteúdos Aplicados (1º Semestre)

| Conteúdo | Onde é utilizado |
|---|---|
| Classes, atributos e métodos | `Missao`, `MissaoService`, `Console` |
| Encapsulamento e modificadores de acesso | `private` em todos os atributos + getters/setters |
| Construtores (sobrecarga) | `Missao` possui dois construtores |
| Tipos primitivos e Strings | Atributos `int prioridade`, `int ods`, `String nome`, etc. |
| Entrada e saída de dados | `Console.lerString()`, `Console.lerInt()` |
| Conversões entre tipos | Leitura de int com tratamento de `InputMismatchException` |
| Manipulação de Strings | `.strip()`, `.toLowerCase()`, `.contains()` nas buscas |
| Pacotes | `model`, `service`, `util` |
| Comentários e Javadoc | Todas as classes e métodos documentados com `/** */` |
| Enum (tipo especial de classe) | `StatusMissao` com descrições |
| ArrayList e List | Armazenamento das missões em `MissaoService` |

---

## 👥 Integrantes do Grupo

| Nome | RM |
|---|---|
| *Julia Souza Pompeu* | 561955 |
| *Giovana Rosatti Parreira* | 563375 |
| *Luiz Filipe Dalboni Riello* | 564189 |
| *Thayná Pereira Simões* | 566456 |

---

## 🎥 Vídeo Explicativo

> 📽️ 

