/*
CURSO SUPERIOR DE TECNOLOGIA EM ANÁLISE E DESENVOLVIMENTO DE SISTEMAS
IMERSÃO PROFISSIONAL: APLICANDO ORIENTAÇÃO A OBJETOS
ANTONIO AUGUSTO DA FONSECA - 25046981-5
*/

import repository.*;
import service.*;
import ui.MenuPrincipal;

public class Main {
    public static void main(String[] args) {
        System.out.println("Desenvolvido por Antonio Augusto da Fonseca - 25046981-5");
        CursoRepository cursoRepo = new CursoRepository();
        AlunoRepository alunoRepo = new AlunoRepository();
        ProfessorRepository professorRepo = new ProfessorRepository();
        TurmaRepository turmaRepo = new TurmaRepository();
        UsuarioRepository usuarioRepo = new UsuarioRepository();

        CursoService cursoService = new CursoService(cursoRepo);
        AlunoService alunoService = new AlunoService(alunoRepo, cursoRepo, usuarioRepo);
        ProfessorService professorService = new ProfessorService(professorRepo, usuarioRepo);
        TurmaService turmaService = new TurmaService(turmaRepo, cursoRepo, professorRepo);

        MenuPrincipal menu = new MenuPrincipal(
                alunoService,
                professorService,
                cursoService,
                turmaService);

        menu.iniciar();
    }
}