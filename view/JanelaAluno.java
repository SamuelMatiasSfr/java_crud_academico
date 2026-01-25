package view;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

public class JanelaAluno extends JFrame {

    private JLabel labelMatricula, labelNome, labelEmail;
    private JTextField textoMatricula, textoNome, textoEmail;
    private JButton botaoCreate, botaoUpdate, botaoDelete;
    private JPanel painelPrincipal, painelMatricula, painelNome, painelEmail, painelBotoes;
    
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
        criarTextos();
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

    private void criarTextos(){
        textoMatricula = new JTextField("");
        textoNome = new JTextField("");
        textoEmail = new JTextField("");

        textoMatricula.setAlignmentX(Component.CENTER_ALIGNMENT);
        textoNome.setAlignmentX(Component.CENTER_ALIGNMENT);
        textoEmail.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    private void criarBotoes(){
        botaoCreate = new JButton("Create");
        botaoUpdate = new JButton("Update");
        botaoDelete = new JButton("Delete");

        botaoCreate.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoUpdate.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoDelete.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    private void criarPaneis(){
        criarPainelMatricula();
        criarPainelNome();
        criarPainelEmail();
        criarPainelBotoes();
        criarPainelPrincipal();
        add(painelPrincipal, BorderLayout.WEST);
    }

    private void criarPainelMatricula(){
        painelMatricula = new JPanel();
        painelMatricula.setLayout(new BoxLayout(painelMatricula, BoxLayout.Y_AXIS));
        painelMatricula.add(Box.createVerticalBox());
        painelMatricula.add(labelMatricula);
        painelMatricula.add(Box.createRigidArea(new Dimension(10, 0)));
        painelMatricula.add(textoMatricula);
        painelMatricula.add(Box.createVerticalBox());
    }

    private void criarPainelNome(){
        painelNome = new JPanel();
        painelNome.setLayout(new BoxLayout(painelNome, BoxLayout.Y_AXIS));
        painelNome.add(Box.createVerticalBox());
        painelNome.add(labelNome);
        painelNome.add(Box.createRigidArea(new Dimension(10, 0)));
        painelNome.add(textoNome);
        painelNome.add(Box.createVerticalBox());
    }

    private void criarPainelEmail(){
        painelEmail = new JPanel();
        painelEmail.setLayout(new BoxLayout(painelEmail, BoxLayout.Y_AXIS));
        painelEmail.add(Box.createVerticalBox());
        painelEmail.add(labelEmail);
        painelEmail.add(Box.createRigidArea(new Dimension(10, 0)));
        painelEmail.add(textoEmail);
        painelNome.add(Box.createVerticalBox());
    }

    private void criarPainelBotoes(){
        painelBotoes = new JPanel();
        painelBotoes.setLayout(new BoxLayout(painelBotoes, BoxLayout.X_AXIS));
        painelBotoes.add(Box.createHorizontalBox());
        painelBotoes.add(botaoCreate);
        painelBotoes.add(Box.createRigidArea(new Dimension(10, 0)));
        painelBotoes.add(botaoUpdate);
        painelBotoes.add(Box.createRigidArea(new Dimension(10, 0)));
        painelBotoes.add(botaoDelete);
        painelBotoes.add(Box.createHorizontalGlue());
    }

    private void criarPainelPrincipal(){
        painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BoxLayout(painelPrincipal, BoxLayout.PAGE_AXIS));
        painelPrincipal.add(Box.createVerticalBox());
        painelPrincipal.add(painelMatricula, BorderLayout.WEST);
        painelPrincipal.add(Box.createRigidArea(new Dimension(0, 15)));
        painelPrincipal.add(painelNome, BorderLayout.WEST);
        painelPrincipal.add(Box.createRigidArea(new Dimension(0, 15)));
        painelPrincipal.add(painelEmail, BorderLayout.WEST);
        painelPrincipal.add(Box.createRigidArea(new Dimension(0, 15)));
        painelPrincipal.add(painelBotoes, BorderLayout.WEST);
    }

    public JButton getBotaoCreate() {
        return botaoCreate;
    }

    public JButton getBotaoUpdate() {
        return botaoUpdate;
    }

    public JButton getBotaoDelete() {
        return botaoDelete;
    }

    public JTextField getTextoMatricula() {
        return textoMatricula;
    }

    public void setTextoMatricula(JTextField textoMatricula) {
        this.textoMatricula = textoMatricula;
    }

    public JTextField getTextoNome() {
        return textoNome;
    }

    public void setTextoNome(JTextField textoNome) {
        this.textoNome = textoNome;
    }

    public JTextField getTextoEmail() {
        return textoEmail;
    }

   public void setTextoEmail(JTextField textoEmail) {
        this.textoEmail = textoEmail;
    }

    public static void main(String[] args) {
        JanelaAluno janela = new JanelaAluno();
    }

}
