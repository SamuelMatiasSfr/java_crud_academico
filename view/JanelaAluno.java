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

    private JLabel labelId, labelMatricula, labelNome, labelEmail;
    private JTextField textoId, textoMatricula, textoNome, textoEmail;
    private JButton botaoCreate, botaoUpdate, botaoDelete;
    private JPanel painelPrincipal, painelId, painelMatricula, painelNome, painelEmail, painelBotoes;
    private DefaultTableModel tabelaModel;
    private JTable tabela;
    private JScrollPane painelScroll;

    public JanelaAluno(){
        super("Gerenciador Alunos");
        setSize(750,350);
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
        labelId = new JLabel("Identificador: ");
        labelMatricula = new JLabel("Matrícula: ");
        labelNome = new JLabel("Nome: ");
        labelEmail = new JLabel("Email: ");

        labelId.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelMatricula.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelNome.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelEmail.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    private void criarTextos(){
        textoId = new JTextField("");
        textoId.setEnabled(false);
        textoMatricula = new JTextField("");
        textoNome = new JTextField("");
        textoEmail = new JTextField("");

        textoId.setAlignmentX(Component.CENTER_ALIGNMENT);
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
        tabelaModel = new DefaultTableModel();
        String [] colunas = {"Identificador", "Matrícula", "Nome", "Email"};
        for(int i=0; i<colunas.length; i++){
            tabelaModel.addColumn(colunas[i]);
        }
        tabela = new JTable(tabelaModel);
    }

    private void criarPaneis(){
        criarPainelId();
        criarPainelMatricula();
        criarPainelNome();
        criarPainelEmail();
        criarPainelBotoes();
        criarPainelPrincipal();
        criarPainelScroll();
        add(painelPrincipal, BorderLayout.WEST);
        add(painelScroll, BorderLayout.EAST);
    }

    private void criarPainelId(){
        painelId = new JPanel();
        painelId.setLayout(new BoxLayout(painelId, BoxLayout.Y_AXIS));
        painelId.add(labelId);
        painelId.add(textoId);
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
        painelPrincipal.add(painelId, BorderLayout.WEST);
        painelPrincipal.add(Box.createRigidArea(new Dimension(0, 15)));
        painelPrincipal.add(painelMatricula, BorderLayout.WEST);
        painelPrincipal.add(Box.createRigidArea(new Dimension(0, 15)));
        painelPrincipal.add(painelNome, BorderLayout.WEST);
        painelPrincipal.add(Box.createRigidArea(new Dimension(0, 15)));
        painelPrincipal.add(painelEmail, BorderLayout.WEST);
        painelPrincipal.add(Box.createRigidArea(new Dimension(0, 15)));
        painelPrincipal.add(painelBotoes, BorderLayout.WEST);
        painelPrincipal.setBorder(new EmptyBorder(15,15,15,15));
    }

    private void criarPainelScroll(){
        painelScroll = new JScrollPane(tabela);
        painelScroll.setBorder(new EmptyBorder(15,0,15,15));
    }

    public void definirTabela(Object [][] dados){
        tabelaModel.setRowCount(0);
        for(int i=0; i<dados.length; i++){
            tabelaModel.addRow(dados[i]);
        }
        tabela.setModel(tabelaModel);
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

    public JTextField getTextoId() {
        return textoId;
    }

    public void setTextoId(JTextField textoId) {
        this.textoId = textoId;
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

    public JTable getTabela() {
        return tabela;
    }

}
