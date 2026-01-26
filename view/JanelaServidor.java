package view;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

public class JanelaServidor extends JFrame {

    private JLabel labelMatricula, labelNome, labelEmail, labelSetor;
    private JTextField textoMatricula, textoNome, textoEmail, textoSetor;
    private JButton botaoCreate, botaoUpdate, botaoDelete;
    private JPanel painelPrincipal, painelMatricula, painelNome, painelEmail, painelSetor, painelBotoes;
    private DefaultTableModel tabelaModel;
    private JTable tabela;
    private JScrollPane painelScroll;

    public JanelaServidor(){
        super("Gerenciador de Técnicos-Administrativos");
        setSize(750,400);
        setLocationRelativeTo(null);

        criarComponentes();

        setVisible(true);
    }

    private void criarComponentes(){
        criarLabels();
        criarTextos();
        criarBotoes();
        criarTabela();
        criarPaneis();
    }

    private void criarLabels(){
        labelMatricula = new JLabel("Matrícula: ");
        labelNome = new JLabel("Nome: ");
        labelEmail = new JLabel("Email: ");
        labelSetor = new JLabel("Setor: ");

        labelMatricula.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelNome.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelEmail.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelSetor.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    private void criarTextos(){
        textoMatricula = new JTextField("");
        textoNome = new JTextField("");
        textoEmail = new JTextField("");
        textoSetor = new JTextField("");

        textoMatricula.setAlignmentX(Component.CENTER_ALIGNMENT);
        textoNome.setAlignmentX(Component.CENTER_ALIGNMENT);
        textoEmail.setAlignmentX(Component.CENTER_ALIGNMENT);
        textoSetor.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    private void criarBotoes(){
        botaoCreate = new JButton("Create");
        botaoUpdate = new JButton("Update");
        botaoDelete = new JButton("Delete");

        botaoCreate.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoUpdate.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoDelete.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    private void criarTabela(){
        String [] colunas = {"Matrícula", "Nome", "Email", "Setor"};
        Object [][] dados = {
            {"2026001", "Alana", "alana@gmail.com", "Biblioteca"},
            {"2026002", "Lucas", "lucas@gmail.com", "Secretária"},
            {"2026003", "Daniel", "daniel@gmail.com", "Biblioteca"},
            {"2026004", "Mariana", "mariana@gmail.com", "Assistência"},
            {"2026005", "Pedro", "pedro@gmail.com", "Secretária"}
        };

        tabelaModel = new DefaultTableModel(dados, colunas);
        tabela = new JTable(tabelaModel);
    }

    private void criarPaneis(){
        criarPainelMatricula();
        criarPainelNome();
        criarPainelEmail();
        criarPainelSetor();
        criarPainelBotoes();
        criarPainelPrincipal();
        criarPainelScroll();
        add(painelPrincipal, BorderLayout.WEST);
        add(painelScroll, BorderLayout.EAST);
    }

    private void criarPainelMatricula(){
        painelMatricula = new JPanel();
        painelMatricula.setLayout(new BoxLayout(painelMatricula, BoxLayout.Y_AXIS));
        painelMatricula.add(labelMatricula);
        painelMatricula.add(textoMatricula);
    }

    private void criarPainelNome(){
        painelNome = new JPanel();
        painelNome.setLayout(new BoxLayout(painelNome, BoxLayout.Y_AXIS));
        painelNome.add(labelNome);
        painelNome.add(textoNome);
    }

    private void criarPainelEmail(){
        painelEmail = new JPanel();
        painelEmail.setLayout(new BoxLayout(painelEmail, BoxLayout.Y_AXIS));
        painelEmail.add(labelEmail);
        painelEmail.add(textoEmail);
    }

    private void criarPainelSetor(){
        painelSetor = new JPanel();
        painelSetor.setLayout(new BoxLayout(painelSetor, BoxLayout.Y_AXIS));
        painelSetor.add(labelSetor);
        painelSetor.add(textoSetor);
    }

    private void criarPainelBotoes(){
        painelBotoes = new JPanel();
        painelBotoes.setLayout(new BoxLayout(painelBotoes, BoxLayout.X_AXIS));
        painelBotoes.add(botaoCreate);
        painelBotoes.add(Box.createRigidArea(new Dimension(10, 0)));
        painelBotoes.add(botaoUpdate);
        painelBotoes.add(Box.createRigidArea(new Dimension(10, 0)));
        painelBotoes.add(botaoDelete);
    }

    private void criarPainelPrincipal(){
        painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BoxLayout(painelPrincipal, BoxLayout.PAGE_AXIS));
        painelPrincipal.add(painelMatricula);
        painelPrincipal.add(Box.createRigidArea(new Dimension(0, 15)));
        painelPrincipal.add(painelNome);
        painelPrincipal.add(Box.createRigidArea(new Dimension(0, 15)));
        painelPrincipal.add(painelEmail);
        painelPrincipal.add(Box.createRigidArea(new Dimension(0, 15)));
        painelPrincipal.add(painelSetor);
        painelPrincipal.add(Box.createRigidArea(new Dimension(0, 15)));
        painelPrincipal.add(painelBotoes);
        painelPrincipal.setBorder(new EmptyBorder(15,15,15,15));
    }

    private void criarPainelScroll(){
        painelScroll = new JScrollPane(tabela);
        painelScroll.setBorder(new EmptyBorder(15,0,15,15));
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

    public JTextField getTextoNome() {
        return textoNome;
    }

    public JTextField getTextoEmail() {
        return textoEmail;
    }

    public JTextField getTextoSetor() {
        return textoSetor;
    }

    public static void main(String[] args) {
        new JanelaServidor();
    }

}
