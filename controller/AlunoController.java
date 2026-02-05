package controller;

import model.Aluno;
import repository.AlunoRepository;
import validator.AlunoValidator;
import validator.ResultadoValidacao;
import view.JanelaAluno;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.ArrayList;

public class AlunoController{

    private AlunoRepository alunoRepository;
    private JanelaAluno janelaAluno;
    private ArrayList<Aluno> alunos;

    public AlunoController() {
        this.alunoRepository = new AlunoRepository();
        this.janelaAluno = new JanelaAluno();
        this.alunos = new ArrayList<>();
        definirListeners();
        atualizarTabela();
    }

    private void definirListeners(){
        definirListenerTabela();
        definirListenerBotaoCreate();
        definirListenerBotaoUpdate();
        definirListenerBotaoDelete();
        definirListenerBotaoLimpar();
        definirListenerBotaoBuscar();
    }

    private void definirListenerTabela(){
        janelaAluno.getTabela().addMouseListener(
            new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent evento){
                    if(evento.getClickCount() == 1){
                        janelaAluno.setDadosFormulario();
                    }
                }
            }
        );
    }

    private void definirListenerBotaoCreate(){
        janelaAluno.getBotaoCreate().addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent evento){
                    String[] dados = janelaAluno.getDadosFormulario();
                    ResultadoValidacao resultadoValidacao = AlunoValidator.verificarErrosFormulario(dados, alunos, true);
                    if(!resultadoValidacao.isTemErro()){
                        salvarAluno(dados);
                        atualizarTabela();
                        janelaAluno.limparCamposFormulario();
                    }else{
                        janelaAluno.mostrarErroFormulario(resultadoValidacao.getMensagem());
                    }
                }
            }
        );
    }

    private void definirListenerBotaoUpdate(){
        janelaAluno.getBotaoUpdate().addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent evento){
                    String[] dados = janelaAluno.getDadosFormulario();
                    ResultadoValidacao resultadoValidacao = AlunoValidator.verificarErrosFormulario(dados, alunos, false);
                    if(!resultadoValidacao.isTemErro()){
                        atualizarAluno(dados);
                        atualizarTabela();
                        janelaAluno.limparCamposFormulario();
                    }else{
                        janelaAluno.mostrarErroFormulario(resultadoValidacao.getMensagem());
                    }
                }
            }
        );
    }

    private void definirListenerBotaoDelete(){
        janelaAluno.getBotaoDelete().addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent evento){
                    String[] dados = janelaAluno.getDadosFormulario();
                    ResultadoValidacao resultadoValidacao = AlunoValidator.verificarErrosFormulario(dados, alunos, false);
                    if(!resultadoValidacao.isTemErro()){
                        deletarAluno(dados);
                        atualizarTabela();
                        janelaAluno.limparCamposFormulario();
                    }else{
                        janelaAluno.mostrarErroFormulario(resultadoValidacao.getMensagem());
                    }
                }
            }
        );
    }

    private void definirListenerBotaoLimpar(){
        janelaAluno.getBotaoLimpar().addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent evento){
                    janelaAluno.limparCamposFormulario();
                    janelaAluno.ocultarErroFormulario();
                }
            }
        );
    }

    private void definirListenerBotaoBuscar(){
        janelaAluno.getBotaoBuscar().addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent evento){
                    String dado = janelaAluno.getDadoBusca();
                    int linha = procurarLinhaTabela();
                    ResultadoValidacao resultadoValidacao = AlunoValidator.verificarErrosBusca(dado, linha);
                    if(!resultadoValidacao.isTemErro()){
                        janelaAluno.selecionarLinhaTabela(linha);
                    }else{
                        janelaAluno.mostrarErroBusca(resultadoValidacao.getMensagem());
                    }
                }
            }
        );
    }

    private void atualizarTabela(){
        alunos.clear();
        alunos = alunoRepository.getTodos();

        Object [][] dados = new Object[alunos.size()][4];
        for(int i=0; i<dados.length; i++){
            dados[i][0] = alunos.get(i).getId();
            dados[i][1] = alunos.get(i).getMatricula();
            dados[i][2] = alunos.get(i).getNome();
            dados[i][3] = alunos.get(i).getEmail();
        }

        janelaAluno.atualizarTabela(dados);
    }

    private void salvarAluno(String[] dados){ 
        int matricula = Integer.parseInt(dados[1]);
        String nome = dados[2];
        String email = dados[3];
        alunoRepository.create(new Aluno(0, matricula, nome, email));
    }

    private void atualizarAluno(String[] dados){
        int id = Integer.parseInt(dados[0]);
        int matricula = Integer.parseInt(dados[1]);
        String nome = dados[2];
        String email = dados[3];
        Aluno aluno = new Aluno(id, matricula, nome, email);
        alunoRepository.update(aluno);
    }

    private void deletarAluno(String[] dados){
        int id = Integer.parseInt(dados[0]);
        alunoRepository.delete(id);
    }

    private Integer procurarLinhaTabela(){
        String matriculaBuscada = janelaAluno.getDadoBusca();

        int linha = -1;
        int quantLinhas = janelaAluno.getQuantLinhasTabela();
        for(int i=0; i<quantLinhas; i++){
            String matriculaLinha = janelaAluno.getMatriculaLinhaTabela(i);
            if(matriculaLinha.equals(matriculaBuscada)){
                linha = i;
                break;
            }
        }

        return linha;
    }
    
    public static void main(String[] args) {
        AlunoController alunoController = new AlunoController();
    }

}