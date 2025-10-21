package com.cadastro;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import java.io.Serializable;
import java.util.List;

@Named("usuarioBean")
@ViewScoped
public class UsuarioBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Usuario usuario;
    private List<Usuario> usuarios;

    @Inject
    private UsuarioDAO usuarioDAO;

    @PostConstruct
    public void init() {
        novo();
        carregarLista();
    }

    public void novo() {
        usuario = new Usuario();
    }

    public void carregarLista() {
        usuarios = usuarioDAO.listar();
    }

    /**
     * Salvar cobre criação (persist) e atualização (merge).
     */
    public void salvar() {
        try {
            Usuario salvo = usuarioDAO.salvar(usuario);
            FacesContext fc = FacesContext.getCurrentInstance();
            if (fc != null) {
                fc.addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "Sucesso", "Usuário salvo (id=" + salvo.getId() + ")"));
            }
            novo();              // limpa formulário
            carregarLista();     // atualiza tabela
        } catch (Exception e) {
            FacesContext fc = FacesContext.getCurrentInstance();
            if (fc != null) {
                fc.addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                "Erro ao salvar", getRootMessage(e)));
            } else {
                e.printStackTrace();
            }
        }
    }

    /**
     * Prepara edição usando a entidade selecionada (detached ok).
     * Ao salvar, será feito merge no DAO.
     */
    public void editar(Usuario u) {
        this.usuario = u;
    }

    /**
     * Alternativa: carrega a entidade do banco por id (garante estado managed dentro do DAO).
     */
    public void editarPorId(Long id) {
        try {
            Usuario u = usuarioDAO.buscarPorId(id);
            if (u != null) {
                this.usuario = u;
            } else {
                FacesContext fc = FacesContext.getCurrentInstance();
                if (fc != null) {
                    fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Aviso", "Usuário não encontrado"));
                }
            }
        } catch (Exception e) {
            FacesContext fc = FacesContext.getCurrentInstance();
            if (fc != null) {
                fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Erro", getRootMessage(e)));
            } else {
                e.printStackTrace();
            }
        }
    }

    public void remover(Usuario u) {
        try {
            boolean ok = usuarioDAO.remover(u.getId());
            FacesContext fc = FacesContext.getCurrentInstance();
            if (fc != null) {
                if (ok) {
                    fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Removido", "Usuário removido com sucesso"));
                } else {
                    fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Não removido", "Usuário não encontrado"));
                }
            }
            carregarLista();
        } catch (Exception e) {
            FacesContext fc = FacesContext.getCurrentInstance();
            if (fc != null) {
                fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Erro ao remover", getRootMessage(e)));
            } else {
                e.printStackTrace();
            }
        }
    }

    // utilitário para extrair mensagem raiz de exceção
    private String getRootMessage(Throwable t) {
        Throwable root = t;
        while (root.getCause() != null) root = root.getCause();
        return root.getMessage() != null ? root.getMessage() : t.toString();
    }

    // getters / setters
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarios() {
        // garantir que a lista esteja carregada (lazy safe)
        if (usuarios == null) {
            carregarLista();
        }
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
