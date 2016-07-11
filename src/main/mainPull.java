package main;

import javax.swing.JOptionPane;

import conexion.GestionBd;
import controlador.ControladorAcceso;
import view.Login;

/**
 * 
 * @author Daniel Alejandro Alfaro Quintanar
 *
 */
public class mainPull {

	/**
	 * Metodo main que inicia la aplicacion 
	 * @param args parametro ards
	 */
	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "Profesor la base de datos puede importarla de la carpeta 'requeribles' del proyecto y puede usar el usuario 'IngBalam' con la contraseña '12345' o bien crear un nuevo usuario");
		GestionBd.getGestionBD();
		Login Login=new Login();
		ControladorAcceso accesoController=new ControladorAcceso(Login);
		Login.setVisible(true);
	}
}
