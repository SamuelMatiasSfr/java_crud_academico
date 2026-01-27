package controller;

import repository.AlunoRepository;
import view.JanelaAluno;

public class AlunoController{

    private AlunoRepository alunoRepository;
    private JanelaAluno janelaAluno;

    public AlunoController(AlunoRepository alunoRepository, JanelaAluno janelaAluno) {
        this.alunoRepository = alunoRepository;
        this.janelaAluno = janelaAluno;
    }
    
}