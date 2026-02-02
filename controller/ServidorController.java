package controller;

import repository.ServidorRepository;
import view.JanelaServidor;

public class ServidorController {

    private ServidorRepository servidorRepository;
    private JanelaServidor janelaServidor;

    public ServidorController() {
        this.servidorRepository = new ServidorRepository();
        this.janelaServidor = new JanelaServidor();
    }
    
}
