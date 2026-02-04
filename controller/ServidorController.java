package controller;

import model.Servidor;
import repository.ServidorRepository;
import validator.ServidorValidator;
import validator.ResultadoValidacao;
import view.JanelaServidor;

import java.util.ArrayList;

public class ServidorController{

    private ServidorRepository alunoRepository;
    private JanelaServidor janelaServidor;
    private ArrayList<Servidor> servidores;

    public ServidorController() {
        this.alunoRepository = new ServidorRepository();
        this.janelaServidor = new JanelaServidor();
        this.servidores = new ArrayList<>();
    }

}