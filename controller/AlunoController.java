package controller;

import repository.AlunoRepository;
import view.JanelaAluno;
import model.Aluno;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AlunoController{

    private AlunoRepository alunoRepository;
    private JanelaAluno janelaAluno;

    public AlunoController(AlunoRepository alunoRepository, JanelaAluno janelaAluno) {
        this.alunoRepository = alunoRepository;
        this.janelaAluno = janelaAluno;
        definirListeners();
    }

    public void definirListeners(){

        janelaAluno.getTabela().addMouseListener(
            new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent evento){
                    if(evento.getClickCount() == 1){
                        pegarDadosDaLinhaDaTabela();
                    }
                }
            }
        );

        janelaAluno.getBotaoCreate().addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent evento){
                    salvarAluno();
                }
            }
        );

        //atualizar

        //deletar

    }

    public void salvarAluno(){
        int matricula = Integer.parseInt(janelaAluno.getTextoMatricula().getText());
        String nome = janelaAluno.getTextoNome().getText();
        String email = janelaAluno.getTextoEmail().getText();
        alunoRepository.create(new Aluno(0, matricula, nome, email));
    }

    public void pegarDadosDaLinhaDaTabela(){
        int linha = janelaAluno.getTabela().getSelectedRow();
        if(linha >= 0){
            String matricula = janelaAluno.getTabela().getValueAt(linha, 0).toString();
            String nome = janelaAluno.getTabela().getValueAt(linha, 1).toString();
            String email = janelaAluno.getTabela().getValueAt(linha,2).toString();
            janelaAluno.getTextoMatricula().setText(matricula);
            janelaAluno.getTextoNome().setText(nome);
            janelaAluno.getTextoEmail().setText(email);
        }
    }

}