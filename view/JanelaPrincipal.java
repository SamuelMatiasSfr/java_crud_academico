package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

public class JanelaPrincipal extends JFrame {
    
    private JLabel label;
    private JButton botao;
    private JComboBox<String> opcoes;
    private JPanel painel; 

    public JanelaPrincipal(){
        super("Tela Inicial");
        setSize(400,200);
        setLocationRelativeTo(null);

        criarComponentes();
        criarPainel();

        setVisible(true);
    }

    private void criarComponentes(){
        label = new JLabel("Escolha o gerenciador:");
        botao = new JButton("Mostrar");
		opcoes = new JComboBox<>();
        opcoes.addItem("Gerenciador de Alunos");
        opcoes.addItem("Gerenciador de Professores");
        opcoes.addItem("Gerenciador de Técnicos-Administrativos");
        opcoes.setMaximumSize(new Dimension(250, 25));

        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        opcoes.setAlignmentX(Component.CENTER_ALIGNMENT);
        botao.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    private void criarPainel(){
        painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.PAGE_AXIS));
        painel.add(Box.createVerticalGlue());
        painel.add(label);
        painel.add(Box.createRigidArea(new Dimension(0,15)));
        painel.add(opcoes);
        painel.add(Box.createRigidArea(new Dimension(0,15)));
        painel.add(botao);
        painel.add(Box.createVerticalGlue());
        painel.setBorder(new EmptyBorder(15,15,15,15));
        add(painel, BorderLayout.CENTER);
    }

    public JButton getBotao() {
        return botao;
    }

    public static void main(String[] args) {
        JanelaPrincipal janelaPrincipal = new JanelaPrincipal();
    }

}
