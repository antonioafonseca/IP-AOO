/*
CURSO SUPERIOR DE TECNOLOGIA EM ANÁLISE E DESENVOLVIMENTO DE SISTEMAS
IMERSÃO PROFISSIONAL: APLICANDO ORIENTAÇÃO A OBJETOS
ANTONIO AUGUSTO DA FONSECA - 25046981-5
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Desenvolvido por Antonio Augusto da Fonseca - 25046981-5");
        // ----- Dados de exemplo (reutilize/adicione conforme seu contexto) -----
        Curso cursoADS = new Curso("Análise e Desenvolvimento de Sistemas", "ADS01", 2000);
        Curso cursoMED = new Curso("Medicina", "MED101", 3600);

        Aluno aluno1 = new Aluno("João Silva", "joao", "123", "2025001", cursoADS);
        Aluno aluno2 = new Aluno("Maria Oliveira", "maria", "123", "2025002", cursoMED);
        Aluno aluno3 = new Aluno("Pedro Alves", "pedro", "123", "2025003", cursoADS);

        Professor prof1 = new Professor("Carlos Henrique", "carlos", "prof123", "Engenharia de Software", "PRF789");
        Professor prof2 = new Professor("Dra. Carla", "carla", "prof456", "Anatomia", "PRF777");

        // Lista separada por tipo (útil para opções do menu)
        List<Aluno> alunos = new ArrayList<>();
        alunos.add(aluno1);
        alunos.add(aluno2);
        alunos.add(aluno3);

        List<Professor> professores = new ArrayList<>();
        professores.add(prof1);
        professores.add(prof2);

        List<Curso> cursos = new ArrayList<>();
        cursos.add(cursoADS);
        cursos.add(cursoMED);

        // Lista polimórfica de Relatorio (Aluno, Professor, Curso implementam Relatorio)
        List<Relatorio> relatorios = new ArrayList<>();
        relatorios.addAll(alunos);
        relatorios.addAll(professores);
        relatorios.addAll(cursos);

        // ----- Menu de relatórios -----
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n==== MENU DE RELATÓRIOS ====");
            System.out.println("1 - Relatórios de Alunos");
            System.out.println("2 - Relatórios de Professores");
            System.out.println("3 - Relatórios de Cursos");
            System.out.println("4 - Executar todos os relatórios (polimórfico)");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            String entrada = sc.nextLine().trim();
            if (entrada.equals("0")) {
                System.out.println("Encerrando...");
                break;
            }

            switch (entrada) {
                case "1":
                    System.out.println("\n--- RELATÓRIOS: ALUNOS ---");
                    for (Aluno a : alunos) {
                        System.out.println(a.gerarRelatorio());
                    }
                    break;
                case "2":
                    System.out.println("\n--- RELATÓRIOS: PROFESSORES ---");
                    for (Professor p : professores) {
                        System.out.println(p.gerarRelatorio());
                    }
                    break;
                case "3":
                    System.out.println("\n--- RELATÓRIOS: CURSOS ---");
                    for (Curso c : cursos) {
                        System.out.println(c.gerarRelatorio());
                    }
                    break;
                case "4":
                    System.out.println("\n--- RELATÓRIOS: TODOS (POLIMÓRFICO) ---");
                    for (Relatorio r : relatorios) {
                        System.out.println(r.gerarRelatorio());
                    }
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
        sc.close();
    }
}