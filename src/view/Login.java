package view;

import java.awt.Container;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

import controlador.ControladorMensajes;
import controlador.ControladorRegistro;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

/**
 * 
 * @author Daniel Alejandro Alfaro Quintanar
 *
 */
public class Login extends JFrame{
	private JLabel lblUsuario = new JLabel("Nombre de usuario:");
	private JLabel lblContraseña = new JLabel("Password:");

	private JButton btnLogin = new JButton("Entrar");
	private JButton btnRegistro = new JButton("Registrar usuario");
	
	private JTextField txtUsuario;
	private JPasswordField txtPassword;
	
	private Container c = getContentPane();

	
	/**
	 * Constructor de la clase primaria
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Login");
		this.setBounds(100, 100, 272, 320);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		c.setLayout(null);
		
		btnLogin.setBounds(58, 162, 153, 30);
		btnRegistro.setBounds(58, 204, 153, 30);
		
		lblUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsuario.setBounds(76, 45, 135, 14);
		
		lblContraseña.setHorizontalAlignment(SwingConstants.LEFT);
		lblContraseña.setBounds(106, 103, 63, 14);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(33, 71, 209, 20);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(33, 130, 209, 20);
		
		c.add(btnLogin);
		c.add(btnRegistro);
		c.add(lblUsuario);
		c.add(lblContraseña);
		c.add(txtUsuario);
		c.add(txtPassword);
	}

	/**
	 * @return retorna el boton login
	 */
	public JButton getbtnLogin() {
		return btnLogin;
	}

	/**
	 * @return retorna el boton registro
	 */
	public JButton getBtnRegistro() {
		return btnRegistro;
	}

	/**
	 * @return retorna el usuario
	 */
	public JTextField getTxtUsuario() {
		return txtUsuario;
	}

	/**
	 * @return the retorna la contraseña
	 */
	public JPasswordField getTxtPassword() {
		return txtPassword;
	}

	/**
	 * 
	 * @param al Metodo que añade escuchador a los botones
	 */
	public void onClickBotonLogin(ActionListener al){
		btnLogin.addActionListener(al);
	}
	/**
	 * 
	 * @param al Metodo que añade escuchador a los botones
	 */
	public void onClickBotonRegistro(ActionListener al){
		btnRegistro.addActionListener(al);
	}
	/**
	 * Metodo para mostrar ventana de registro
	 */
	public void Registro(){
		Registro registro = new Registro();
		ControladorRegistro registroController = new ControladorRegistro(registro);
		this.setVisible(false);
		registro.setVisible(true);
	}
	
	/**
	 * Metodo que muestra mensaje
	 * @param mensaje mensajes en ventana
	 */
	public void mostrarMensaje(String mensaje){
		JOptionPane.showMessageDialog(this, mensaje);
	}
	
	/**
	 * Metodo que muestra un error
	 * @param error parametro
	 */
	public void abrirError(String error){
		JOptionPane.showMessageDialog(this, error, "Error", JOptionPane.WARNING_MESSAGE);
	}
	
	/**
	 * Metodo para limpiar la ventana
	 */
	public void limpiarVentana(){
		txtUsuario.setText(null);
		txtPassword.setText(null);
	}
	
	/**
	 * Metodo para mostrar la ventana de mensajes
	 */
	public void abrirChat(){
		VentanaMensajes chat = new VentanaMensajes();
		ControladorMensajes pullMensajesController = new ControladorMensajes(chat);
		this.setVisible(false);
		chat.setVisible(true);
	}
}
