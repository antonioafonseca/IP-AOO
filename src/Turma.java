/*
CURSO SUPERIOR DE TECNOLOGIA EM ANÁLISE E DESENVOLVIMENTO DE SISTEMAS
IMERSÃO PROFISSIONAL: APLICANDO ORIENTAÇÃO A OBJETOS
ANTONIO AUGUSTO DA FONSECA - 25046981-5
*/

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private String codigo;
    private Professor professor;
    private Curso curso;
    private List<Aluno> listaAlunos = new ArrayList<>();

    public Turma(String codigo, Professor professor, Curso curso) {
        if (codigo == null || codigo.isBlank())
            throw new IllegalArgumentException("codigo inválido");
        this.codigo = codigo;
        this.professor = professor;
        this.curso = curso;
    }

    public boolean adicionarAluno(Aluno a) {
        if (a == null)
            return false;
        if (listaAlunos.stream().anyMatch(x -> x.getMatricula().equals(a.getMatricula())))
            return false;
        listaAlunos.add(a);
        return true;
    }

    public boolean removerAluno(String matricula) {
        return listaAlunos.removeIf(a -> a.getMatricula().equals(matricula));
    }

    public void resumo() {
        System.out.println("Turma[codigo=" + codigo + ", professor=" + (professor != null ? professor.getNome() : "N/A")
                +
                ", curso=" + (curso != null ? curso.getNome() : "N/A") + ", qtdAlunos=" + listaAlunos.size() + "]");
    }

    public List<Aluno> getListaAlunos() {
        return List.copyOf(listaAlunos);
    }
}