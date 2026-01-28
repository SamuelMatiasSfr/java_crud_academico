package model;

public class Aluno{
    
    private int id;
    private int matricula;
    private String nome;
    private String email;

    public Aluno(int id, int matricula, String nome, String email) {
        this.id = id;
        this.matricula = matricula;
        this.nome = nome;
        this.email = email;
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

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}