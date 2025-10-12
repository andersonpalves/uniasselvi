package com.cadastro;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class UsuarioBean implements Serializable {
    private Usuario usuario = new Usuario();
    private List<Usuario> usuarios = new ArrayList<>();

    public void adicionar() {
        System.out.println("Adicionando - Nome: " + usuario.getNome() + " - Email: " + usuario.getEmail());
        usuarios.add(usuario);
        usuario = new Usuario();
    }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public List<Usuario> getUsuarios() { return usuarios; }
}