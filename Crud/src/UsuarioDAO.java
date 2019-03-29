package DAO;

import factory.ConnectionFactory;
import modelo.Usuario;
import java.sql.*;
import java.sql.PreparedStatement;

public class UsuarioDAO { 
    private Connection connection;
    Double id;
    String nome;
    String telefone;
    String email;
    String senha;
    
    public UsuarioDAO() throws ClassNotFoundException{ 
        this.connection = new ConnectionFactory().getConnection();
    } 
    
    public void adiciona(Usuario usuario){ 
        String sql = "INSERT INTO usuario(nome,telefone,email,senha) VALUES(?,?,?,?)";
        try { 
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getTelefone());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getSenha());
            stmt.execute();
            stmt.close();
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        }
    }
    
    public String seleciona() {
    	String sql = "SELECT * FROM usuario";
        try { 
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.execute();
            stmt.close();
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        }
        
        return sql;
    }
    
    public void altera(Usuario usuario) {
    	String sql = "UPDATE usuario SET nome=?, telefone=?, email=?, senha=?";
        try { 
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.executeUpdate(nome);
            stmt.setString(2, usuario.getTelefone());
            stmt.executeUpdate(telefone);
            stmt.setString(3, usuario.getEmail());
            stmt.executeUpdate(email);
            stmt.setString(4, usuario.getSenha());
            stmt.executeUpdate(senha);
            stmt.close();
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        }
    }
    
    public void deleta(Usuario usuario) {
    	String sql = "DELETE FROM usuario WHERE id=?";
        try { 
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setDouble(0, usuario.getId());
            stmt.execute();
            stmt.close();
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        }
    }
}
