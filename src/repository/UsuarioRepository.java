/*
    CURSO SUPERIOR DE TECNOLOGIA EM ANÁLISE E DESENVOLVIMENTO DE SISTEMAS
    IMERSÃO PROFISSIONAL: APLICANDO ORIENTAÇÃO A OBJETOS
    ANTONIO AUGUSTO DA FONSECA - 25046981-5
*/

package repository;

import model.Usuario;
import java.util.*;

public class UsuarioRepository {

    private List<Usuario> usuarios = new ArrayList<>();

    public void salvar(Usuario u) {
        usuarios.add(u);
    }

    public Usuario buscarPorLogin(String login) {
        return usuarios.stream()
                .filter(u -> u.getLogin().equalsIgnoreCase(login))
                .findFirst()
                .orElse(null);
    }
}