/*
CURSO SUPERIOR DE TECNOLOGIA EM ANÁLISE E DESENVOLVIMENTO DE SISTEMAS
IMERSÃO PROFISSIONAL: APLICANDO ORIENTAÇÃO A OBJETOS
ANTONIO AUGUSTO DA FONSECA - 25046981-5
*/

package service;

import model.Professor;
import repository.*;

public class ProfessorService {

    private final ProfessorRepository repo;
    private final UsuarioRepository usuarioRepo;

    public ProfessorService(ProfessorRepository repo, UsuarioRepository usuarioRepo) {
        this.repo = repo;
        this.usuarioRepo = usuarioRepo;
    }

    public boolean loginDisponivel(String login) {
        return usuarioRepo.buscarPorLogin(login) == null;
    }

    public boolean registroDisponivel(String registro) {
        return repo.buscarPorRegistro(registro) == null;
    }

    public boolean cadastrarProfessor(
            String nome,
            String login,
            String senha,
            String especialidade,
            String registro) {

        if (!loginDisponivel(login))
            return false;

        if (!registroDisponivel(registro))
            return false;

        Professor professor = new Professor(nome, login, senha, especialidade, registro);

        repo.salvar(professor);
        usuarioRepo.salvar(professor);

        return true;
    }

    public java.util.List<Professor> listar() {
        return repo.listar();
    }
}