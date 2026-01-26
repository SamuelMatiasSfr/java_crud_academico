package model;

public class Servidor{

    private int id;
    private int matricula;
    private String nome;
    private String email;
    private String setor;

    public Servidor(int id, int matricula, String nome, String email, String setor) {
        this.id = id;
        this.matricula = matricula;
        this.nome = nome;
        this.email = email;
        this.setor = setor;
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

    public String getSetor() {
        return setor;
    }

}