package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import conexion.GestionBd;
import modelo.ModeloUsuario;
import view.Login;

/**
 * 
 * @author Daniel Alejandro Alfaro Quintanar
 *
 */
public class ControladorAcceso implements ActionListener {
	private Login vistaLogin;
	private GestionBd gestiones;
	private ModeloUsuario modeloUsuario;

	/**
	 * 
	 * @param vistaLogin Parametro vista login en constructor
	 */
	public ControladorAcceso(Login vistaLogin) {
		this.vistaLogin = vistaLogin;
		this.gestiones = gestiones.getGestionBD();
		this.modeloUsuario = ModeloUsuario.getUsuarioModel();
		vistaLogin.onClickBotonLogin(this);
		vistaLogin.onClickBotonRegistro(this);
	}

	/**
	 * Metodo actionperformed que escucha los botones
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == vistaLogin.getbtnLogin()) {
			if (vistaLogin.getTxtUsuario().getText().isEmpty()) {
				vistaLogin.abrirError("Usuario vacio");
			} else if (vistaLogin.getTxtPassword().getText().isEmpty()) {
				vistaLogin.abrirError("Contraseña vacia");
			} else {
				llenarModeloUsuario();
			}
			try {
				if (gestiones.verificarUsuario(modeloUsuario)) {
					vistaLogin.abrirChat();
					;
				} else {
					vistaLogin.abrirError("No pudo acceder verifique sus datos");
				}
			} catch (SQLException ex) {
				vistaLogin.abrirError("Error al realizar consulta");
			}
		}
		if (e.getSource() == vistaLogin.getBtnRegistro()) {
			vistaLogin.Registro();
		}
	}
	/**
	 * Metodo que llena el modelo con registros
	 */
	private void llenarModeloUsuario() {
		modeloUsuario.setNombreUsuario(vistaLogin.getTxtUsuario().getText());
		modeloUsuario.setPasswordUsuario(vistaLogin.getTxtPassword().getText());
	}
}
