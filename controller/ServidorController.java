package controller;

import model.Servidor;
import repository.ServidorRepository;
import validator.ServidorValidator;
import validator.ResultadoValidacao;
import view.JanelaServidor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.ArrayList;

public class ServidorController{

    private ServidorRepository servidorRepository;
    private JanelaServidor janelaServidor;
    private ArrayList<Servidor> servidores;

    public ServidorController() {
        this.servidorRepository = new ServidorRepository();
        this.janelaServidor = new JanelaServidor();
        this.servidores = new ArrayList<>();
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
        janelaServidor.getTabela().addMouseListener(
            new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent evento){
                    if(evento.getClickCount() == 1){
                        janelaServidor.setDadosFormulario();
                    }
                }
            }
        );
    }

    private void definirListenerBotaoCreate(){
        janelaServidor.getBotaoCreate().addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent evento){
                    String[] dados = janelaServidor.getDadosFormulario();
                    ResultadoValidacao resultadoValidacao = ServidorValidator.verificarErrosFormulario(dados, servidores, true);
                    if(!resultadoValidacao.isTemErro()){
                        salvarServidor(dados);
                        atualizarTabela();
                        janelaServidor.limparCamposFormulario();
                        janelaServidor.ocultarErroFormulario();
                    }else{
                        janelaServidor.mostrarErroFormulario(resultadoValidacao.getMensagem());
                    }
                }
            }
        );
    }

    private void definirListenerBotaoUpdate(){
        janelaServidor.getBotaoUpdate().addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent evento){
                    String[] dados = janelaServidor.getDadosFormulario();
                    ResultadoValidacao resultadoValidacao = ServidorValidator.verificarErrosFormulario(dados, servidores, false);
                    if(!resultadoValidacao.isTemErro()){
                        atualizarServidor(dados);
                        atualizarTabela();
                        janelaServidor.limparCamposFormulario();
                        janelaServidor.ocultarErroFormulario();
                    }else{
                        janelaServidor.mostrarErroFormulario(resultadoValidacao.getMensagem());
                    }
                }
            }
        );
    }

    private void definirListenerBotaoDelete(){
        janelaServidor.getBotaoDelete().addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent evento){
                    String[] dados = janelaServidor.getDadosFormulario();
                    ResultadoValidacao resultadoValidacao = ServidorValidator.verificarErrosFormulario(dados, servidores, false);
                    if(!resultadoValidacao.isTemErro()){
                        deletarServidor(dados);
                        atualizarTabela();
                        janelaServidor.limparCamposFormulario();
                        janelaServidor.ocultarErroFormulario();
                    }else{
                        janelaServidor.mostrarErroFormulario(resultadoValidacao.getMensagem());
                    }
                }
            }
        );
    }

    private void definirListenerBotaoLimpar(){
        janelaServidor.getBotaoLimpar().addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent evento){
                    janelaServidor.limparCamposFormulario();
                    janelaServidor.ocultarErroFormulario();
                }
            }
        );
    }

    private void definirListenerBotaoBuscar(){
        janelaServidor.getBotaoBuscar().addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent evento){
                    String dado = janelaServidor.getDadoBusca();
                    int linha = procurarLinhaTabela();
                    ResultadoValidacao resultadoValidacao = ServidorValidator.verificarErrosBusca(dado, linha);
                    if(!resultadoValidacao.isTemErro()){
                        janelaServidor.selecionarLinhaTabela(linha);
                        janelaServidor.ocultarErroBusca();
                    }else{
                        janelaServidor.mostrarErroBusca(resultadoValidacao.getMensagem());
                    }
                }
            }
        );
    }

    private void atualizarTabela(){
        servidores.clear();
        servidores = servidorRepository.getTodos();

        Object [][] dados = new Object[servidores.size()][5];
        for(int i=0; i<dados.length; i++){
            dados[i][0] = servidores.get(i).getId();
            dados[i][1] = servidores.get(i).getMatricula();
            dados[i][2] = servidores.get(i).getNome();
            dados[i][3] = servidores.get(i).getEmail();
            dados[i][4] = servidores.get(i).getSetor();
        }

        janelaServidor.atualizarTabela(dados);
    }

    private void salvarServidor(String[] dados){ 
        int matricula = Integer.parseInt(dados[1]);
        String nome = dados[2];
        String email = dados[3];
        String setor = dados[4];
        servidorRepository.create(new Servidor(0, matricula, nome, email, setor));
    }

    private void atualizarServidor(String[] dados){
        int id = Integer.parseInt(dados[0]);
        int matricula = Integer.parseInt(dados[1]);
        String nome = dados[2];
        String email = dados[3];
        String setor = dados[4];
        Servidor servidor = new Servidor(id, matricula, nome, email, setor);
        servidorRepository.update(servidor);
    }

    private void deletarServidor(String[] dados){
        int id = Integer.parseInt(dados[0]);
        servidorRepository.delete(id);
    }

    private Integer procurarLinhaTabela(){
        String matriculaBuscada = janelaServidor.getDadoBusca();

        int linha = -1;
        int quantLinhas = janelaServidor.getQuantLinhasTabela();
        for(int i=0; i<quantLinhas; i++){
            String matriculaLinha = janelaServidor.getMatriculaLinhaTabela(i);
            if(matriculaLinha.equals(matriculaBuscada)){
                linha = i;
                break;
            }
        }

        return linha;
    }

}
