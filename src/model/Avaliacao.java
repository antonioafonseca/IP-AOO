/*
CURSO SUPERIOR DE TECNOLOGIA EM ANÁLISE E DESENVOLVIMENTO DE SISTEMAS
IMERSÃO PROFISSIONAL: APLICANDO ORIENTAÇÃO A OBJETOS
ANTONIO AUGUSTO DA FONSECA - 25046981-5
*/

package model;

public class Avaliacao {
    private double nota;
    private String descricao;

    public Avaliacao(String descricao) {
        this.descricao = descricao != null ? descricao : "";
        this.nota = 0.0;
    }

    public double getNota() {
        return nota;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean atribuirNota(double valor) {
        if (valor < 0.0 || valor > 10.0)
            return false;
        this.nota = valor;
        return true;
    }

    @Override
    public String toString() {
        return "descricao: " + descricao + "\n" +
                "nota: " + String.format("%.2f", nota) + "\n";
    }
}