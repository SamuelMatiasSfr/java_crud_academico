package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Professor;
import model.Servidor;

public class ServidorRepository {

    public void create(Servidor servidor){
        String sql = "INSERT INTO servidores (matricula, nome, email, setor) VALUES (?, ?, ?, ?)";
        
        try {
            Connection conexao = Conexao.getConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, servidor.getMatricula());
            stmt.setString(2, servidor.getNome());
            stmt.setString(3, servidor.getEmail());
            stmt.setString(4, servidor.getSetor());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Servidor read(int id){
        String sql = "SELECT * FROM servidores WHERE id = ?";    
        Servidor servidor = null;

        try { 
            Connection conexao = Conexao.getConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet result = stmt.executeQuery();

            if(result.next()){
                servidor = new Servidor(
                    result.getInt("id"), 
                    result.getInt("matricula"), 
                    result.getString("nome"), 
                    result.getString("email"),
                    result.getString("setor")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return servidor;
    }

    public void update(Servidor servidor){
        String sql = "UPDATE servidores SET matricula = ?, nome = ?, email = ?, setor = ?  WHERE id = ?";

        try {
            Connection conexao = Conexao.getConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, servidor.getMatricula());
            stmt.setString(2, servidor.getNome());
            stmt.setString(3, servidor.getEmail());
            stmt.setString(4, servidor.getSetor());
            stmt.setInt(5, servidor.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void delete(int id){
        String sql = "DELETE FROM servidores WHERE id = ?";

        try {
            Connection conexao = Conexao.getConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Servidor> getTodos(){
        ArrayList<Servidor> servidores = new ArrayList<>();

        String sql = "SELECT * FROM professores";

        try {
            Connection conexao = Conexao.getConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();

            while(result.next()){
                servidores.add(
                    new Servidor(
                        result.getInt("id"), 
                        result.getInt("matricula"), 
                        result.getString("nome"), 
                        result.getString("email"),
                        result.getString("setor")
                    )
                ); 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return servidores;
    }
    
}
