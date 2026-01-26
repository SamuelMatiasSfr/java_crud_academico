package repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao{
    
    public static Connection getConexao(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            return DriverManager.getConnection(
                "jdbc:mysql://localhost/escola?useTimezone=true&serverTimezone=UTC",
                "root",
                ""
            );
        } catch (Exception e) {
            throw new RuntimeException("Erro na conexão: " + e.getMessage());
        }
    }

}
