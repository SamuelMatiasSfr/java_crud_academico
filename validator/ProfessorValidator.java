package validator;

import model.Professor;

import java.util.ArrayList;

public class ProfessorValidator {

    private static boolean idPreenchido(String id){
        if(!id.equals("")){
           return true; 
        }else{
            return false;
        }
    }

    private static boolean matriculaPreenchido(String matricula){
        if(!matricula.equals("")){
           return true; 
        }else{
            return false;
        }
    }

    private static boolean nomePreenchido(String nome){
        if(!nome.equals("")){
           return true; 
        }else{
            return false;
        }
    }

    private static boolean emailPreenchido(String email){
        if(!email.equals("")){
           return true; 
        }else{
            return false;
        }
    }

    private static boolean formacaoPreenchido(String formacao){
        if(!formacao.equals("")){
           return true; 
        }else{
            return false;
        }
    }

    private static boolean statusPreenchido(String status){
        if(!status.equals("")){
           return true; 
        }else{
            return false;
        }
    }

    private static boolean matriculaValido(String matricula){
        if(matricula.matches("\\d+")){
           return true; 
        }else{
            return false;
        }
    }

    private static boolean nomeValido(String nome){
        if(nome.matches("[a-zA-ZÀ-ÿ ]+")){
           return true; 
        }else{
            return false;
        }
    }

    private static boolean emailValido(String email){
        if(email.matches("[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}")){
           return true; 
        }else{
            return false;
        }
    }

    private static boolean formacaoValido(String formacao){
        if(formacao.matches("[a-zA-ZÀ-ÿ ]+")){
           return true; 
        }else{
            return false;
        }
    }

    private static boolean statusValido(String status){
        if(status.matches("[a-zA-ZÀ-ÿ ]+")){
            if(
                status.equals("Ativo") ||
                status.equals("ativo") ||
                status.equals("Inativo") ||
                status.equals("inativo") 
            ){
                return true;
            } else{
                return false;
            }
        }else{
            return false;
        }
    }

    private static boolean existeAlunoComMatricula(String id, String matricula, boolean ehCreate, ArrayList<Professor> professores){
        boolean existe = false;

        int matriculaDigitado = Integer.parseInt(matricula);
        for(int i=0; i<professores.size(); i++){
            int matriculaLoop = professores.get(i).getMatricula();
            if(ehCreate){
                if(matriculaDigitado == matriculaLoop){
                    existe = true;
                    break;
                }
            }else{
                int idDigitado = Integer.parseInt(id);
                int idLoop = professores.get(i).getId();
                if((idDigitado != idLoop) && (matriculaDigitado == matriculaLoop)){
                    existe = true;
                    break;
                }
            }
        }

        return existe;
    }

    private static boolean existeAlunoComEmail(String id, String email, boolean ehCreate, ArrayList<Professor> professores){
        boolean existe = false;

        for(int i=0; i<professores.size(); i++){
            String emailLoop = professores.get(i).getEmail();
            if(ehCreate){
                if(email.equals(emailLoop)){
                    existe = true;
                    break;
                }
            }else{
                int idDigitado = Integer.parseInt(id);
                int idLoop = professores.get(i).getId();
                if((idDigitado != idLoop) && (email.equals(emailLoop))){
                    existe = true;
                    break;
                }
            }
        }

        return existe;
    }

    private static boolean naoExisteRegistro(int linha){
        if(linha == -1){
            return true;
        }else{
            return false;
        }
    }

    public static ResultadoValidacao verificarErrosFormulario(String[] dados, ArrayList<Professor> professores, boolean ehCreate){
        boolean temErro = false;
        String mensagem = "";

        if(
            emailPreenchido(dados[3]) &&
            emailValido(dados[3]) &&
            existeAlunoComEmail(dados[0], dados[3], ehCreate, professores)
        ){
            mensagem = "Já existe um professor cadastrado com este email.";
            temErro = true;
        }

        if(
            matriculaPreenchido(dados[1]) &&
            matriculaValido(dados[1]) &&
            existeAlunoComMatricula(dados[0], dados[1], ehCreate, professores)
        ){
            mensagem = "Já existe um professor cadastrado com esta matrícula.";
            temErro = true;
        }

        if (
            matriculaPreenchido(dados[1]) &&
            !matriculaValido(dados[1])
        ) {
            mensagem = "Matrícula inválida.";
            temErro = true;
        } else if (
            nomePreenchido(dados[2]) &&
            !nomeValido(dados[2])
        ) {
            mensagem = "Nome inválido.";
            temErro = true;
        } else if (
            emailPreenchido(dados[3]) &&
            !emailValido(dados[3])
        ) {
            mensagem = "Email inválido.";
            temErro = true;
        } else if (
            formacaoPreenchido(dados[4]) &&
            !formacaoValido(dados[4])
        ) {
            mensagem = "Formação inválida.";
            temErro = true;
        } else if (
            statusPreenchido(dados[5]) &&
            !statusValido(dados[5])
        ) {
            mensagem = "Status inválido.";
            temErro = true;
        }

        if(
            !matriculaPreenchido(dados[1]) ||
            !nomePreenchido(dados[2]) ||
            !emailPreenchido(dados[3]) ||
            !formacaoPreenchido(dados[4]) ||
            !statusPreenchido(dados[5])
        ){
            mensagem = "Preencha todos os campos obrigatórios.";
            temErro = true;
        }

        if(!idPreenchido(dados[0]) && !ehCreate){
            mensagem = "Selecione um professor para atualizar ou deletar.";
            temErro = true;
        }

        return new ResultadoValidacao(temErro, mensagem);
    }

    public static ResultadoValidacao verificarErrosBusca(String dado, int linha){
        boolean temErro = false;
        String mensagem = "";

        if(matriculaPreenchido(dado)){
            if(!matriculaValido(dado)){
                mensagem = "Matrícula inválida.";
                temErro = true;
            }
            if(matriculaValido(dado) && naoExisteRegistro(linha)){
                mensagem = "Registro não encontrado.";
                temErro = true;
            }
        }

        if(!matriculaPreenchido(dado)){
            mensagem = "Preencha o campo.";
            temErro = true;
        }

        return new ResultadoValidacao(temErro, mensagem);
    }
    
}
