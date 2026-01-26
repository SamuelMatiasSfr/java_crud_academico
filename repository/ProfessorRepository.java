package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Professor;

public class ProfessorRepository {

    public void create(Professor professor){
        String sql = "INSERT INTO  (matricula, nome, email) VALUES (?, ?, ?)";
        
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

    public Professor read(){
        
        
        Professor professor = new Professor(0, 0, null, null, null, 0);
        return professor;
    }

    public void update(Professor professor){

    }

    public void delete(int id){

    }

    public ArrayList<Professor> getTodos(){
        ArrayList<Professor> professores = new ArrayList<>();

        

        return professores;
    }
    
}
