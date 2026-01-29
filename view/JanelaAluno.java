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
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

public class JanelaAluno extends JFrame {

    private JLabel labelId, labelMatricula, labelNome, labelEmail, labelErroCrud, labelErroBuscar, labelDigiteMatricula;
    private JTextField textoId, textoMatricula, textoNome, textoEmail, textoBuscar;
    private JButton botaoCreate, botaoUpdate, botaoDelete, botaoLimpar, botaoBuscar;
    private JPanel painelEsquerdo, painelDireito, painelId, painelMatricula, painelNome, painelEmail, painelErro, painelBotoes, painelBuscar;
    private DefaultTableModel tabelaModel;
    private JTable tabela;
    private JScrollPane painelScroll;

    public JanelaAluno(){
        super("Gerenciador Alunos");
        setSize(900,350);
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
        labelErroCrud = new JLabel("Registro já existente");
        labelErroCrud.setForeground(Color.RED);
        labelErroBuscar = new JLabel("Registro Inexistente");
        labelErroBuscar.setForeground(Color.RED);
        labelDigiteMatricula = new JLabel("Digite matrícula:");

        labelId.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelMatricula.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelNome.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelEmail.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelErroCrud.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelErroBuscar.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelDigiteMatricula.setAlignmentX(Component.CENTER_ALIGNMENT);

        labelErroCrud.setVisible(false);
        labelErroBuscar.setVisible(false);
    }

    private void criarTextos(){
        textoId = new JTextField("");
        textoId.setEnabled(false);
        textoMatricula = new JTextField("");
        textoNome = new JTextField("");
        textoEmail = new JTextField("");
        textoBuscar = new JTextField("");

        textoId.setAlignmentX(Component.CENTER_ALIGNMENT);
        textoMatricula.setAlignmentX(Component.CENTER_ALIGNMENT);
        textoNome.setAlignmentX(Component.CENTER_ALIGNMENT);
        textoEmail.setAlignmentX(Component.CENTER_ALIGNMENT);
        textoBuscar.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    private void criarBotoes(){
        botaoCreate = new JButton("Create");
        botaoUpdate = new JButton("Update");
        botaoDelete = new JButton("Delete");
        botaoLimpar = new JButton("Limpar campos");
        botaoBuscar = new JButton("Buscar");

        botaoCreate.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoUpdate.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoDelete.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoLimpar.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoBuscar.setAlignmentX(Component.CENTER_ALIGNMENT);
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
        criaPainelErro();
        criarPainelBotoes();
        criarPainelEsquerdo();
        criarPainelScroll();
        criarPainelBuscar();
        criarPainelDireito();
        add(painelEsquerdo, BorderLayout.WEST);
        add(painelDireito, BorderLayout.EAST);
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

    private void criaPainelErro(){
        painelErro = new JPanel();
        painelErro.setLayout(new BoxLayout(painelErro, BoxLayout.Y_AXIS));
        painelErro.add(labelErroCrud);
    }

    private void criarPainelBotoes(){
        painelBotoes = new JPanel();
        painelBotoes.setLayout(new BoxLayout(painelBotoes, BoxLayout.X_AXIS));
        painelBotoes.add(botaoCreate);
        painelBotoes.add(Box.createRigidArea(new Dimension(10, 0)));
        painelBotoes.add(botaoUpdate);
        painelBotoes.add(Box.createRigidArea(new Dimension(10, 0)));
        painelBotoes.add(botaoDelete);
        painelBotoes.add(Box.createRigidArea(new Dimension(10, 0)));
        painelBotoes.add(botaoLimpar);
    }

    private void criarPainelEsquerdo(){
        painelEsquerdo = new JPanel();
        painelEsquerdo.setLayout(new BoxLayout(painelEsquerdo, BoxLayout.PAGE_AXIS));
        painelEsquerdo.add(painelId, BorderLayout.WEST);
        painelEsquerdo.add(Box.createRigidArea(new Dimension(0, 15)));
        painelEsquerdo.add(painelMatricula, BorderLayout.WEST);
        painelEsquerdo.add(Box.createRigidArea(new Dimension(0, 15)));
        painelEsquerdo.add(painelNome, BorderLayout.WEST);
        painelEsquerdo.add(Box.createRigidArea(new Dimension(0, 15)));
        painelEsquerdo.add(painelEmail, BorderLayout.WEST);
        painelEsquerdo.add(Box.createRigidArea(new Dimension(0, 15)));
        painelEsquerdo.add(painelErro, BorderLayout.WEST);
        painelEsquerdo.add(Box.createRigidArea(new Dimension(0, 15)));
        painelEsquerdo.add(painelBotoes, BorderLayout.WEST);
        painelEsquerdo.setBorder(new EmptyBorder(15,15,15,15));
    }

    private void criarPainelScroll(){
        painelScroll = new JScrollPane(tabela);
    }

    private void criarPainelBuscar(){
        painelBuscar = new JPanel();
        painelBuscar.setLayout(new BoxLayout(painelBuscar, BoxLayout.X_AXIS));
        painelBuscar.add(labelDigiteMatricula);
        painelBuscar.add(Box.createRigidArea(new Dimension(10, 0)));
        painelBuscar.add(textoBuscar);
        painelBuscar.add(Box.createRigidArea(new Dimension(10, 0)));
        painelBuscar.add(botaoBuscar);
        painelBuscar.add(Box.createRigidArea(new Dimension(10, 0)));
        painelBuscar.add(labelErroBuscar);
    }

    private void criarPainelDireito(){
        painelDireito = new JPanel();
        painelDireito.setLayout(new BoxLayout(painelDireito, BoxLayout.PAGE_AXIS));
        painelDireito.add(painelScroll, BorderLayout.EAST);
        painelDireito.add(Box.createRigidArea(new Dimension(0, 15)));
        painelDireito.add(painelBuscar, BorderLayout.EAST);
        painelDireito.setBorder(new EmptyBorder(15,0,15,15));
    }

    public void definirTabela(Object [][] dados){
        tabelaModel.setRowCount(0);
        for(int i=0; i<dados.length; i++){
            tabelaModel.addRow(dados[i]);
        }
        tabela.setModel(tabelaModel);
    }

    public JLabel getLabelErroCrud() {
        return labelErroCrud;
    }

    public JLabel getLabelErroBuscar() {
        return labelErroBuscar;
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

    public JButton getBotaoLimpar() {
        return botaoLimpar;
    }

    public JButton getBotaoBuscar() {
        return botaoBuscar;
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

    public JTextField getTextoBuscar() {
        return textoBuscar;
    }

    public void setTextoBuscar(JTextField textoBuscar) {
        this.textoBuscar = textoBuscar;
    }

    public JTable getTabela() {
        return tabela;
    }

}
