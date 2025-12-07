/*
CURSO SUPERIOR DE TECNOLOGIA EM ANÁLISE E DESENVOLVIMENTO DE SISTEMOS
IMERSÃO PROFISSIONAL: APLICANDO ORIENTAÇÃO A OBJETOS
ANTONIO AUGUSTO DA FONSECA - 25046981-5
*/

package model;

public class Administrador extends Usuario {

    public Administrador(String nome, String login, String senha) {
        super(nome, login, senha);
    }

    @Override
    public String toString() {
        return super.toString() + "perfil: Administrador\n";
    }
}