/*
CURSO SUPERIOR DE TECNOLOGIA EM ANÁLISE E DESENVOLVIMENTO DE SISTEMAS
IMERSÃO PROFISSIONAL: APLICANDO ORIENTAÇÃO A OBJETOS
ANTONIO AUGUSTO DA FONSECA - 25046981-5
*/

public class Main {
    public static void main(String[] args) {
        System.out.println("Desenvolvido por Antonio Augusto da Fonseca - 25046981-5");

        System.out.println("\n===== TESTE FASE 4 =====");

        CursoPresencial cp = new CursoPresencial("Engenharia de Software", "ES01", 3000, "Sala 12");
        CursoEAD ce = new CursoEAD("Gestão de Projetos", "GP01", 1800, "Studeo");

        System.out.println(cp.detalharCurso());
        System.out.println(ce.detalharCurso());

    }
}