package model;

public class Professor {

    private int id;
    private int matricula;
    private String nome;
    private String email;
    private String formacao;
    private int status;

    public Professor(int id, int matricula, String nome, String email, String formacao, int status) {
        this.id = id;
        this.matricula = matricula;
        this.nome = nome;
        this.email = email;
        this.formacao = formacao;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getFormacao() {
        return formacao;
    }

    public int getStatus() {
        return status;
    }
    
}
