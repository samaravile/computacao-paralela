package factory; 

import java.sql.*;  

public class ConnectionFactory {
	
	public Connection getConnection() throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/compdist","root", "root");
		}         
		catch(SQLException ex) {
			throw new RuntimeException(ex);
		}
	}
}
