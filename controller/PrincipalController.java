package controller;

import view.JanelaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PrincipalController {

    private JanelaPrincipal janelaPrincipal;

    public PrincipalController() {
        this.janelaPrincipal = new JanelaPrincipal();
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
        new AlunoController();
    }

    public void criarGerenciadorProfessores(){
        new ProfessorController();
    }

    public void criarGerenciadorServidores(){
        new ServidorController();
    }
    
}
