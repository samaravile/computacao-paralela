/* Trabalho feito por:
 * 
 * Isadora, Luis e Samara
 * 
 * */

import java.sql.*;

public class DaoUsuario extends Thread{ 
	
    private Connection connection;
    private int codusuario;
	private String nome;
	private String tipo;
	private String senha;
    
    public DaoUsuario(){ 
        this.connection = new ConnectionFactory().getConnection();
    } 
    public void adiciona(Usuario usuario){
        String sql = "INSERT INTO usuario(codusuario,nome,tipo,senha) VALUES(?,?,?,?)";
        try { 
	    Thread.sleep(1000);
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getTipo());
            stmt.setString(3, usuario.getSenha());
            stmt.execute();
            stmt.close();
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
        
    } 
    
}
