package view;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

public class JanelaAluno extends JFrame {

    private JLabel labelMatricula, labelNome, labelEmail;
    private JTextField textMatricula, textNome, textEmail;
    private JButton buttonCreate, buttonUpdate, buttonDelete;
    private JPanel panelPrincipal, panelMatricula, panelNome, panelEmail;
    
    public JanelaAluno(){
        super("Gerenciador Alunos");
        setSize(500,300);
        setLocationRelativeTo(null);

        criarComponentes();

        setVisible(true);
    }

    private void criarComponentes(){
        criarLabels();
        criarBotoes();
        criarTexts();
        criarPaneis();
    }

    private void criarLabels(){
        labelMatricula = new JLabel("Matrícula: ");
        labelNome = new JLabel("Nome: ");
        labelEmail = new JLabel("Email: ");

        labelMatricula.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelNome.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelEmail.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    private void criarTexts(){
        textMatricula = new JTextField("");
        textNome = new JTextField("");
        textEmail = new JTextField("");

        textMatricula.setAlignmentX(Component.CENTER_ALIGNMENT);
        textNome.setAlignmentX(Component.CENTER_ALIGNMENT);
        textEmail.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    private void criarBotoes(){
		buttonCreate = new JButton("Create");
        buttonUpdate = new JButton("Update");
        buttonDelete = new JButton("Delete");

        buttonCreate.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonUpdate.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonDelete.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    private void criarPaneis(){
        criarPanelMatricula();
        criarPanelPrincipal();
        add(panelPrincipal, BorderLayout.WEST);
    }

    private void criarPanelMatricula(){
        panelMatricula = new JPanel();
        panelMatricula.setLayout(new BoxLayout(panelMatricula, BoxLayout.X_AXIS));
        panelMatricula.add(Box.createHorizontalBox());
        panelMatricula.add(labelMatricula);
        panelMatricula.add(Box.createRigidArea(new Dimension(10, 0)));
        panelMatricula.add(textMatricula);
        panelMatricula.add(Box.createHorizontalGlue());
    }

    private void criarPanelPrincipal(){
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.PAGE_AXIS));
        panelPrincipal.add(panelMatricula, BorderLayout.WEST);
    }

    public JButton getButtonCreate() {
        return buttonCreate;
    }

    public JButton getButtonUpdate() {
        return buttonUpdate;
    }

    public JButton getButtonDelete() {
        return buttonDelete;
    }

    public JTextField getTextMatricula() {
        return textMatricula;
    }

    public void setTextMatricula(JTextField textMatricula) {
        this.textMatricula = textMatricula;
    }

    public JTextField getTextNome() {
        return textNome;
    }

    public void setTextNome(JTextField textNome) {
        this.textNome = textNome;
    }

    public JTextField getTextEmail() {
        return textEmail;
    }

    public void setTextEmail(JTextField textEmail) {
        this.textEmail = textEmail;
    }

    public static void main(String[] args) {
        JanelaAluno janela = new JanelaAluno();
    }
    
}
