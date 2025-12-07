/*
CURSO SUPERIOR DE TECNOLOGIA EM ANÁLISE E DESENVOLVIMENTO DE SISTEMAS
IMERSÃO PROFISSIONAL: APLICANDO ORIENTAÇÃO A OBJETOS
ANTONIO AUGUSTO DA FONSECA - 25046981-5
*/

package model;

public class CursoEAD extends Curso {

    private String plataformaVirtual;

    public CursoEAD(String nome, String codigo, int cargaHoraria, String plataformaVirtual) {
        super(nome, codigo, cargaHoraria);
        this.plataformaVirtual = plataformaVirtual != null ? plataformaVirtual : "";
    }

    public String getPlataformaVirtual() {
        return plataformaVirtual;
    }

    @Override
    public String detalharCurso() {
        return "Curso EAD\n" +
                "nome: " + getNome() + "\n" +
                "codigo: " + getCodigo() + "\n" +
                "cargaHoraria: " + getCargaHoraria() + "\n" +
                "plataformaVirtual: " + plataformaVirtual + "\n";
    }

    @Override
    public String toString() {
        return detalharCurso();
    }
}