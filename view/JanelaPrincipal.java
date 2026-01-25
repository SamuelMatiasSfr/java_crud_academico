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
    private JButton botaoAluno, botaoProfessor, botaoServidor;
    private JPanel painel; 

    public JanelaPrincipal(){
        super("Tela Inicial");
        setSize(300,200);
        setLocationRelativeTo(null);

        criarComponentes();
        criarPainel();

        setVisible(true);
    }

    private void criarComponentes(){
        label = new JLabel("Escolha o que adicionar:");
		botaoAluno = new JButton("Aluno");
        botaoProfessor = new JButton("Professor");
		botaoServidor = new JButton("Administrador");

        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoAluno.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoProfessor.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoServidor.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    private void criarPainel(){
        painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.PAGE_AXIS));
        painel.add(Box.createVerticalGlue());
        painel.add(label);
        painel.add(Box.createRigidArea(new Dimension(0,10)));
        painel.add(botaoAluno);
        painel.add(Box.createRigidArea(new Dimension(0,10)));
        painel.add(botaoProfessor);
        painel.add(Box.createRigidArea(new Dimension(0,10)));
        painel.add(botaoServidor);
        painel.add(Box.createVerticalGlue());
        add(painel, BorderLayout.CENTER);
    }

}
