/*
CURSO SUPERIOR DE TECNOLOGIA EM ANÁLISE E DESENVOLVIMENTO DE SISTEMAS
IMERSÃO PROFISSIONAL: APLICANDO ORIENTAÇÃO A OBJETOS
ANTONIO AUGUSTO DA FONSECA - 25046981-5
*/

public class Main {
    public static void main(String[] args) {
        System.out.println("Desenvolvido por Antonio Augusto da Fonseca - 25046981-5");
        Professor p = new Professor("Dra. Ana", "História", "REG5678");
        Curso c = new Curso("História", "HIS201", 1200);
        Turma t = new Turma("TURMA-01", p, c);

        Aluno a1 = new Aluno("Carlos", "2025002", c);
        Aluno a2 = new Aluno("Luiza", "2025003", c);

        System.out.println("Adicionando alunos:");
        System.out.println("adicionar a1 -> " + t.adicionarAluno(a1));
        System.out.println("adicionar a2 -> " + t.adicionarAluno(a2));
        System.out.println("adicionar a1 novamente -> " + t.adicionarAluno(a1));

        t.resumo();

        System.out.println("Remover aluno 2025002 -> " + t.removerAluno("2025002"));
        t.resumo();
    }
}