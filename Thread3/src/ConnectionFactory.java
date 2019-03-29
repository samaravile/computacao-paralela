/* Trabalho feito por:
 * 
 * Isadora, Luis e Samara
 * 
 * */


import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 


public class ConnectionFactory {
     public Connection getConnection() {
		 try {
			return DriverManager.getConnection("jdbc:mysql://localhost/CriarUsuario","Usuario","Senha");
		 }         
		 catch(SQLException excecao) {
			throw new RuntimeException(excecao);
		 }
     }
}
