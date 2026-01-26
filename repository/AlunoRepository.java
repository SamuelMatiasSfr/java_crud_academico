package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public Aluno read(int id){
        String sql = "SELECT * FROM aluno WHERE id = ?";    
        Aluno aluno = null;

        try { 
            Connection conexao = Conexao.getConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet result = stmt.executeQuery();

            if(result.next()){
                aluno = new Aluno(
                    result.getInt("id"), 
                    result.getInt("matricula"), 
                    result.getString("nome"), 
                    result.getString("email")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

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
