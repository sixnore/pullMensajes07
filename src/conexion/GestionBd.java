package conexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.ModeloMensaje;
import modelo.ModeloUsuario;

/**
 * 
 * @author Daniel Alejandro Alfaro Quintanar
 *
 */
public final class GestionBd{
	
	private static final GestionBd gestionBD = new GestionBd(); 
	
	private Connection lineConnection;
	private Statement statemet;
	
	/**
	 * Constructor de la clase GestionBD
	 */
	private GestionBd(){
		lineConnection=ConexionBd.getConexionBD().conectarBD();
	}
	
	/**
	 * Metodo para retornar la instancia
	 * @return GestionBD retorna la instancia
	 */
	public static GestionBd getGestionBD(){
		return gestionBD;
	}
	
	/**
	 * Metodo para ejecutar una consulta sin devolver nada
	 * @param consulta recibe el parametro y lo consulta
	 */
	public void ejecutar(String consulta){
		try {
			statemet=lineConnection.createStatement();
			statemet.execute(consulta);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al realiza la consulta"+JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Metodo para recuperar datos de la base de datos
	 * @param consulta parametro mediante el cual se hace la consulta
	 * @return rs retorna el rs con el contenido
	 */
	public ResultSet consultar(String consulta) {
		ResultSet rs=null;
		try {
			statemet=lineConnection.createStatement();
			rs=statemet.executeQuery(consulta);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al realiza la consulta"+JOptionPane.ERROR_MESSAGE);
		}
		return rs;
	}

	/**
	 * Metodo que registra un nuevo usuario
	 */
	public void registrarUsuario(ModeloUsuario usuarioModel) throws SQLException {
		String sql="INSERT INTO usuarios (nombreUsuario,password) VALUES"
				+ "('"+usuarioModel.getNombreUsuario()+"',"
				+ "'"+usuarioModel.getPasswordUsuario()+"')";
		try {
			statemet=lineConnection.createStatement();
			statemet.execute(sql);
		} catch (SQLException e) {
			System.out.println(e);
			throw new SQLException("Error al registrar usuario " +e);
		}
		usuarioModel.limpiarModelo();
	}

	/**
	 * Metodo que consultaUsuario el usuario
	 */
	public boolean verificarUsuario(ModeloUsuario usuarioModel) throws SQLException {
		String sql = "SELECT * FROM usuarios WHERE "
				+ "nombreUsuario = '"+usuarioModel.getNombreUsuario()+"' AND "
				+ "password = '"+usuarioModel.getPasswordUsuario()+"'";
		
		ResultSet rs=null;
		
		try {
			statemet=lineConnection.createStatement();
			rs=statemet.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println(e);
			throw new SQLException("Error al realizar consulta" +e);
		}
		
		if(rs.next()){
			usuarioModel.setIdUsuario(rs.getInt("idUsuario"));
			return true;
		}else{
			usuarioModel.limpiarModelo();
			return false;
		}
	}

	/**
	 * Metodo que consulta los mensajes
	 */
	public List<ModeloMensaje> consultarMensajes() throws SQLException {
		
		List<ModeloMensaje> lista=new ArrayList<ModeloMensaje>();
				
		String sql = "SELECT * FROM mensaje";
		
		ResultSet rs=null;
		
		try {
			statemet=lineConnection.createStatement();
			rs=statemet.executeQuery(sql);
			
			int c=0;
			
			while (rs.next()) {
				lista.add(new ModeloMensaje());
				lista.get(c).setIdMensaje(rs.getInt("idMensaje"));
				lista.get(c).setNombreUsuario(rs.getString("nombreUsuario"));
				lista.get(c).setMensaje(rs.getString("mensaje"));
				lista.get(c).setFecha(rs.getString("fecha"));
				lista.get(c).setHora(rs.getString("hora"));
				c++;
			}
		} catch (SQLException e) {
			System.out.println(e);
			throw new SQLException("No se pudo realizar la consulta");
		}
		
		return lista;
	}

	/**
	 * Metodo que registra mensaje nuevo
	 */
	public void agregarMensaje(ModeloMensaje mensajeModel) throws SQLException {
		
		String sql="INSERT INTO mensaje VALUES(null,"
				+ "'"+mensajeModel.getNombreUsuario()+"',"
				+ "'"+mensajeModel.getMensaje()+"',"
				+ "'"+mensajeModel.getFecha()+"',"
				+ "'"+mensajeModel.getHora()+"')";
		
		try {
			statemet=lineConnection.createStatement();
			statemet.execute(sql);
		} catch (SQLException e) {
			System.out.println(e);
			throw new SQLException("No se pudo insertar el mensaje");
		}
	}
}