package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Professor;

public class ProfessorRepository {

    public void create(Professor professor){
        String sql = "INSERT INTO professores (matricula, nome, email, formacao, status) VALUES (?, ?, ?, ?, ?)";
        
        try {
            Connection conexao = Conexao.getConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, professor.getMatricula());
            stmt.setString(2, professor.getNome());
            stmt.setString(3, professor.getEmail());
            stmt.setString(4, professor.getFormacao());
            stmt.setInt(5, professor.getStatus());
            stmt.executeUpdate();
        } catch (SQLException e) {}

    }

    public void update(Professor professor){
        String sql = "UPDATE professores SET matricula = ?, nome = ?, email = ?, formacao = ?, status = ? WHERE id = ?";

        try {
            Connection conexao = Conexao.getConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, professor.getMatricula());
            stmt.setString(2, professor.getNome());
            stmt.setString(3, professor.getEmail());
            stmt.setString(4, professor.getFormacao());
            stmt.setInt(5, professor.getStatus());
            stmt.setInt(6, professor.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {}

    }

    public void delete(int id){
        String sql = "DELETE FROM professores WHERE id = ?";

        try {
            Connection conexao = Conexao.getConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {}

    }

    public ArrayList<Professor> getTodos(){
        ArrayList<Professor> professores = new ArrayList<>();

        String sql = "SELECT * FROM professores";

        try {
            Connection conexao = Conexao.getConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();

            while(result.next()){
                professores.add(
                    new Professor(
                        result.getInt("id"), 
                        result.getInt("matricula"), 
                        result.getString("nome"), 
                        result.getString("email"),
                        result.getString("formacao"),
                        result.getInt("status")
                    )
                ); 
            }
        } catch (SQLException e) {}

        return professores;
    }
    
}
