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
                    salvarAluno();
                    limparCamposDeTexto();
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
                    buscarLinhaNaTabela();
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

    private void buscarLinhaNaTabela(){
        String matriculaBuscada = janelaAluno.getTextoBuscar().getText();

        boolean encontrou = false;
        int quantLinhas = janelaAluno.getTabela().getRowCount();
        for(int i=0; i<quantLinhas; i++){
            String matriculaLinha = janelaAluno.getTabela().getValueAt(i, 1).toString();
            if(matriculaLinha.equals(matriculaBuscada)){
                janelaAluno.getTabela().setRowSelectionInterval(i, i);
                encontrou = true;
                break;
            }
        }

        if(!encontrou){
            janelaAluno.getLabelErroBuscar().setVisible(true);
        }else{
            janelaAluno.getLabelErroBuscar().setVisible(false);
        }

    }

    private void salvarAluno(){
        int matricula = Integer.parseInt(janelaAluno.getTextoMatricula().getText());
        String nome = janelaAluno.getTextoNome().getText();
        String email = janelaAluno.getTextoEmail().getText();
        alunoRepository.create(new Aluno(0, matricula, nome, email));
        definirDadosDaTabela();
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
    }

    public static void main(String[] args) {
        AlunoRepository alunoRepository = new AlunoRepository();
        JanelaAluno janelaAluno = new JanelaAluno();
        AlunoController alunoController = new AlunoController(alunoRepository, janelaAluno);
    }

}