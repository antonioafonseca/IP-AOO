/*
CURSO SUPERIOR DE TECNOLOGIA EM ANÁLISE E DESENVOLVIMENTO DE SISTEMAS
IMERSÃO PROFISSIONAL: APLICANDO ORIENTAÇÃO A OBJETOS
ANTONIO AUGUSTO DA FONSECA - 25046981-5
*/

package repository;

import model.Turma;
import java.util.*;

public class TurmaRepository {

    private List<Turma> turmas = new ArrayList<>();

    public void salvar(Turma t) {
        turmas.add(t);
    }

    public List<Turma> listar() {
        return turmas;
    }

    public Turma buscarPorCodigo(String codigo) {
        return turmas.stream()
                .filter(t -> t.getCodigo().equalsIgnoreCase(codigo))
                .findFirst()
                .orElse(null);
    }
}