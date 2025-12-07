/*
CURSO SUPERIOR DE TECNOLOGIA EM ANÁLISE E DESENVOLVIMENTO DE SISTEMAS
IMERSÃO PROFISSIONAL: APLICANDO ORIENTAÇÃO A OBJETOS
ANTONIO AUGUSTO DA FONSECA - 25046981-5
*/

public class Aluno {
    private String nome;
    private String matricula;
    private Curso curso;

    public Aluno(String nome, String matricula, Curso curso) {
        if (nome == null || nome.isBlank())
            throw new IllegalArgumentException("nome inválido");
        if (matricula == null || matricula.isBlank())
            throw new IllegalArgumentException("matrícula inválida");
        if (curso == null)
            throw new IllegalArgumentException("curso inválido");
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "nome: " + nome + "\n" +
                "matricula: " + matricula + "\n" +
                "curso: " + (curso != null ? curso.getNome() : "null") + "\n";
    }
}
