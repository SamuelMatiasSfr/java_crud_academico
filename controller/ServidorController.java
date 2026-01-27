package controller;

import repository.ServidorRepository;
import view.JanelaServidor;

public class ServidorController {

    private ServidorRepository servidorRepository;
    private JanelaServidor janelaServidor;

    public ServidorController(ServidorRepository servidorRepository, JanelaServidor janelaServidor) {
        this.servidorRepository = servidorRepository;
        this.janelaServidor = janelaServidor;
    }
    
}
