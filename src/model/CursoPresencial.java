/*
    CURSO SUPERIOR DE TECNOLOGIA EM ANÁLISE E DESENVOLVIMENTO DE SISTEMAS
    IMERSÃO PROFISSIONAL: APLICANDO ORIENTAÇÃO A OBJETOS
    ANTONIO AUGUSTO DA FONSECA - 25046981-5
*/

package model;

public class CursoPresencial extends Curso {

    private String salaDeAula;

    public CursoPresencial(String nome, String codigo, int cargaHoraria, String salaDeAula) {
        super(nome, codigo, cargaHoraria);
        this.salaDeAula = salaDeAula != null ? salaDeAula : "";
    }

    public String getSalaDeAula() {
        return salaDeAula;
    }

    @Override
    public String detalharCurso() {
        return "Curso Presencial\n" +
                "nome: " + getNome() + "\n" +
                "codigo: " + getCodigo() + "\n" +
                "cargaHoraria: " + getCargaHoraria() + "\n" +
                "salaDeAula: " + salaDeAula + "\n";
    }

    @Override
    public String toString() {
        return detalharCurso();
    }
}