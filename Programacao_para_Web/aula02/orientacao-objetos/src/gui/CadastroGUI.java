package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CadastroGUI extends JFrame {
    private JTextField campoNome;
    private JComboBox<String> tipoAnimal;
    private JTextArea resultado;

    public CadastroGUI() {
        setTitle("Cadastro de Animais");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        campoNome = new JTextField(20);
        tipoAnimal = new JComboBox<>(new String[]{"Cachorro", "Gato"});
        JButton btnCadastrar = new JButton("Cadastrar");
        resultado = new JTextArea(5, 30);
        resultado.setEditable(false);

        add(new JLabel("Nome do Animal:"));
        add(campoNome);
        add(new JLabel("Tipo:"));
        add(tipoAnimal);
        add(btnCadastrar);
        add(new JScrollPane(resultado));

        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = campoNome.getText();
                String tipo = (String) tipoAnimal.getSelectedItem();
                Animal animal;

                if (tipo.equals("Cachorro")) {
                    animal = new Cachorro(nome);
                } else {
                    animal = new Gato(nome);
                }

                resultado.append("Animal: " + animal.getNome() + " - Som: " + animal.emitirSom() + "\n");
                campoNome.setText("");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CadastroGUI().setVisible(true));
    }
}
