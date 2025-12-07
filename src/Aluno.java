/*
CURSO SUPERIOR DE TECNOLOGIA EM ANÁLISE E DESENVOLVIMENTO DE SISTEMAS
IMERSÃO PROFISSIONAL: APLICANDO ORIENTAÇÃO A OBJETOS
ANTONIO AUGUSTO DA FONSECA - 25046981-5
*/

public class Aluno extends Usuario {
    private String matricula;
    private Curso curso;

    public Aluno(String nome, String login, String senha, String matricula, Curso curso) {
        if (nome == null || nome.isBlank())
            throw new IllegalArgumentException("nome inválido");
        if (matricula == null || matricula.isBlank())
            throw new IllegalArgumentException("matrícula inválida");
        if (curso == null)
            throw new IllegalArgumentException("curso inválido");
        super(nome, login, senha);
        this.matricula = matricula;
        this.curso = curso;
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
        return super.toString() +
                "matricula: " + matricula + "\n" +
                "curso: " + (curso != null ? curso.getNome() : "null") + "\n";
    }
}