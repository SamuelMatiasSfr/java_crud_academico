package controller;

import view.JanelaAluno;
import view.JanelaPrincipal;
import view.JanelaProfessor;
import view.JanelaServidor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import repository.AlunoRepository;
import repository.ProfessorRepository;
import repository.ServidorRepository;

public class PrincipalController {

    private JanelaPrincipal janelaPrincipal;

    public PrincipalController(JanelaPrincipal janelaPrincipal) {
        this.janelaPrincipal = janelaPrincipal;
        definirListeners();
    }

    public void definirListeners(){

        janelaPrincipal.getBotao().addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent evento){
                    String itemSelecionado = janelaPrincipal.getItemSelecionadao();
                    mostrarGerenciador(itemSelecionado);
                }
            }
        );

    }

    public void mostrarGerenciador(String itemSelecionado){
        if(itemSelecionado.equals("Gerenciador de Alunos")){
            criarGerenciadorAlunos();
        }else if(itemSelecionado.equals("Gerenciador de Professores")){
            criarGerenciadorProfessores();
        }else{
            criarGerenciadorServidores();
        }
    }

    public void criarGerenciadorAlunos(){
        AlunoRepository alunoRepository = new AlunoRepository();
        JanelaAluno janelaAluno = new JanelaAluno();
        AlunoController alunoController = new AlunoController(alunoRepository, janelaAluno);
    }

    public void criarGerenciadorProfessores(){
        ProfessorRepository professorRepository = new ProfessorRepository();
        JanelaProfessor janelaProfessor = new JanelaProfessor();
        ProfessorController professorController = new ProfessorController(professorRepository, janelaProfessor);
    }

    public void criarGerenciadorServidores(){
        ServidorRepository servidorRepository = new ServidorRepository();
        JanelaServidor janelaServidor = new JanelaServidor();
        ServidorController servidorController = new ServidorController(servidorRepository, janelaServidor);
    }

    public static void main(String[] args) {
        JanelaPrincipal janelaPrincipal = new JanelaPrincipal();
        PrincipalController principalController = new PrincipalController(janelaPrincipal);
    }
    
}
