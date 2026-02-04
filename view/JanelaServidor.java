package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.border.EmptyBorder;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JanelaServidor extends JFrame {

    private JLabel labelId, labelMatricula, labelNome, labelEmail, labelSetor, labelBusca, labelErroFormulario, labelErroBusca;
    private JTextField textoId, textoMatricula, textoNome, textoEmail, textoSetor, textoBusca;
    private JButton botaoCreate, botaoUpdate, botaoDelete, botaoLimpar, botaoBuscar;
    private DefaultTableModel tabelaModel;
    private JTable tabela;
    private JPanel painelId, painelMatricula, painelNome, painelEmail, painelSetor, painelErro, painelBotoes, painelEsquerdo, painelBusca, painelDireito;
    private JScrollPane painelScrollTabela;

    public JanelaServidor(){
        super("Gerenciador de Servidores");
        setSize(900,420);
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
        labelSetor = new JLabel("Setor: ");
        labelBusca = new JLabel("Digite matrícula:");
        labelErroFormulario = new JLabel("");
        labelErroBusca = new JLabel("");

        labelErroFormulario.setForeground(Color.RED);
        labelErroBusca.setForeground(Color.RED);

        labelId.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelMatricula.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelNome.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelEmail.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelSetor.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelBusca.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelErroFormulario.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelErroBusca.setAlignmentX(Component.CENTER_ALIGNMENT);

        labelErroFormulario.setVisible(false);
        labelErroBusca.setVisible(false);
    }

    private void criarTextos(){
        textoId = new JTextField("");
        textoId.setEnabled(false);
        textoMatricula = new JTextField("");
        textoNome = new JTextField("");
        textoEmail = new JTextField("");
        textoSetor = new JTextField("");
        textoBusca = new JTextField("");

        textoId.setAlignmentX(Component.CENTER_ALIGNMENT);
        textoMatricula.setAlignmentX(Component.CENTER_ALIGNMENT);
        textoNome.setAlignmentX(Component.CENTER_ALIGNMENT);
        textoEmail.setAlignmentX(Component.CENTER_ALIGNMENT);
        textoSetor.setAlignmentX(Component.CENTER_ALIGNMENT);
        textoBusca.setAlignmentX(Component.CENTER_ALIGNMENT);
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
        String [] colunas = {"Identificador", "Matrícula", "Nome", "Email", "Setor"};
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
        criarPainelSetor();
        criaPainelErroFormulario();
        criarPainelBotoes();
        criarPainelEsquerdo();
        criarPainelScrollTabela();
        criarPainelBusca();
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

    private void criarPainelSetor(){
        painelSetor = new JPanel();
        painelSetor.setLayout(new BoxLayout(painelSetor, BoxLayout.Y_AXIS));
        painelSetor.add(labelSetor);
        painelSetor.add(textoSetor);
    }

    private void criaPainelErroFormulario(){
        painelErro = new JPanel();
        painelErro.setLayout(new BoxLayout(painelErro, BoxLayout.Y_AXIS));
        painelErro.add(labelErroFormulario);
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
        painelEsquerdo.add(painelId);
        painelEsquerdo.add(Box.createRigidArea(new Dimension(0, 15)));
        painelEsquerdo.add(painelMatricula);
        painelEsquerdo.add(Box.createRigidArea(new Dimension(0, 15)));
        painelEsquerdo.add(painelNome);
        painelEsquerdo.add(Box.createRigidArea(new Dimension(0, 15)));
        painelEsquerdo.add(painelEmail);
        painelEsquerdo.add(Box.createRigidArea(new Dimension(0, 15)));
        painelEsquerdo.add(painelSetor);
        painelEsquerdo.add(Box.createRigidArea(new Dimension(0, 15)));
        painelEsquerdo.add(painelErro);
        painelEsquerdo.add(Box.createRigidArea(new Dimension(0, 15)));
        painelEsquerdo.add(painelBotoes);
        painelEsquerdo.setBorder(new EmptyBorder(15,15,15,15));
    }

    private void criarPainelScrollTabela(){
        painelScrollTabela = new JScrollPane(tabela);
    }

    private void criarPainelBusca(){
        painelBusca = new JPanel();
        painelBusca.setLayout(new BoxLayout(painelBusca, BoxLayout.X_AXIS));
        painelBusca.add(labelBusca);
        painelBusca.add(Box.createRigidArea(new Dimension(10, 0)));
        painelBusca.add(textoBusca);
        painelBusca.add(Box.createRigidArea(new Dimension(10, 0)));
        painelBusca.add(botaoBuscar);
        painelBusca.add(Box.createRigidArea(new Dimension(10, 0)));
        painelBusca.add(labelErroBusca);
    }

    private void criarPainelDireito(){
        painelDireito = new JPanel();
        painelDireito.setLayout(new BoxLayout(painelDireito, BoxLayout.PAGE_AXIS));
        painelDireito.add(painelScrollTabela);
        painelDireito.add(Box.createRigidArea(new Dimension(0, 15)));
        painelDireito.add(painelBusca);
        painelDireito.setBorder(new EmptyBorder(15,0,15,15));
    }

    public JTable getTabela() {
        return tabela;
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

    public String[] getDadosFormulario(){
        return new String[]{
            textoId.getText(),
            textoMatricula.getText(),
            textoNome.getText(),
            textoEmail.getText(),
            textoSetor.getText()
        };
    }

    public void setDadosFormulario(){
        int linha = tabela.getSelectedRow();
        if(linha >= 0){
            textoId.setText(tabela.getValueAt(linha, 0).toString());
            textoMatricula.setText(tabela.getValueAt(linha, 1).toString());
            textoNome.setText(tabela.getValueAt(linha, 2).toString());
            textoEmail.setText(tabela.getValueAt(linha, 3).toString());
            textoSetor.setText(tabela.getValueAt(linha, 4).toString());
        }
    }

    public void limparCamposFormulario(){
        textoId.setText("");
        textoMatricula.setText("");
        textoNome.setText("");
        textoEmail.setText("");
        textoSetor.setText("");
    }

    public void mostrarErroFormulario(String erro){
        labelErroFormulario.setText(erro);
        labelErroFormulario.setVisible(true);
    }

    public void ocultarErroFormulario(){
        labelErroFormulario.setVisible(false);
    }

    public String getDadoBusca(){
        return textoBusca.getText();
    }

    public void limparCampoBusca(){
        textoBusca.setText("");
    }

    public void mostrarErroBusca(String erro){
        labelErroBusca.setText(erro);
        labelErroBusca.setVisible(true);
    }

    public void ocultarErroBusca(){
        labelErroBusca.setVisible(false);
    }

    public int getQuantLinhasTabela(){
        return tabela.getRowCount();
    }

    public String getMatriculaLinhaTabela(int linha){
        return tabela.getValueAt(linha, 1).toString();
    }

    public void selecionarLinhaTabela(int linha){
        tabela.setRowSelectionInterval(linha, linha);
    }

    public void atualizarTabela(Object [][] dados){
        tabelaModel.setRowCount(0);
        for(int i=0; i<dados.length; i++){
            tabelaModel.addRow(dados[i]);
        }
        tabela.setModel(tabelaModel);
    }

    public static void main(String[] args) {
        new JanelaServidor();
    }

}
