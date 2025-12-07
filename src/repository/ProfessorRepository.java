/*
    CURSO SUPERIOR DE TECNOLOGIA EM ANÁLISE E DESENVOLVIMENTO DE SISTEMAS
    IMERSÃO PROFISSIONAL: APLICANDO ORIENTAÇÃO A OBJETOS
    ANTONIO AUGUSTO DA FONSECA - 25046981-5
*/

package repository;

import model.Professor;
import java.util.*;

public class ProfessorRepository {

    private List<Professor> professores = new ArrayList<>();

    public void salvar(Professor p) {
        professores.add(p);
    }

    public List<Professor> listar() {
        return professores;
    }

    public Professor buscarPorRegistro(String registro) {
        return professores.stream()
                .filter(p -> p.getRegistro().equalsIgnoreCase(registro))
                .findFirst()
                .orElse(null);
    }
}