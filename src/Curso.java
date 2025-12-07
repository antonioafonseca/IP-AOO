/*
CURSO SUPERIOR DE TECNOLOGIA EM ANÁLISE E DESENVOLVIMENTO DE SISTEMAS
IMERSÃO PROFISSIONAL: APLICANDO ORIENTAÇÃO A OBJETOS
ANTONIO AUGUSTO DA FONSECA - 25046981-5
*/

public class Curso {
    private String nome;
    private String codigo;
    private int cargaHoraria;

    public Curso(String nome, String codigo, int cargaHoraria) {
        if (nome == null || nome.isBlank())
            throw new IllegalArgumentException("nome inválido");
        if (codigo == null || codigo.isBlank())
            throw new IllegalArgumentException("codigo inválido");
        if (cargaHoraria <= 0)
            throw new IllegalArgumentException("cargaHoraria inválida");
        this.nome = nome;
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String detalharCurso() {
        return "nome: " + nome + "\n" +
                "codigo: " + codigo + "\n" +
                "cargaHoraria: " + cargaHoraria + "\n";
    }

    @Override
    public String toString() {
        return "nome: " + nome + "\n" +
                "codigo: " + codigo + "\n" +
                "cargaHoraria: " + cargaHoraria + "\n";
    }
}