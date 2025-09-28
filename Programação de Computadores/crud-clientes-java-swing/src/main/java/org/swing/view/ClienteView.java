package org.swing.view;

import org.swing.dao.ClienteDAO;
import org.swing.model.Cliente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.List;

public class ClienteView extends JFrame {
    private JTextField txtNome, txtEmail, txtTelefone, txtCidade, txtEstado;
    private JTable tabela;
    private DefaultTableModel modelo;
    private ClienteDAO dao = new ClienteDAO();

    public ClienteView() {
        setTitle("Gerenciador de Clientes");
        setSize(1000, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Formulário
        JPanel form = new JPanel(new GridLayout(2, 6));
        txtNome = new JTextField(); txtEmail = new JTextField(); txtTelefone = new JTextField();
        txtCidade = new JTextField(); txtEstado = new JTextField();
        JButton btnSalvar = new JButton("Salvar");

        form.add(new JLabel("Nome")); form.add(txtNome);
        form.add(new JLabel("Email")); form.add(txtEmail);
        form.add(new JLabel("Telefone")); form.add(txtTelefone);
        form.add(new JLabel("Cidade")); form.add(txtCidade);
        form.add(new JLabel("Estado")); form.add(txtEstado);
        form.add(btnSalvar);

        add(form, BorderLayout.NORTH);

        // Tabela
        modelo = new DefaultTableModel(new String[]{"ID", "Nome", "Email", "Telefone", "Cidade", "Estado"}, 0);
        tabela = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabela);
        add(scroll, BorderLayout.CENTER);

        // Botões
        JButton btnEditar = new JButton("Editar");
        JButton btnExcluir = new JButton("Excluir");
        JPanel botoes = new JPanel();
        botoes.add(btnEditar); botoes.add(btnExcluir);
        add(botoes, BorderLayout.SOUTH);

        // Eventos
        btnSalvar.addActionListener(e -> salvar());
        btnEditar.addActionListener(e -> editar());
        btnExcluir.addActionListener(e -> excluir());

        carregarTabela();
        setVisible(true);
    }

    private void salvar() {
        try {
            Cliente c = new Cliente();
            c.setNome(txtNome.getText());
            c.setEmail(txtEmail.getText());
            c.setTelefone(txtTelefone.getText());
            c.setCidade(txtCidade.getText());
            c.setEstado(txtEstado.getText());
            dao.inserir(c);
            limparCampos();
            carregarTabela();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar: " + ex.getMessage());
        }
    }

    private void editar() {
        int linha = tabela.getSelectedRow();
        if (linha >= 0) {
            try {
                Cliente c = new Cliente();
                c.setId((int) modelo.getValueAt(linha, 0));
                c.setNome(txtNome.getText());
                c.setEmail(txtEmail.getText());
                c.setTelefone(txtTelefone.getText());
                c.setCidade(txtCidade.getText());
                c.setEstado(txtEstado.getText());
                dao.atualizar(c);
                limparCampos();
                carregarTabela();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao editar: " + ex.getMessage());
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void excluir() {
        int linha = tabela.getSelectedRow();
        if (linha >= 0) {
            int id = (int) modelo.getValueAt(linha, 0);
            try {
                dao.excluir(id);
                carregarTabela();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao excluir: " + ex.getMessage());
            }
        }
    }

    private void carregarTabela() {
        try {
            modelo.setRowCount(0);
            List<Cliente> lista = dao.listar();
            for (Cliente c : lista) {
                modelo.addRow(new Object[]{c.getId(), c.getNome(), c.getEmail(), c.getTelefone(), c.getCidade(), c.getEstado()});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar: " + ex.getMessage());
        }
    }

    private void limparCampos() {
        txtNome.setText(""); txtEmail.setText(""); txtTelefone.setText("");
        txtCidade.setText(""); txtEstado.setText("");
    }
}