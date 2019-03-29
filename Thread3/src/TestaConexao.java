/* Trabalho feito por:
 * 
 * Isadora, Luis e Samara
 * 
 * */


import java.sql.Connection; 
import java.sql.SQLException;


public class TestaConexao {     
    public static void main(String[] args) throws SQLException {
         Connection connection = new ConnectionFactory().getConnection();
         System.out.println("Informamos que a conexão com o banco de dados foi iniciada! Trabalho: Luis, Isadora e Samara");
         connection.close();
     }
}
