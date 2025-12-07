/*
CURSO SUPERIOR DE TECNOLOGIA EM ANÁLISE E DESENVOLVIMENTO DE SISTEMAS
IMERSÃO PROFISSIONAL: APLICANDO ORIENTAÇÃO A OBJETOS
ANTONIO AUGUSTO DA FONSECA - 25046981-5
*/

public class Main {
    public static void main(String[] args) {
        System.out.println("Desenvolvido por Antonio Augusto da Fonseca - 25046981-5");
        Curso curso = new Curso("Análise e Desenvolvimento de Sistemas", "001", 2400);
        Aluno aluno = new Aluno("Maria Silva", "2025001", curso);
        Professor professor = new Professor("Dr. João", "Matemática", "REG1234");

        System.out.println("== Fase 1 - Instâncias criadas ==");
        System.out.println(aluno);
        System.out.println(professor);
        System.out.println(curso);
        System.out.println("Validação básica ok.");
    }
}