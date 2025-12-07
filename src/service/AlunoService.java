/*
    CURSO SUPERIOR DE TECNOLOGIA EM ANÁLISE E DESENVOLVIMENTO DE SISTEMAS
    IMERSÃO PROFISSIONAL: APLICANDO ORIENTAÇÃO A OBJETOS
    ANTONIO AUGUSTO DA FONSECA - 25046981-5
*/

package service;

import model.Aluno;
import model.Curso;
import repository.*;

public class AlunoService {

    private final AlunoRepository alunoRepo;
    private final CursoRepository cursoRepo;
    private final UsuarioRepository usuarioRepo;

    public AlunoService(AlunoRepository alunoRepo, CursoRepository cursoRepo, UsuarioRepository usuarioRepo) {
        this.alunoRepo = alunoRepo;
        this.cursoRepo = cursoRepo;
        this.usuarioRepo = usuarioRepo;
    }

    public boolean loginDisponivel(String login) {
        return usuarioRepo.buscarPorLogin(login) == null;
    }

    public boolean matriculaDisponivel(String matricula) {
        return alunoRepo.buscarPorMatricula(matricula) == null;
    }

    public boolean cadastrarAluno(
            String nome,
            String login,
            String senha,
            String matricula,
            String codigoCurso) {

        if (!loginDisponivel(login))
            return false;

        if (!matriculaDisponivel(matricula))
            return false;

        Curso curso = cursoRepo.buscarPorCodigo(codigoCurso);
        if (curso == null)
            return false;

        Aluno aluno = new Aluno(nome, login, senha, matricula, curso);

        alunoRepo.salvar(aluno);
        usuarioRepo.salvar(aluno);

        return true;
    }

    public java.util.List<Aluno> listar() {
        return alunoRepo.listar();
    }
}