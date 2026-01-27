package controller;

import repository.AlunoRepository;
import view.JanelaAluno;
import model.Aluno;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlunoController{

    private AlunoRepository alunoRepository;
    private JanelaAluno janelaAluno;

    public AlunoController(AlunoRepository alunoRepository, JanelaAluno janelaAluno) {
        this.alunoRepository = alunoRepository;
        this.janelaAluno = janelaAluno;
        definirListeners();
    }

    public void definirListeners(){

        janelaAluno.getBotaoCreate().addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent evento){
                    salvarAluno();
                }
            }
        );

    }

    public void salvarAluno(){
        int matricula = Integer.parseInt(janelaAluno.getTextoMatricula().getText());
        String nome = janelaAluno.getTextoNome().getText();
        String email = janelaAluno.getTextoEmail().getText();
        alunoRepository.create(new Aluno(0, matricula, nome, email));
    }

}