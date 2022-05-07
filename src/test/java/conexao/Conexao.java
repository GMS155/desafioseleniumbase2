package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    public Connection getConexao(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bugtracker",
                    "root",
                    "");
            return connection;
        } catch (Exception e){
            System.out.println("Erro ao conectar" + e.getMessage());

            return null;
        }
    }
}
