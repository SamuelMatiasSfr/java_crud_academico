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
        atualizarTabela();
    }

    private void atualizarTabela(){
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
                        janelaAluno.setDadosFormulario();
                    }
                }
            }
        );

        janelaAluno.getBotaoCreate().addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent evento){
                    if(!verificarErrosFormulario()){
                        salvarAluno();
                        atualizarTabela();
                        janelaAluno.limparCamposFormulario();
                    }
                }
            }
        );

        janelaAluno.getBotaoUpdate().addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent evento){
                    if(!verificarErrosFormulario()){
                        atualizarAluno();
                        atualizarTabela();
                        janelaAluno.limparCamposFormulario();
                    }
                }
            }
        );

        janelaAluno.getBotaoDelete().addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent evento){
                    deletarAluno();
                    atualizarTabela();
                    janelaAluno.limparCamposFormulario();
                }
            }
        );

        janelaAluno.getBotaoLimpar().addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent evento){
                    janelaAluno.limparCamposFormulario();
                    janelaAluno.ocultarErroFormulario();
                }
            }
        );

        janelaAluno.getBotaoBuscar().addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent evento){
                    if(!verificarErrosBusca()){
                        int linha = procurarLinhaTabela();
                        janelaAluno.selecionarLinhaTabela(linha);
                    }
                }
            }
        );

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

    private void salvarAluno(){
        String[] dados = janelaAluno.getDadosFormulario(); 
        int matricula = Integer.parseInt(dados[1]);
        String nome = dados[2];
        String email = dados[3];
        alunoRepository.create(new Aluno(0, matricula, nome, email));
    }

    private void atualizarAluno(){
        String[] dados = janelaAluno.getDadosFormulario(); 
        int id = Integer.parseInt(dados[0]);
        int matricula = Integer.parseInt(dados[1]);
        String nome = dados[2];
        String email = dados[3];
        Aluno aluno = new Aluno(id, matricula, nome, email);
        alunoRepository.update(aluno);
    }

    private void deletarAluno(){
        String[] dados = janelaAluno.getDadosFormulario();
        int id = Integer.parseInt(dados[0]);
        alunoRepository.delete(id);
    }

    private Boolean verificarErrosFormulario(){
        boolean temErro = false;
        boolean temErroRegex = false;

        String[] dados = janelaAluno.getDadosFormulario();

        if(
            dados[1].equals("") ||
            dados[2].equals("") ||
            dados[3].equals("")
        ){
            janelaAluno.mostrarErroFormulario("Preencha todos os campos obrigatórios.");
            temErro = true;
        }

        if (
            !temErroRegex &&
            !dados[1].equals("") &&
            !dados[1].matches("\\d+")
        ) {
            janelaAluno.mostrarErroFormulario("Matrícula inválida.");
            temErro = true;
            temErroRegex = true;
        }
        
        if (
            !temErroRegex &&
            !dados[2].equals("") &&
            !dados[2].matches("[a-zA-ZÀ-ÿ ]+")
        ) {
            janelaAluno.mostrarErroFormulario("Nome inválido.");
            temErro = true;
            temErroRegex = true;
        }

        if (
            !temErroRegex &&
            !dados[3].equals("") &&
            !dados[3].matches("[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}")
        ) {
            janelaAluno.mostrarErroFormulario("Email inválido.");
            temErro = true;
            temErroRegex = true;
        }

        if(
            /* 
            Essa verificação do campo ID vai delimitar a função somente para quando o usuário clicar em create.
            Dessa forma, ao apertar em update, esse erro não será acionado.
            */
            dados[0].equals("") &&
            !dados[1].equals("") &&
            dados[1].matches("\\d+") &&
            alunoRepository.readPorMatricula(Integer.parseInt(dados[1]))
        ){
            janelaAluno.mostrarErroFormulario("Já existe um aluno cadastrado com esta matrícula.");
            temErro = true;
        }

        if(
            /* 
            Essa verificação do campo ID vai delimitar a função somente para quando o usuário clicar em update.
            Dessa forma, ao apertar em create, esse erro não será acionado.
            */
            !dados[0].equals("") &&
            !dados[1].equals("") &&
            dados[1].matches("\\d+")
        ){
            int idCampo = Integer.parseInt(dados[0]);
            int matriculaCampo = Integer.parseInt(dados[1]);
            for(int i=0; i<alunos.size(); i++){
                int idLoop = alunos.get(i).getId();
                int matriculaLoop = alunos.get(i).getMatricula();
                if((idCampo != idLoop) && (matriculaCampo == matriculaLoop)){
                    janelaAluno.mostrarErroFormulario("Já existe outro aluno cadastrado com esta matrícula.");
                    temErro = true;
                }
            }
        }

        if(!temErro){
            janelaAluno.ocultarErroFormulario();
        }

        return temErro;
    }

    private Boolean verificarErrosBusca(){
        boolean temErro = false;

        String matriculaBuscada = janelaAluno.getDadoBusca();

        if(matriculaBuscada.equals("")){
            janelaAluno.mostrarErroBusca("Preencha o campo.");
            temErro = true;
        }

        if (
            !matriculaBuscada.equals("") &&
            !matriculaBuscada.matches("\\d+")
        ) {
            janelaAluno.mostrarErroBusca("Matrícula inválida.");
            temErro = true;
        }

        if(
            !matriculaBuscada.equals("") &&
            matriculaBuscada.matches("\\d+")
        ){
            int linha = procurarLinhaTabela();
            if(linha == -1){
                janelaAluno.mostrarErroBusca("Registro não encontrado.");
                temErro = true;
            }
        }

        if(!temErro){
            janelaAluno.ocultarErroBusca();
        }

        return temErro;
    }

    public static void main(String[] args) {
        AlunoRepository alunoRepository = new AlunoRepository();
        JanelaAluno janelaAluno = new JanelaAluno();
        AlunoController alunoController = new AlunoController(alunoRepository, janelaAluno);
    }

}