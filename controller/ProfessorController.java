package controller;

import model.Professor;
import repository.ProfessorRepository;
import validator.ProfessorValidator;
import validator.ResultadoValidacao;
import view.JanelaProfessor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.ArrayList;

public class ProfessorController{

    private ProfessorRepository professorRepository;
    private JanelaProfessor janelaProfessor;
    private ArrayList<Professor> professores;

    public ProfessorController() {
        this.professorRepository = new ProfessorRepository();
        this.janelaProfessor = new JanelaProfessor();
        this.professores = new ArrayList<>();
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
        janelaProfessor.getTabela().addMouseListener(
            new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent evento){
                    if(evento.getClickCount() == 1){
                        janelaProfessor.setDadosFormulario();
                    }
                }
            }
        );
    }

    private void definirListenerBotaoCreate(){
        janelaProfessor.getBotaoCreate().addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent evento){
                    String[] dados = janelaProfessor.getDadosFormulario();
                    ResultadoValidacao resultadoValidacao = ProfessorValidator.verificarErrosFormulario(dados, professores, true);
                    if(!resultadoValidacao.isTemErro()){
                        salvarProfessor(dados);
                        atualizarTabela();
                        janelaProfessor.limparCamposFormulario();
                    }else{
                        janelaProfessor.mostrarErroFormulario(resultadoValidacao.getMensagem());
                    }
                }
            }
        );
    }

    private void definirListenerBotaoUpdate(){
        janelaProfessor.getBotaoUpdate().addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent evento){
                    String[] dados = janelaProfessor.getDadosFormulario();
                    ResultadoValidacao resultadoValidacao = ProfessorValidator.verificarErrosFormulario(dados, professores, false);
                    if(!resultadoValidacao.isTemErro()){
                        atualizarProfessor(dados);
                        atualizarTabela();
                        janelaProfessor.limparCamposFormulario();
                    }else{
                        janelaProfessor.mostrarErroFormulario(resultadoValidacao.getMensagem());
                    }
                }
            }
        );
    }

    private void definirListenerBotaoDelete(){
        janelaProfessor.getBotaoDelete().addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent evento){
                    String[] dados = janelaProfessor.getDadosFormulario();
                    ResultadoValidacao resultadoValidacao = ProfessorValidator.verificarErrosFormulario(dados, professores, false);
                    if(!resultadoValidacao.isTemErro()){
                        deletarProfessor(dados);
                        atualizarTabela();
                        janelaProfessor.limparCamposFormulario();
                    }else{
                        janelaProfessor.mostrarErroFormulario(resultadoValidacao.getMensagem());
                    }
                }
            }
        );
    }

    private void definirListenerBotaoLimpar(){
        janelaProfessor.getBotaoLimpar().addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent evento){
                    janelaProfessor.limparCamposFormulario();
                    janelaProfessor.ocultarErroFormulario();
                }
            }
        );
    }

    private void definirListenerBotaoBuscar(){
        janelaProfessor.getBotaoBuscar().addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent evento){
                    String dado = janelaProfessor.getDadoBusca();
                    int linha = procurarLinhaTabela();
                    ResultadoValidacao resultadoValidacao = ProfessorValidator.verificarErrosBusca(dado, linha);
                    if(!resultadoValidacao.isTemErro()){
                        janelaProfessor.selecionarLinhaTabela(linha);
                    }else{
                        janelaProfessor.mostrarErroBusca(resultadoValidacao.getMensagem());
                    }
                }
            }
        );
    }

    private void atualizarTabela(){
        this.professores.clear();
        this.professores = this.professorRepository.getTodos();

        Object [][] dados = new Object[professores.size()][6];
        for(int i=0; i<dados.length; i++){
            dados[i][0] = professores.get(i).getId();
            dados[i][1] = professores.get(i).getMatricula();
            dados[i][2] = professores.get(i).getNome();
            dados[i][3] = professores.get(i).getEmail();
            dados[i][4] = professores.get(i).getFormacao();
            if(professores.get(i).getStatus() == 1){
                dados[i][5] = "Ativo";
            }else{
                dados[i][5] = "Inativo";
            }
        }

        janelaProfessor.atualizarTabela(dados);
    }

    private void salvarProfessor(String[] dados){ 
        int matricula = Integer.parseInt(dados[1]);
        String nome = dados[2];
        String email = dados[3];
        String formacao = dados[4];
        int status = 0;
        if(dados[5].equals("Ativo") || dados[5].equals("ativo")){
            status = 1;
        }else{
            status = 0;
        }
        professorRepository.create(new Professor(0, matricula, nome, email, formacao, status));
    }

    private void atualizarProfessor(String[] dados){
        int id = Integer.parseInt(dados[0]);
        int matricula = Integer.parseInt(dados[1]);
        String nome = dados[2];
        String email = dados[3];
        String formacao = dados[4];
        int status = 0;
        if(dados[5].equals("Ativo") || dados[5].equals("ativo")){
            status = 1;
        }else{
            status = 0;
        }
        Professor professor = new Professor(id, matricula, nome, email, formacao, status);
        professorRepository.update(professor);
    }

    private void deletarProfessor(String[] dados){
        int id = Integer.parseInt(dados[0]);
        professorRepository.delete(id);
    }

    private Integer procurarLinhaTabela(){
        String matriculaBuscada = janelaProfessor.getDadoBusca();

        int linha = -1;
        int quantLinhas = janelaProfessor.getQuantLinhasTabela();
        for(int i=0; i<quantLinhas; i++){
            String matriculaLinha = janelaProfessor.getMatriculaLinhaTabela(i);
            if(matriculaLinha.equals(matriculaBuscada)){
                linha = i;
                break;
            }
        }

        return linha;
    }
    
    public static void main(String[] args) {
        ProfessorController professorController = new ProfessorController();
    }

}
