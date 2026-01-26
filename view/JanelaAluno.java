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

public class JanelaAluno extends JFrame {

    private JLabel labelMatricula, labelNome, labelEmail;
    private JTextField textoMatricula, textoNome, textoEmail;
    private JButton botaoCreate, botaoUpdate, botaoDelete;
    private JPanel painelPrincipal, painelMatricula, painelNome, painelEmail, painelBotoes;
    private DefaultTableModel tabelaModel;
    private JTable tabela;
    private JScrollPane painelScroll;

    public JanelaAluno(){
        super("Gerenciador Alunos");
        setSize(750,300);
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
        tabelaModel.insertRow(0, new Object[] {"2026004", "Lidia", "lidia@gmail.com"});
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

    private void criarTabela(){
        String [] colunas = {"Matrícula", "Nome", "Email"};
        Object [][] dados = {
            {"2026001", "Alana", "alana@gmail.com"},
            {"2026002", "Lucas", "lucas@gmail.com"},
            {"2026003", "Daniel", "daniel@gmail.com"},
            {"2026004", "Mariana", "mariana@gmail.com"},
            {"2026005", "Pedro", "pedro@gmail.com"},
            {"2026006", "Carla", "carla@gmail.com"},
            {"2026007", "Rafael", "rafael@gmail.com"},
            {"2026008", "Beatriz", "beatriz@gmail.com"},
            {"2026009", "João", "joao@gmail.com"},
            {"2026010", "Fernanda", "fernanda@gmail.com"},
            {"2026011", "Bruno", "bruno@gmail.com"},
            {"2026012", "Camila", "camila@gmail.com"},
            {"2026013", "Thiago", "thiago@gmail.com"},
            {"2026014", "Larissa", "larissa@gmail.com"},
            {"2026015", "Gabriel", "gabriel@gmail.com"}
        };

        tabelaModel = new DefaultTableModel(dados, colunas);
        tabela = new JTable(tabelaModel);
    }

    private void criarPaneis(){
        criarPainelMatricula();
        criarPainelNome();
        criarPainelEmail();
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
        painelPrincipal.add(Box.createVerticalBox());
        painelPrincipal.add(painelMatricula, BorderLayout.WEST);
        painelPrincipal.add(Box.createRigidArea(new Dimension(0, 15)));
        painelPrincipal.add(painelNome, BorderLayout.WEST);
        painelPrincipal.add(Box.createRigidArea(new Dimension(0, 15)));
        painelPrincipal.add(painelEmail, BorderLayout.WEST);
        painelPrincipal.add(Box.createRigidArea(new Dimension(0, 15)));
        painelPrincipal.add(painelBotoes, BorderLayout.WEST);
        painelPrincipal.setBorder(new EmptyBorder(10,10,10,10));
    }

    private void criarPainelScroll(){
        painelScroll = new JScrollPane(tabela);
        painelScroll.setBorder(new EmptyBorder(10,0,10,10));
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
