package modelo;

/**
 * 
 * @author Daniel Alejandro Alfaro Quintanar
 *
 */
public class ModeloMensaje {
	
	private int idMensaje;
	private String nombreUsuario;
	private String mensaje;
	private String fecha;
	private String hora;
	
	/**
	 * @return el id del mensaje
	 */
	public int getIdMensaje() {
		return idMensaje;
	}
	/**
	 * @param idMensaje envia al parametro
	 */
	public void setIdMensaje(int idMensaje) {
		this.idMensaje = idMensaje;
	}
	/**
	 * @return el nombre de usuario
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	/**
	 * @param nombreUsuario envia el nombre de usuario
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	/**
	 * @return el mensaje 
	 */
	public String getMensaje() {
		return mensaje;
	}
	/**
	 * @param mensaje envia el mensaje
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	/**
	 * @return La fecha
	 */
	public String getFecha() {
		return fecha;
	}
	/**
	 * @param fecha envia la fecha
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	/**
	 * @return La hora
	 */
	public String getHora() {
		return hora;
	}
	/**
	 * @param hora envia la hora
	 */
	public void setHora(String hora) {
		this.hora = hora;
	}
}
