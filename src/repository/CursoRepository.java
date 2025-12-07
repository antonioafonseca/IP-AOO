/*
    CURSO SUPERIOR DE TECNOLOGIA EM ANÁLISE E DESENVOLVIMENTO DE SISTEMAS
    IMERSÃO PROFISSIONAL: APLICANDO ORIENTAÇÃO A OBJETOS
    ANTONIO AUGUSTO DA FONSECA - 25046981-5
*/

package repository;

import model.Curso;
import java.util.*;

public class CursoRepository {

    private List<Curso> cursos = new ArrayList<>();

    public void salvar(Curso c) {
        cursos.add(c);
    }

    public List<Curso> listar() {
        return cursos;
    }

    public Curso buscarPorCodigo(String codigo) {
        return cursos.stream()
                .filter(c -> c.getCodigo().equalsIgnoreCase(codigo))
                .findFirst()
                .orElse(null);
    }
}