package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Aluno;

public class AlunoRepository {
    
    public void create(Aluno aluno){
        String sql = "INSERT INTO alunos (matricula, nome, email) VALUES (?, ?, ?)";
        
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

    public Boolean read(int id){
        String sql = "SELECT * FROM alunos WHERE id = ?";    
        boolean alunoExiste = false;

        try { 
            Connection conexao = Conexao.getConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet result = stmt.executeQuery();

            if(result.next()){
                alunoExiste = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return alunoExiste;
    }

    public Boolean readPorMatricula(int matricula){
        boolean existe = false;

        String sql = "SELECT * FROM alunos WHERE matricula = ?";    

        try { 
            Connection conexao = Conexao.getConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, matricula);
            ResultSet result = stmt.executeQuery();

            if(result.next()){
                existe = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return existe;
    }

    public void update(Aluno aluno){
        String sql = "UPDATE alunos SET matricula = ?, nome = ?, email = ? WHERE id = ?";

        try {
            Connection conexao = Conexao.getConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, aluno.getMatricula());
            stmt.setString(2, aluno.getNome());
            stmt.setString(3, aluno.getEmail());
            stmt.setInt(4, aluno.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void delete(int id){
        String sql = "DELETE FROM alunos WHERE id = ?";

        try {
            Connection conexao = Conexao.getConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Aluno> getTodos(){
        ArrayList<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT * FROM alunos";

        try {
            Connection conexao = Conexao.getConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();

            while(result.next()){
                alunos.add(
                    new Aluno(
                        result.getInt("id"), 
                        result.getInt("matricula"), 
                        result.getString("nome"), 
                        result.getString("email")
                    )
                ); 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return alunos;
    }

}
