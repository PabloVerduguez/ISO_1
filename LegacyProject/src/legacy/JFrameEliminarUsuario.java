package legacy;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Exceptions.ContraseñaInvalidaException;
import Exceptions.UsuarioNoExisteException;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Color;

import javax.swing.JTextPane;

import java.awt.event.ActionListener;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class JFrameEliminarUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldLogin;
	private JTextField textFieldPassword;
	private JTextPane textPane;

	/**
	 * Launch the application.
	 
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameNuevoUsuario frame = new JFrameNuevoUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/
	
	/**
	 * Create the frame.
	 */
	public JFrameEliminarUsuario() {
		setTitle("Eliminar usuario registrado - ya se implementar\u00E1...");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 285);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Password:");
		lblLogin.setBounds(6, 81, 69, 16);
		contentPane.add(lblLogin);
		
		JLabel label = new JLabel("Login:");
		label.setBounds(6, 37, 69, 16);
		contentPane.add(label);
		
		textFieldLogin = new JTextField();
		textFieldLogin.setBounds(87, 31, 134, 28);
		contentPane.add(textFieldLogin);
		textFieldLogin.setColumns(10);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(87, 75, 134, 28);
		contentPane.add(textFieldPassword);
		
		JButton btnAltaUsuario = new JButton("Eliminar usuario");
		btnAltaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean eliminado = false;
				try {
					Usuario u = new Usuario(textFieldLogin.getText(), textFieldPassword.getText());
					if(u.delete() ==1)
						eliminado = true;
					if(eliminado){
						textPane.setText("Usuario eliminado correctamente");
					}else {
						textPane.setText("No se ha podido eliminar el usuario");
					}
				} catch (UsuarioNoExisteException x) {
					textPane.setText(x.getMessage());
				} catch (ContraseñaInvalidaException c) {
					textPane.setText(c.getMessage());
				} catch (SQLException e) {
					textPane.setText(e.getMessage());
				} catch (Exception e) {
					textPane.setText(e.getMessage());
				}
			}
		});
		btnAltaUsuario.setBounds(253, 76, 141, 29);
		contentPane.add(btnAltaUsuario);
		
		JLabel label_1 = new JLabel("Estado");
		label_1.setForeground(Color.RED);
		label_1.setBounds(6, 126, 61, 16);
		contentPane.add(label_1);
		
		textPane = new JTextPane();
		textPane.setToolTipText("Panel para mostrar el restultado de la comprobaci\u00F3n de login o las excepciones lanzadas");
		textPane.setEditable(false);
		textPane.setBounds(6, 154, 407, 102);
		contentPane.add(textPane);
	}
}
