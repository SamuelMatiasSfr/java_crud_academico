package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Aluno;

public class AlunoRepository {
    
    public void create(Aluno aluno){
        String sql = "INSERT INTO Aluno (matricula, nome, email) VALUES (?, ?, ?)";
        
        try {
            Connection conexao = Conexao.getConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, aluno.getMatricula());
            stmt.setString(2, aluno.getNome());
            stmt.setString(3, aluno.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Aluno read(){
        
        
        Aluno aluno = new Aluno(0, 0, null, null);
        return aluno;
    }

    public void update(Aluno aluno){

    }

    public void delete(int id){

    }

    public ArrayList<Aluno> getTodos(){
        ArrayList<Aluno> alunos = new ArrayList<>();



        return alunos;
    }

}
