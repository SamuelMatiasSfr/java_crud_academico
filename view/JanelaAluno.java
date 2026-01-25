package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JPanel;

import java.awt.Component;

public class JanelaAluno extends JFrame {

    private JLabel labelMatricula, labelNome, labelEmail;
    private JTextField textMatricula, textNome, textEmail;
    private JButton buttonCreate, buttonUpdate, buttonDelete;
    private JPanel panelMatricula, panelNome, panelEmail, panelBotoes;
    private JTable tabela;
    
    public JanelaAluno(){
        super("Gerenciador Alunos");
        setSize(300,200);
        setLocationRelativeTo(null);

        criarComponentes();

        setVisible(true);
    }

    private void criarComponentes(){
        criarLabels();
        criarBotoes();
    }

    private void criarLabels(){
        labelMatricula = new JLabel("Matrícula: ");
        labelNome = new JLabel("Nome: ");
        labelEmail = new JLabel("Email: ");

        labelMatricula.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelNome.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelEmail.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    private void criarBotoes(){
		buttonCreate = new JButton("Create");
        buttonUpdate = new JButton("Update");
        buttonDelete = new JButton("Delete");

        buttonCreate.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonUpdate.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonDelete.setAlignmentX(Component.CENTER_ALIGNMENT);
    }
    
}
