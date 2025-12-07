/*
    CURSO SUPERIOR DE TECNOLOGIA EM ANÁLISE E DESENVOLVIMENTO DE SISTEMAS
    IMERSÃO PROFISSIONAL: APLICANDO ORIENTAÇÃO A OBJETOS
    ANTONIO AUGUSTO DA FONSECA - 25046981-5
*/

package repository;

import model.Aluno;
import java.util.*;

public class AlunoRepository {

    private List<Aluno> alunos = new ArrayList<>();

    public void salvar(Aluno a) {
        alunos.add(a);
    }

    public List<Aluno> listar() {
        return alunos;
    }

    public Aluno buscarPorMatricula(String matricula) {
        return alunos.stream()
                .filter(a -> a.getMatricula().equalsIgnoreCase(matricula))
                .findFirst()
                .orElse(null);
    }
}