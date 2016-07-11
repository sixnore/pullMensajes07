package modelo;

/**
 * 
 * @author Daniel Alejandro Alfaro Quintanar
 *
 */
public final class ModeloUsuario {
	
	private static final ModeloUsuario usuarioModel = new ModeloUsuario();

	private int idUsuario;
	private String nombreUsuario;
	private String passwordUsuario;
	
	/**
	 * constructor principal
	 */
	private ModeloUsuario(){
		super();
	}
	/**
	 * 
	 * @return retorna la instancia del modelo
	 */
	public static ModeloUsuario getUsuarioModel(){
		return usuarioModel;
	}
	
	/**
	 * @return el usuario
	 */
	public int getIdUsuario() {
		return idUsuario;
	}

	/**
	 * @param idUsuario envia el usuario
	 */
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
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
	 * @return la contraseña
	 */
	public String getPasswordUsuario() {
		return passwordUsuario;
	}

	/**
	 * @param passwordUsuario envia la contraseña
	 */
	public void setPasswordUsuario(String passwordUsuario) {
		this.passwordUsuario = passwordUsuario;
	}

	/**
	 * metodo que limpia el contenido del modelo
	 */
	public void limpiarModelo(){
		idUsuario=0;
		nombreUsuario=null;
		passwordUsuario=null;
	}
}
