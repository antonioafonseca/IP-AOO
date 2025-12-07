/*
    CURSO SUPERIOR DE TECNOLOGIA EM ANÁLISE E DESENVOLVIMENTO DE SISTEMAS
    IMERSÃO PROFISSIONAL: APLICANDO ORIENTAÇÃO A OBJETOS
    ANTONIO AUGUSTO DA FONSECA - 25046981-5
*/

package service;

import model.*;
import repository.CursoRepository;

public class CursoService {

    private final CursoRepository repo;

    public CursoService(CursoRepository repo) {
        this.repo = repo;
    }

    public boolean codigoDisponivel(String codigo) {
        return repo.buscarPorCodigo(codigo) == null;
    }

    public boolean cadastrarCurso(
            String nome,
            String codigo,
            int cargaHoraria,
            String tipo,
            String extra) {

        if (!codigoDisponivel(codigo))
            return false;

        Curso curso;

        if (tipo.equalsIgnoreCase("presencial")) {
            curso = new CursoPresencial(nome, codigo, cargaHoraria, extra);
        } else if (tipo.equalsIgnoreCase("ead")) {
            curso = new CursoEAD(nome, codigo, cargaHoraria, extra);
        } else {
            return false;
        }

        repo.salvar(curso);
        return true;
    }

    public java.util.List<Curso> listar() {
        return repo.listar();
    }

    public Curso buscarPorCodigo(String codigo) {
        return repo.buscarPorCodigo(codigo);
    }
}