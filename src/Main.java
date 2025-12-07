/*
CURSO SUPERIOR DE TECNOLOGIA EM ANÁLISE E DESENVOLVIMENTO DE SISTEMAS
IMERSÃO PROFISSIONAL: APLICANDO ORIENTAÇÃO A OBJETOS
ANTONIO AUGUSTO DA FONSECA - 25046981-5
*/

public class Main {
    public static void main(String[] args) {
        System.out.println("Desenvolvido por Antonio Augusto da Fonseca - 25046981-5");
        
        // ===== TESTE FASE 5 =====
        System.out.println("\n===== TESTE FASE 5 =====");

        Administrador admin = new Administrador("Administrador Geral", "admin", "1234");

        Curso curso = new Curso("ADS", "001", 2000);

        Aluno aluno1 = new Aluno("Antonio", "antonio", "senha", "001", curso);

        Professor professor = new Professor("Antonio", "antonio", "senha", "Engenharia de Software", "001");

        System.out.println("Admin autenticado (correto): " + admin.autenticar("admin", "1234"));
        System.out.println("Admin autenticado (incorreto): " + admin.autenticar("admin", "9999"));

        System.out.println("Aluno autenticado: " + aluno1.autenticar("joao", "123"));
        System.out.println("Professor autenticado: " + professor.autenticar("carlos", "prof123"));
    }
}