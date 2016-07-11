package view;

import java.awt.Container;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

import controlador.ControladorAcceso;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

/**
 * 
 * @author Daniel Alejandro Alfaro Quintanar
 *
 */
public class Registro extends JFrame{
	private JLabel lblNombreUsuario = new JLabel("Nombre de usuario:");
	private JLabel lblContraseña = new JLabel("Contraseña");

	private JButton btnSalir = new JButton("Salir");
	private JButton btnRegistro = new JButton("Registrar");
	
	private JTextField txtNombreUsuario;
	private JPasswordField txtContraseña;
	
	private Container c = getContentPane();
	private JLabel lblContraseña2 = new JLabel("Confirme contraseña:");
	private JPasswordField txtContraseña2 = new JPasswordField();

	
	/**
	 * Constructor de la clase AccesoView
	 */
	public Registro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Registro");
		this.setBounds(100, 100, 303, 342);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		c.setLayout(null);
		
		btnSalir.setBounds(42, 265, 211, 30);
		btnRegistro.setBounds(42, 221, 211, 30);
		
		lblNombreUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombreUsuario.setBounds(83, 38, 134, 14);
		
		lblContraseña.setHorizontalAlignment(SwingConstants.LEFT);
		lblContraseña.setBounds(109, 96, 76, 14);
		
		txtNombreUsuario = new JTextField();
		txtNombreUsuario.setBounds(42, 64, 211, 20);
		
		txtContraseña = new JPasswordField();
		txtContraseña.setBounds(42, 122, 211, 20);
		
		c.add(btnSalir);
		c.add(btnRegistro);
		c.add(lblNombreUsuario);
		c.add(lblContraseña);
		c.add(txtNombreUsuario);
		c.add(txtContraseña);
		lblContraseña2.setHorizontalAlignment(SwingConstants.LEFT);
		lblContraseña2.setBounds(77, 154, 152, 14);
		
		getContentPane().add(lblContraseña2);
		txtContraseña2.setBounds(42, 176, 211, 20);
		
		getContentPane().add(txtContraseña2);
	}

	/**
	 * @return boton salir
	 */
	public JButton getBtnSalir() {
		return btnSalir;
	}

	/**
	 * @return boton registrar
	 */
	public JButton getBtnRegistro() {
		return btnRegistro;
	}

	/**
	 * @return regresa el usuario
	 */
	public JTextField getTxtNombreUsuario() {
		return txtNombreUsuario;
	}

	/**
	 * @return regresa la contraseña
	 */
	public JPasswordField getTxtContraseña() {
		return txtContraseña;
	}

	/**
	 * @return regresa la contraseña 2
	 */
	public JPasswordField getTxtContraseña2() {
		return txtContraseña2;
	}

	/**
	 * 
	 * @param al Metodo actionPerformed que asigna escuchador al botonSalir
	 */
	public void onClickBotonSalir(ActionListener al){
		btnSalir.addActionListener(al);
	}
	/**
	 * 
	 * @param al Metodo actionPerformed que asigna escuchador al botonRegistrar
	 */
	public void onClickBotonRegistrar(ActionListener al){
		btnRegistro.addActionListener(al);
	}
	
	/**
	 * Metodo para mostrar la ventana de acceso
	 */
	public void mostrarVentanaAcceso(){
		Login accesoView = new Login();
		ControladorAcceso accesoController = new ControladorAcceso(accesoView);
		this.setVisible(false);
		accesoView.setVisible(true);
	}
	
	/**
	 * Metodo para mostrar mensaje en pantalla
	 * @param mensaje parametro mensaje
	 */
	public void mostrarMensaje(String mensaje){
		JOptionPane.showMessageDialog(this, mensaje);
	}
	
	/**
	 * Metodo que muestra error 
	 * @param error parametro error
	 */
	public void abrirError(String error){
		JOptionPane.showMessageDialog(this, error, "Alerta", JOptionPane.WARNING_MESSAGE);
	}
	
	/**
	 * Metodo para limpiar ventana
	 */
	public void limpiarVentana(){
		txtNombreUsuario.setText(null);
		txtContraseña.setText(null);
		txtContraseña2.setText(null);
	}
}
