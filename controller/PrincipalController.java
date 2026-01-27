package controller;

import view.JanelaAluno;
import view.JanelaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import repository.AlunoRepository;

public class PrincipalController {

    private JanelaPrincipal janelaPrincipal;

    public PrincipalController(JanelaPrincipal janelaPrincipal) {
        this.janelaPrincipal = janelaPrincipal;
        definirListeners();
    }

    public void definirListeners(){

        janelaPrincipal.getBotaoAluno().addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent evento){
                    criarGerenciadorAluno();
                }
            }
        );

    }

    public void criarGerenciadorAluno(){
        AlunoRepository alunoRepository = new AlunoRepository();
        JanelaAluno janelaAluno = new JanelaAluno();
        AlunoController alunoController = new AlunoController(alunoRepository, janelaAluno);
    }

    public static void main(String[] args) {
        JanelaPrincipal janelaPrincipal = new JanelaPrincipal();
        PrincipalController principalController = new PrincipalController(janelaPrincipal);
    }
    
}
