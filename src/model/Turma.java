/*
CURSO SUPERIOR DE TECNOLOGIA EM ANÁLISE E DESENVOLVIMENTO DE SISTEMAS
IMERSÃO PROFISSIONAL: APLICANDO ORIENTAÇÃO A OBJETOS
ANTONIO AUGUSTO DA FONSECA - 25046981-5
*/

package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Turma {
    private String codigo;
    private Professor professor;
    private Curso curso;
    private List<Aluno> listaAlunos = new ArrayList<>();
    private Map<Aluno, List<Avaliacao>> avaliacoes = new HashMap<>();

    public Turma(String codigo, Professor professor, Curso curso) {
        if (codigo == null || codigo.isBlank())
            throw new IllegalArgumentException("codigo inválido");
        this.codigo = codigo;
        this.professor = professor;
        this.curso = curso;
    }

    public String getCodigo() {
        return codigo;
    }

    public boolean adicionarAluno(Aluno a) {
        if (a == null)
            return false;
        if (listaAlunos.stream().anyMatch(x -> x.getMatricula().equals(a.getMatricula())))
            return false;
        listaAlunos.add(a);
        avaliacoes.put(a, new ArrayList<>());
        return true;
    }

    public boolean removerAluno(Aluno a) {
        if (a == null)
            return false;
        boolean removed = listaAlunos.remove(a);
        if (removed)
            avaliacoes.remove(a);
        return removed;
    }

    public void adicionarAvaliacaoParaAluno(Aluno a, Avaliacao av) {
        if (avaliacoes.containsKey(a))
            avaliacoes.get(a).add(av);
    }

    public void resumo() {
        System.out.println("Turma[codigo=" + codigo + ", professor=" + (professor != null ? professor.getNome() : "N/A")
                +
                ", curso=" + (curso != null ? curso.getNome() : "N/A") + ", qtdAlunos=" + listaAlunos.size() + "]");
    }

    public List<Aluno> getListaAlunos() {
        return List.copyOf(listaAlunos);
    }
    /*
     * @Override
     * public String toString() {
     * StringBuilder sb = new StringBuilder();
     * sb.append("codigo: ").append(codigo).append("\n");
     * sb.append("professor: ").append(professor != null ? professor.getNome() :
     * "null").append("\n");
     * sb.append("curso: ").append(curso != null ? curso.getNome() :
     * "null").append("\n");
     * sb.append("qtdAlunos: ").append(listaAlunos.size()).append("\n");
     * sb.append("alunos:\n");
     * for (Aluno a : listaAlunos) {
     * sb.append("  - ").append(a.getMatricula()).append(" : ").append(a.getNome()).
     * append("\n");
     * List<Avaliacao> avs = avaliacoes.getOrDefault(a, Collections.emptyList());
     * sb.append("    avaliacoes: ").append(avs.size()).append("\n");
     * for (Avaliacao av : avs) {
     * sb.append("      * ").append(av.toString().replace("\n",
     * " | ")).append("\n");
     * }
     * }
     * return sb.toString();
     * }
     */

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("codigo: ").append(codigo).append("\n");
        sb.append("professor: ").append(professor != null ? professor.getNome() : "N/A").append("\n");
        sb.append("curso: ").append(curso != null ? curso.getNome() : "N/A").append("\n");
        sb.append("qtdAlunos: ").append(listaAlunos.size()).append("\n");

        if (listaAlunos != null && !listaAlunos.isEmpty()) {
            sb.append("alunos:\n");
            for (Aluno a : listaAlunos) {
                sb.append("  - ").append(a.getMatricula()).append(" : ").append(a.getNome()).append("\n");
                List<Avaliacao> avs = avaliacoes.getOrDefault(a, Collections.emptyList());
                if (!avs.isEmpty()) {
                    sb.append("    avaliacoes:\n");
                    for (Avaliacao av : avs) {
                        sb.append("      * ").append(av.toString().replace("\n", " | ")).append("\n");
                    }
                }
            }
        }

        return sb.toString();

    }

}