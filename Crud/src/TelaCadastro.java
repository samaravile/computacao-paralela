package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import modelo.Usuario;
import DAO.UsuarioDAO;

import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import javax.swing.JList;
import javax.swing.UIManager;

public class TelaCadastro {

	private JFrame frmCadastroDeClientes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro window = new TelaCadastro();
					window.frmCadastroDeClientes.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaCadastro() {
		initialize();
	}

	private void initialize() {
		frmCadastroDeClientes = new JFrame();
		frmCadastroDeClientes.getContentPane().setForeground(Color.BLACK);
		frmCadastroDeClientes.setTitle("Cadastro de Clientes");
		frmCadastroDeClientes.setBounds(100, 100, 450, 347);
		frmCadastroDeClientes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastroDeClientes.getContentPane().setLayout(null);
		
		Label label = new Label("Nome");
		label.setFont(new Font("Calibri", Font.PLAIN, 16));
		label.setBackground(Color.PINK);
		label.setBounds(27, 35, 46, 24);
		frmCadastroDeClientes.getContentPane().add(label);
		
		Label label_1 = new Label("Telefone");
		label_1.setFont(new Font("Calibri", Font.PLAIN, 16));
		label_1.setBackground(Color.PINK);
		label_1.setBounds(27, 65, 64, 24);
		frmCadastroDeClientes.getContentPane().add(label_1);
		
		Label label_2 = new Label("Email");
		label_2.setFont(new Font("Calibri", Font.PLAIN, 16));
		label_2.setBackground(Color.PINK);
		label_2.setBounds(27, 95, 45, 24);
		frmCadastroDeClientes.getContentPane().add(label_2);
		
		Label label_3 = new Label("Senha");
		label_3.setFont(new Font("Calibri", Font.PLAIN, 16));
		label_3.setBackground(Color.PINK);
		label_3.setBounds(27, 125, 49, 24);
		frmCadastroDeClientes.getContentPane().add(label_3);
		
		TextField textField = new TextField();
		textField.setFont(new Font("Calibri", Font.PLAIN, 16));
		textField.setBounds(79, 35, 263, 24);
		frmCadastroDeClientes.getContentPane().add(textField);
		
		TextField textField_1 = new TextField();
		textField_1.setFont(new Font("Calibri", Font.PLAIN, 16));
		textField_1.setBounds(97, 65, 245, 24);
		frmCadastroDeClientes.getContentPane().add(textField_1);
		
		TextField textField_2 = new TextField();
		textField_2.setFont(new Font("Calibri", Font.PLAIN, 16));
		textField_2.setBounds(78, 95, 264, 24);
		frmCadastroDeClientes.getContentPane().add(textField_2);
		
		TextField textField_3 = new TextField();
		textField_3.setFont(new Font("Calibri", Font.PLAIN, 16));
		textField_3.setBounds(82, 125, 260, 24);
		frmCadastroDeClientes.getContentPane().add(textField_3);
		
		Button button = new Button("Enviar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				Usuario usuario = new Usuario();
				usuario.setNome(textField.getText());
				usuario.setTelefone(textField_1.getText());
				usuario.setEmail(textField_2.getText());
				usuario.setSenha(textField_3.getText());
				
				JList<Usuario> list = new JList<Usuario>();
				list.setBorder(UIManager.getBorder("ComboBox.border"));
				list.setBounds(159, 185, 99, 24);
				frmCadastroDeClientes.getContentPane().add(list);
				
				UsuarioDAO dao = null;
				try {
					dao = new UsuarioDAO();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    dao.adiciona(usuario);
			    JOptionPane.showMessageDialog(null, "Usuário "+ textField.getText() +" inserido com sucesso! ");
			}
		});
		
		Button button_1 = new Button("Listar Tudo");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioDAO dao = null;
				try {
					dao = new UsuarioDAO();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    dao.seleciona();
			    
			}
		});
		
		Button button_2 = new Button("Deletar");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent i) {
				Usuario usuario = new Usuario();
				UsuarioDAO dao = null;
				try {
					dao = new UsuarioDAO();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				dao.seleciona();
			    dao.deleta(usuario);
			    JOptionPane.showMessageDialog(null, "Usuário "+ textField.getText() +" deletado com sucesso! ");
			}
		});
		
		Button button_3 = new Button("Alterar");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent u) {
				Usuario usuario = new Usuario();
				UsuarioDAO dao = null;
				try {
					dao = new UsuarioDAO();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				dao.seleciona();
				
				usuario.setNome(textField.getText());
				usuario.setTelefone(textField_1.getText());
				usuario.setEmail(textField_2.getText());
				usuario.setSenha(textField_3.getText());
				
			    dao.altera(usuario);
			    JOptionPane.showMessageDialog(null, "Usuário "+ textField.getText() +" alterado com sucesso! ");
			}
		});
		
		button.setBounds(322, 254, 79, 24);
		frmCadastroDeClientes.getContentPane().add(button);
		button_1.setBounds(225, 254, 79, 24);
		frmCadastroDeClientes.getContentPane().add(button_1);
		button_2.setBounds(125, 254, 79, 24);
		frmCadastroDeClientes.getContentPane().add(button_2);
		button_3.setBounds(27, 254, 79, 24);
		frmCadastroDeClientes.getContentPane().add(button_3);
	}
}
