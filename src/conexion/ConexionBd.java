package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

/**
 * 
 * @author Daniel Alejandro Alfaro Quintanar
 *
 */
public final class ConexionBd {
	
	private static final ConexionBd conexionBD = new ConexionBd();

	private String bd, user, pass, link;
	
	/**
	 * Constructor de la clase principal
	 */
	private ConexionBd(){
		bd="pullmensajes";
		user="root";
		pass="";
		link="jdbc:mysql://localhost/"+bd;
	}
	
	/**
	 * Metodo para recuperar objeto tipo ConexionBd
	 * @return conexionBD retorna objeto
	 */
	public static ConexionBd getConexionBD(){
		return conexionBD;
	}
	
	/**
	 * Metodo que ejecuta la conexion con excepciones
	 * @return conexion retorna la conexion de tipo Connection
	 */
	public Connection conectarBD(){
		Connection conexion=null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conexion=DriverManager.getConnection(link, user, pass);
		} catch (InstantiationException e) {
			JOptionPane.showMessageDialog(null, "Imposible instanciar "+ JOptionPane.ERROR_MESSAGE);
		} catch (IllegalAccessException e) {
			JOptionPane.showMessageDialog(null, "Imposible acceso "+ JOptionPane.ERROR_MESSAGE);
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "No se encontro el driver"+JOptionPane.ERROR_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Motivo: Nombre de usuario o contraseña incorrectos "+JOptionPane.ERROR_MESSAGE);
		}
		return conexion;
	}

}