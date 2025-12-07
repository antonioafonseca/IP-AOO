/*
    CURSO SUPERIOR DE TECNOLOGIA EM ANÁLISE E DESENVOLVIMENTO DE SISTEMAS
    IMERSÃO PROFISSIONAL: APLICANDO ORIENTAÇÃO A OBJETOS
    ANTONIO AUGUSTO DA FONSECA - 25046981-5
*/

package ui;

import model.*;
import service.*;

import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {

    private final AlunoService alunoService;
    private final ProfessorService professorService;
    private final CursoService cursoService;
    private final TurmaService turmaService;

    public MenuPrincipal(
            AlunoService alunoService,
            ProfessorService professorService,
            CursoService cursoService,
            TurmaService turmaService) {
        this.alunoService = alunoService;
        this.professorService = professorService;
        this.cursoService = cursoService;
        this.turmaService = turmaService;
    }

    public void iniciar() {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1 - Cadastrar Aluno");
            System.out.println("2 - Cadastrar Professor");
            System.out.println("3 - Cadastrar Curso");
            System.out.println("4 - Cadastrar Turma");
            System.out.println("5 - Gerenciar Turmas");
            System.out.println("6 - Relatórios");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            String opc = sc.nextLine();

            switch (opc) {
                case "1":
                    cadastrarAluno(sc);
                    break;
                case "2":
                    cadastrarProfessor(sc);
                    break;
                case "3":
                    cadastrarCurso(sc);
                    break;
                case "4":
                    cadastrarTurma(sc);
                    break;
                case "5":
                    menuTurmas(sc);
                    break;
                case "6":
                    menuRelatorios(sc);
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    // ==========================
    // CADASTRAR ALUNO
    // ==========================
    private void cadastrarAluno(Scanner sc) {

        if (cursoService.listar().isEmpty()) {
            System.out.println("Nenhum curso cadastrado.");
            return;
        }

        String login;
        while (true) {
            System.out.print("Login: ");
            login = sc.nextLine();
            if (alunoService.loginDisponivel(login))
                break;
            System.out.println("Login não disponível. Tente outro.");
        }

        String matricula;
        while (true) {
            System.out.print("Matrícula: ");
            matricula = sc.nextLine();
            if (alunoService.matriculaDisponivel(matricula))
                break;
            System.out.println("Matrícula já cadastrada.");
        }

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Senha: ");
        String senha = sc.nextLine();

        System.out.println("\n=== Cursos disponíveis ===");
        cursoService.listar().forEach(
                c -> System.out.println(c.getCodigo() + " - " + c.getNome()));

        String codCurso;
        while (true) {
            System.out.print("Código do curso: ");
            codCurso = sc.nextLine();
            if (cursoService.buscarPorCodigo(codCurso) != null)
                break;
            System.out.println("Curso inválido.");
        }

        boolean ok = alunoService.cadastrarAluno(nome, login, senha, matricula, codCurso);
        System.out.println(ok ? "Aluno cadastrado!" : "Erro ao cadastrar aluno.");
    }

    // ==========================
    // CADASTRAR PROFESSOR
    // ==========================
    private void cadastrarProfessor(Scanner sc) {

        String login;
        while (true) {
            System.out.print("Login: ");
            login = sc.nextLine();
            if (professorService.loginDisponivel(login))
                break;
            System.out.println("Login indisponível.");
        }

        String registro;
        while (true) {
            System.out.print("Registro: ");
            registro = sc.nextLine();
            if (professorService.registroDisponivel(registro))
                break;
            System.out.println("Registro já existe.");
        }

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Senha: ");
        String senha = sc.nextLine();

        System.out.print("Especialidade: ");
        String esp = sc.nextLine();

        boolean ok = professorService.cadastrarProfessor(nome, login, senha, esp, registro);
        System.out.println(ok ? "Professor cadastrado!" : "Erro ao cadastrar professor.");
    }

    // ==========================
    // CADASTRAR CURSO
    // ==========================
    private void cadastrarCurso(Scanner sc) {

        String codigo;
        while (true) {
            System.out.print("Código: ");
            codigo = sc.nextLine();
            if (cursoService.codigoDisponivel(codigo))
                break;
            System.out.println("Código já existente.");
        }

        System.out.println("\nTipo de curso:");
        System.out.println("1 - Presencial");
        System.out.println("2 - EAD");
        System.out.print("Escolha: ");
        String tipo = sc.nextLine();

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Carga horária: ");
        int carga = Integer.parseInt(sc.nextLine());

        boolean ok = false;

        if (tipo.equals("1")) {
            System.out.print("Sala: ");
            String sala = sc.nextLine();
            ok = cursoService.cadastrarCurso(nome, codigo, carga, "presencial", sala);
        } else if (tipo.equals("2")) {
            System.out.print("Plataforma: ");
            String plataforma = sc.nextLine();
            ok = cursoService.cadastrarCurso(nome, codigo, carga, "ead", plataforma);
        }

        System.out.println(ok ? "Curso cadastrado!" : "Erro ao cadastrar curso.");
    }

    // ==========================
    // CADASTRAR TURMA
    // ==========================
    private void cadastrarTurma(Scanner sc) {

        if (cursoService.listar().isEmpty()) {
            System.out.println("Nenhum curso cadastrado.");
            return;
        }
        if (professorService.listar().isEmpty()) {
            System.out.println("Nenhum professor cadastrado.");
            return;
        }

        String codTurma;
        while (true) {
            System.out.print("Código da turma: ");
            codTurma = sc.nextLine();
            if (turmaService.codigoDisponivel(codTurma))
                break;
            System.out.println("Código já cadastrado.");
        }

        System.out.println("\n=== Cursos disponíveis ===");
        cursoService.listar().forEach(
                c -> System.out.println(c.getCodigo() + " - " + c.getNome()));

        String codCurso;
        while (true) {
            System.out.print("Código do curso: ");
            codCurso = sc.nextLine();
            if (cursoService.buscarPorCodigo(codCurso) != null)
                break;
            System.out.println("Curso inválido.");
        }

        System.out.println("\n=== Professores disponíveis ===");
        professorService.listar().forEach(
                p -> System.out.println(p.getRegistro() + " - " + p.getNome()));

        String reg;
        while (true) {
            System.out.print("Registro do professor: ");
            reg = sc.nextLine();
            if (!professorService.registroDisponivel(reg))
                break;
            System.out.println("Professor não encontrado.");
        }

        boolean ok = turmaService.cadastrarTurma(codTurma, codCurso, reg);
        System.out.println(ok ? "Turma cadastrada!" : "Erro ao cadastrar turma.");
    }

    // ============================================================
    // GERENCIAMENTO DE TURMAS (ATUALIZADO COM AVALIAÇÕES)
    // ============================================================
    private void menuTurmas(Scanner sc) {

        while (true) {
            System.out.println("\n===== GERENCIAR TURMAS =====");
            System.out.println("1 - Adicionar aluno à turma");
            System.out.println("2 - Adicionar avaliação para aluno");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");

            String opc = sc.nextLine();

            switch (opc) {
                case "1":
                    adicionarAlunoTurma(sc);
                    break;
                case "2":
                    adicionarAvaliacaoTurma(sc);
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private void adicionarAlunoTurma(Scanner sc) {

        if (turmaService.listar().isEmpty()) {
            System.out.println("Nenhuma turma cadastrada.");
            return;
        }
        if (alunoService.listar().isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }

        System.out.println("\n=== Turmas disponíveis ===");
        turmaService.listar().forEach(t -> System.out.println(t.getCodigo()));

        Turma turma;
        while (true) {
            System.out.print("Código da turma: ");
            String cod = sc.nextLine();
            turma = turmaService.listar().stream()
                    .filter(t -> t.getCodigo().equalsIgnoreCase(cod))
                    .findFirst().orElse(null);
            if (turma != null)
                break;
            System.out.println("Turma não encontrada.");
        }

        System.out.println("\n=== Alunos disponíveis ===");
        alunoService.listar().forEach(a -> System.out.println(a.getMatricula() + " - " + a.getNome()));

        Aluno aluno;
        while (true) {
            System.out.print("Matrícula do aluno: ");
            String mat = sc.nextLine();
            aluno = alunoService.listar().stream()
                    .filter(a -> a.getMatricula().equalsIgnoreCase(mat))
                    .findFirst().orElse(null);
            if (aluno != null)
                break;
            System.out.println("Aluno não encontrado.");
        }

        boolean ok = turma.adicionarAluno(aluno);
        System.out.println(ok ? "Aluno adicionado!" : "Aluno já está na turma.");
    }

    // ===========================
    // ADICIONAR AVALIAÇÃO
    // ===========================
    private void adicionarAvaliacaoTurma(Scanner sc) {

        if (turmaService.listar().isEmpty()) {
            System.out.println("Nenhuma turma cadastrada.");
            return;
        }

        System.out.println("\n=== Turmas disponíveis ===");
        turmaService.listar().forEach(t -> System.out.println(t.getCodigo() + " - " + t.toString().split("\n")[0]));

        Turma turma;
        while (true) {
            System.out.print("Código da turma: ");
            String cod = sc.nextLine();
            turma = turmaService.listar().stream()
                    .filter(t -> t.getCodigo().equalsIgnoreCase(cod))
                    .findFirst().orElse(null);
            if (turma != null)
                break;
            System.out.println("Turma não encontrada.");
        }

        if (turma.getListaAlunos().isEmpty()) {
            System.out.println("Não há alunos nesta turma.");
            return;
        }

        System.out.println("\n=== Alunos da turma ===");
        turma.getListaAlunos().forEach(a -> System.out.println(a.getMatricula() + " - " + a.getNome()));

        Aluno aluno;
        while (true) {
            System.out.print("Matrícula do aluno: ");
            String mat = sc.nextLine();
            aluno = turma.getListaAlunos().stream()
                    .filter(a -> a.getMatricula().equalsIgnoreCase(mat))
                    .findFirst().orElse(null);
            if (aluno != null)
                break;
            System.out.println("Aluno não encontrado na turma.");
        }

        System.out.print("Descrição da avaliação: ");
        String desc = sc.nextLine();

        Avaliacao avaliacao = new Avaliacao(desc);

        double nota;
        while (true) {
            System.out.print("Nota (0 a 10): ");
            try {
                nota = Double.parseDouble(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Valor inválido.");
                continue;
            }
            if (avaliacao.atribuirNota(nota))
                break;
            System.out.println("Nota inválida. Informe entre 0 e 10.");
        }

        turma.adicionarAvaliacaoParaAluno(aluno, avaliacao);

        System.out.println("Avaliação registrada com sucesso!");
    }

    // ==========================
    // RELATÓRIOS
    // ==========================
    private void menuRelatorios(Scanner sc) {

        while (true) {
            System.out.println("\n===== RELATÓRIOS =====");
            System.out.println("1 - Listar Alunos");
            System.out.println("2 - Listar Professores");
            System.out.println("3 - Listar Cursos");
            System.out.println("4 - Listar Turmas");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");

            String opc = sc.nextLine();

            switch (opc) {
                case "1":
                    List<Aluno> alunos = alunoService.listar();
                    if (alunos == null || alunos.isEmpty()) {
                        System.out.println("Não existem alunos cadastrados!");
                    } else {
                        alunos.forEach(a -> System.out.println(a.gerarRelatorio()));
                    }

                    break;

                case "2":
                    List<Professor> professores = professorService.listar();
                    if (professores == null || professores.isEmpty()) {
                        System.out.println("Não existem professores cadastrados!");
                    } else {
                        professores.forEach(p -> System.out.println(p.gerarRelatorio()));
                    }

                    break;

                case "3":
                    List<Curso> cursos = cursoService.listar();
                    if (cursos == null || cursos.isEmpty()) {
                        System.out.println("Não existem cursos cadastrados!");
                    } else {
                        cursos.forEach(c -> System.out.println(c.detalharCurso()));
                    }

                    break;

                case "4":
                    List<Turma> turmas = turmaService.listar();
                    if (turmas == null || turmas.isEmpty()) {
                        System.out.println("Não existem turmas cadastradas!");
                    } else {
                        turmas.forEach(t -> System.out.println(t.toString()));
                    }
                    break;

                case "0":
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}