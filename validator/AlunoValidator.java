package validator;

import model.Aluno;

import java.util.ArrayList;

public class AlunoValidator {

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

    private static boolean existeAlunoComMatricula(String id, String matricula, boolean ehCreate, ArrayList<Aluno> alunos){
        boolean existe = false;

        int matriculaDigitado = Integer.parseInt(matricula);
        for(int i=0; i<alunos.size(); i++){
            int matriculaLoop = alunos.get(i).getMatricula();
            if(ehCreate){
                if(matriculaDigitado == matriculaLoop){
                    existe = true;
                    break;
                }
            }else{
                int idDigitado = Integer.parseInt(id);
                int idLoop = alunos.get(i).getId();
                if((idDigitado != idLoop) && (matriculaDigitado == matriculaLoop)){
                    existe = true;
                    break;
                }
            }
        }

        return existe;
    }

    private static boolean existeAlunoComEmail(String id, String email, boolean ehCreate, ArrayList<Aluno> alunos){
        boolean existe = false;

        for(int i=0; i<alunos.size(); i++){
            String emailLoop = alunos.get(i).getEmail();
            if(ehCreate){
                if(email.equals(emailLoop)){
                    existe = true;
                    break;
                }
            }else{
                int idDigitado = Integer.parseInt(id);
                int idLoop = alunos.get(i).getId();
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

    public static ResultadoValidacao verificarErrosFormulario(String[] dados, ArrayList<Aluno> alunos, boolean ehCreate){
        boolean temErro = false;
        String mensagem = "";

        if(
            emailPreenchido(dados[3]) &&
            emailValido(dados[3]) &&
            existeAlunoComEmail(dados[0], dados[3], ehCreate, alunos)
        ){
            mensagem = "Já existe um aluno cadastrado com este email.";
            temErro = true;
        }

        if(
            matriculaPreenchido(dados[1]) &&
            matriculaValido(dados[1]) &&
            existeAlunoComMatricula(dados[0], dados[1], ehCreate, alunos)
        ){
            mensagem = "Já existe um aluno cadastrado com esta matrícula.";
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
        }

        if(
            !matriculaPreenchido(dados[1]) ||
            !nomePreenchido(dados[2]) ||
            !emailPreenchido(dados[3])
        ){
            mensagem = "Preencha todos os campos obrigatórios.";
            temErro = true;
        }

        if(!idPreenchido(dados[0]) && !ehCreate){
            mensagem = "Selecione um aluno para atualizar ou deletar.";
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
