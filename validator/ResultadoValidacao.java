package validator;

public class ResultadoValidacao {

    private boolean temErro;
    private String mensagem;
    
    public ResultadoValidacao(boolean temErro, String mensagem) {
        this.temErro = temErro;
        this.mensagem = mensagem;
    }

    public boolean isTemErro() {
        return temErro;
    }
    
    public String getMensagem() {
        return mensagem;
    }
    
}
