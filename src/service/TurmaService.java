/*
CURSO SUPERIOR DE TECNOLOGIA EM ANÁLISE E DESENVOLVIMENTO DE SISTEMAS
IMERSÃO PROFISSIONAL: APLICANDO ORIENTAÇÃO A OBJETOS
ANTONIO AUGUSTO DA FONSECA - 25046981-5
*/

package service;

import model.*;
import repository.*;

public class TurmaService {

    private final TurmaRepository turmaRepo;
    private final CursoRepository cursoRepo;
    private final ProfessorRepository professorRepo;

    public TurmaService(
            TurmaRepository turmaRepo,
            CursoRepository cursoRepo,
            ProfessorRepository professorRepo) {
        this.turmaRepo = turmaRepo;
        this.cursoRepo = cursoRepo;
        this.professorRepo = professorRepo;
    }

    public boolean codigoDisponivel(String codigo) {
        return turmaRepo.buscarPorCodigo(codigo) == null;
    }

    public boolean cadastrarTurma(String codigoTurma, String codigoCurso, String registroProfessor) {

        if (!codigoDisponivel(codigoTurma))
            return false;

        Curso curso = cursoRepo.buscarPorCodigo(codigoCurso);
        Professor professor = professorRepo.buscarPorRegistro(registroProfessor);

        if (curso == null || professor == null)
            return false;

        Turma turma = new Turma(codigoTurma, professor, curso);

        turmaRepo.salvar(turma);

        return true;
    }

    public java.util.List<Turma> listar() {
        return turmaRepo.listar();
    }
}