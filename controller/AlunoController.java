package controller;

import repository.AlunoRepository;
import view.JanelaAluno;
import model.Aluno;

import java.util.ArrayList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AlunoController{

    private AlunoRepository alunoRepository;
    private JanelaAluno janelaAluno;
    private ArrayList<Aluno> alunos;

    public AlunoController(AlunoRepository alunoRepository, JanelaAluno janelaAluno) {
        this.alunoRepository = alunoRepository;
        this.janelaAluno = janelaAluno;
        this.alunos = new ArrayList<>();
        definirListeners();
        definirDadosDaTabela();
    }

    private void definirDadosDaTabela(){
        this.alunos.clear();
        this.alunos = this.alunoRepository.getTodos();

        Object [][] dados = new Object[alunos.size()][4];
        for(int i=0; i<dados.length; i++){
            dados[i][0] = alunos.get(i).getId();
            dados[i][1] = alunos.get(i).getMatricula();
            dados[i][2] = alunos.get(i).getNome();
            dados[i][3] = alunos.get(i).getEmail();
        }

        janelaAluno.definirTabela(dados);
    }

    private void definirListeners(){

        janelaAluno.getTabela().addMouseListener(
            new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent evento){
                    if(evento.getClickCount() == 1){
                        pegarDadosDaLinhaDaTabela();
                        janelaAluno.getBotaoLimpar().setVisible(true);
                    }
                }
            }
        );

        janelaAluno.getBotaoCreate().addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent evento){
                    if(!verificaErrosCrud()){
                        salvarAluno();
                        definirDadosDaTabela();
                        limparCamposDeTexto();
                    }
                }
            }
        );

        janelaAluno.getBotaoUpdate().addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent evento){
                    atualizarAluno();
                    limparCamposDeTexto();
                }
            }
        );

        janelaAluno.getBotaoDelete().addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent evento){
                    deletarAluno();
                    limparCamposDeTexto();
                }
            }
        );

        janelaAluno.getBotaoLimpar().addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent evento){
                    limparCamposDeTexto();
                }
            }
        );

        janelaAluno.getBotaoBuscar().addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent evento){
                    if(!verificaErrosBuscar()){
                        int linha = procurarLinhaNaTabela();
                        janelaAluno.getTabela().setRowSelectionInterval(linha, linha);
                    }
                }
            }
        );

    }

    private void pegarDadosDaLinhaDaTabela(){
        int linha = janelaAluno.getTabela().getSelectedRow();
        if(linha >= 0){
            String id = janelaAluno.getTabela().getValueAt(linha, 0).toString();
            String matricula = janelaAluno.getTabela().getValueAt(linha, 1).toString();
            String nome = janelaAluno.getTabela().getValueAt(linha, 2).toString();
            String email = janelaAluno.getTabela().getValueAt(linha,3).toString();
            janelaAluno.getTextoId().setText(id);
            janelaAluno.getTextoMatricula().setText(matricula);
            janelaAluno.getTextoNome().setText(nome);
            janelaAluno.getTextoEmail().setText(email);
        }
    }

    private Integer procurarLinhaNaTabela(){
        String matriculaBuscada = janelaAluno.getTextoBuscar().getText();

        int linha = -1;
        int quantLinhas = janelaAluno.getTabela().getRowCount();
        for(int i=0; i<quantLinhas; i++){
            String matriculaLinha = janelaAluno.getTabela().getValueAt(i, 1).toString();
            if(matriculaLinha.equals(matriculaBuscada)){
                linha = i;
                break;
            }
        }

        return linha;
    }

    private void salvarAluno(){
        int matricula = Integer.parseInt(janelaAluno.getTextoMatricula().getText());
        String nome = janelaAluno.getTextoNome().getText();
        String email = janelaAluno.getTextoEmail().getText();
        alunoRepository.create(new Aluno(0, matricula, nome, email));
    }

    private void atualizarAluno(){
        int id = Integer.parseInt(janelaAluno.getTextoId().getText());
        int matricula = Integer.parseInt(janelaAluno.getTextoMatricula().getText());        
        String nome = janelaAluno.getTextoNome().getText();
        String email = janelaAluno.getTextoEmail().getText();

        for(int i=0; i<alunos.size(); i++){
            if(id == alunos.get(i).getId()){
                Aluno aluno = alunoRepository.read(id);
                if(aluno != null){
                    aluno.setMatricula(matricula);
                    aluno.setNome(nome);
                    aluno.setEmail(email);
                    alunoRepository.update(aluno);
                    definirDadosDaTabela();
                }
            }
        }
    }

    private void deletarAluno(){
        int id = Integer.parseInt(janelaAluno.getTextoId().getText());
        for(int i=0; i<alunos.size(); i++){
            if(id == alunos.get(i).getId()){
                alunoRepository.delete(id);
                definirDadosDaTabela();
            }
        }
    }

    private void limparCamposDeTexto(){
        janelaAluno.getTextoId().setText("");
        janelaAluno.getTextoMatricula().setText("");
        janelaAluno.getTextoNome().setText("");
        janelaAluno.getTextoEmail().setText("");
        janelaAluno.getLabelErroCrud().setVisible(false);
    }

    private Boolean verificaErrosCrud(){
        boolean temErro = false;

        if(
            janelaAluno.getTextoMatricula().getText().equals("") ||
            janelaAluno.getTextoNome().getText().equals("") ||
            janelaAluno.getTextoEmail().getText().equals("")
        ){
            janelaAluno.getLabelErroCrud().setText("Preencha todos os campos obrigatórios.");
            temErro = true;
        }

        if (!janelaAluno.getTextoMatricula().getText().matches("\\d+")) {
            janelaAluno.getLabelErroCrud().setText("Matrícula inválida.");
            temErro = true;
        }
        
        if (!janelaAluno.getTextoNome().getText().matches("[a-zA-ZÀ-ÿ ]+")) {
            janelaAluno.getLabelErroCrud().setText("Nome inválido.");
            temErro = true;
        }

        if (!janelaAluno.getTextoEmail().getText().matches("[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}")) {
            janelaAluno.getLabelErroCrud().setText("Email inválido.");
            temErro = true;
        }

        if(
            /* 
            Essa verificação do campo ID vai delimitar a função somente para quando o usuário clicar em create.
            Dessa forma, ao apertar em update, esse erro não será acionado.
            */
            janelaAluno.getTextoId().getText().equals("") &&
            !janelaAluno.getTextoMatricula().getText().equals("") &&
            janelaAluno.getTextoMatricula().getText().matches("[0-9]+") &&
            alunoRepository.readPorMatricula(Integer.parseInt(janelaAluno.getTextoMatricula().getText()))
        ){
            janelaAluno.getLabelErroCrud().setText("Já existe um aluno cadastrado com esta matrícula.");
            temErro = true;
        }

        //erro ao atualizar

        if(temErro){
            janelaAluno.getLabelErroCrud().setVisible(true);
        }else{
            janelaAluno.getLabelErroCrud().setVisible(false);
        }

        return temErro;
    }

    private Boolean verificaErrosBuscar(){
        boolean temErro = false;

        if(janelaAluno.getTextoBuscar().getText().equals("")){
            janelaAluno.getLabelErroBuscar().setText("Preencha o campo.");
            temErro = true;
        }

        if (!janelaAluno.getTextoBuscar().getText().matches("\\d+")) {
            janelaAluno.getLabelErroBuscar().setText("Matrícula inválida.");
            temErro = true;
        }

        if(
            !janelaAluno.getTextoBuscar().getText().equals("") &&
            janelaAluno.getTextoBuscar().getText().matches("\\d+")
        ){
            int linha = procurarLinhaNaTabela();
            if(linha == -1){
                janelaAluno.getLabelErroBuscar().setText("Registro não encontrado.");
                temErro = true;
            }
        }

        if(temErro){
            janelaAluno.getLabelErroBuscar().setVisible(true);
        }else{
            janelaAluno.getLabelErroBuscar().setVisible(false);
        }

        return temErro;
    }

    public static void main(String[] args) {
        AlunoRepository alunoRepository = new AlunoRepository();
        JanelaAluno janelaAluno = new JanelaAluno();
        AlunoController alunoController = new AlunoController(alunoRepository, janelaAluno);
    }

}