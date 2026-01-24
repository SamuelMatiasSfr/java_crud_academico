package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

public class JanelaPrincipal extends JFrame {
    
    private JLabel label;
    private JButton buttonAluno, buttonProfessor, buttonServidor;
    private JPanel panel; 

    public JanelaPrincipal(){
        super("Tela Inicial");
        setSize(300,200);
        setLocationRelativeTo(null);

        criarComponentes();
        criarPanel();

        setVisible(true);
    }

    private void criarComponentes(){
        label = new JLabel("Escolha o que adicionar:");
		buttonAluno = new JButton("Aluno");
        buttonProfessor = new JButton("Professor");
		buttonServidor = new JButton("Administrador");

        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonAluno.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonProfessor.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonServidor.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    private void criarPanel(){
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.add(Box.createVerticalGlue());
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(0,10)));
        panel.add(buttonAluno);
        panel.add(Box.createRigidArea(new Dimension(0,10)));
        panel.add(buttonProfessor);
        panel.add(Box.createRigidArea(new Dimension(0,10)));
        panel.add(buttonServidor);
        panel.add(Box.createVerticalGlue());
        add(panel, BorderLayout.CENTER);
    }

}
