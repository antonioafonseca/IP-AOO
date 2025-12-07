/*
CURSO SUPERIOR DE TECNOLOGIA EM ANÁLISE E DESENVOLVIMENTO DE SISTEMAS
IMERSÃO PROFISSIONAL: APLICANDO ORIENTAÇÃO A OBJETOS
ANTONIO AUGUSTO DA FONSECA - 25046981-5
*/

public class Main {
    public static void main(String[] args) {
        System.out.println("Desenvolvido por Antonio Augusto da Fonseca - 25046981-5");
        // Criando Curso
        Curso cursoADS = new Curso("Análise e Desenvolvimento de Sistemas", "ADS01", 2000);

        // Criando Alunos
        Aluno aluno1 = new Aluno("João Silva", "2025001", cursoADS);
        Aluno aluno2 = new Aluno("Maria Oliveira", "2025002", cursoADS);
        Aluno aluno3 = new Aluno("José Pereira", "2025003", cursoADS);

        // Criando Professor
        Professor professor = new Professor("Carlos Henrique", "Engenharia de Software", "PRF789");

        // Criando Turma
        Turma turma = new Turma("ADS001", professor, cursoADS);

        // Adicionando alunos
        turma.adicionarAluno(aluno1);
        turma.adicionarAluno(aluno2);
        turma.adicionarAluno(aluno3);

        // Criando avaliações
        Avaliacao av1 = new Avaliacao("Prova 1");
        av1.atribuirNota(8.5);

        Avaliacao av2 = new Avaliacao("Trabalho 1");
        av2.atribuirNota(9.0);

        Avaliacao av3 = new Avaliacao("Prova 1");
        av3.atribuirNota(7.0);

        Avaliacao av4 = new Avaliacao("Trabalho 1");
        av4.atribuirNota(8.5);
        
        Avaliacao av5 = new Avaliacao("Prova 1");
        av5.atribuirNota(9.0);

        Avaliacao av6 = new Avaliacao("Trabalho 1");
        av6.atribuirNota(7.0);

        // Associando avaliações à turma (Map<Aluno, List<Avaliacao>>)
        turma.adicionarAvaliacaoParaAluno(aluno1, av1);
        turma.adicionarAvaliacaoParaAluno(aluno1, av2);
        turma.adicionarAvaliacaoParaAluno(aluno2, av3);
        turma.adicionarAvaliacaoParaAluno(aluno2, av4);
        turma.adicionarAvaliacaoParaAluno(aluno3, av5);
        turma.adicionarAvaliacaoParaAluno(aluno3, av6);

        // Remoção de aluno para validar o método existente na classe Turma
        turma.removerAluno(aluno2);

        // Impressão dos dados da turma
        System.out.println(turma);
    }
}