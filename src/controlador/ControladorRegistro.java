package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import conexion.GestionBd;
import modelo.ModeloUsuario;
import view.Registro;

/**
 * 
 * @author Daniel Alejandro Alfaro Quintanar
 *
 */
public class ControladorRegistro implements ActionListener {
	Registro vistaRegistro;
	ModeloUsuario modeloUsuario;
	GestionBd gestiones;

	/**
	 * 
	 * @param vistaRegistro parametro del constructor de la clase
	 */
	public ControladorRegistro(Registro vistaRegistro) {
		this.vistaRegistro = vistaRegistro;
		this.modeloUsuario = ModeloUsuario.getUsuarioModel();
		this.gestiones = gestiones.getGestionBD();
		vistaRegistro.onClickBotonRegistrar(this);
		vistaRegistro.onClickBotonSalir(this);
	}

	/**
	 * Metodo ActionPerformed que escucha los botones
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == vistaRegistro.getBtnRegistro()) {
			if (vistaRegistro.getTxtNombreUsuario().getText().isEmpty()) {
				vistaRegistro.abrirError("Nombre de usuario vacio");
			} else if (vistaRegistro.getTxtContraseña().getText().isEmpty()) {
				vistaRegistro.abrirError("Contraseña vacia");
			} else if (vistaRegistro.getTxtContraseña2().getText().isEmpty()) {
				vistaRegistro.abrirError("Confirme contraseña");
			} else if (!vistaRegistro.getTxtContraseña().getText().equals(vistaRegistro.getTxtContraseña2().getText())) {
				vistaRegistro.abrirError("Contraseñas diferentes");
			}
			llenarModeloUsuario();
			try {
				gestiones.registrarUsuario(modeloUsuario);
				vistaRegistro.mostrarMensaje("Usuario "+vistaRegistro.getTxtNombreUsuario().getText()+" registrado con exito");
				vistaRegistro.limpiarVentana();
			} catch (Exception ex) {
				vistaRegistro.abrirError(ex.getMessage());
			}

		} else if (e.getSource() == vistaRegistro.getBtnSalir()) {
			vistaRegistro.mostrarVentanaAcceso();
		}
	}
	/**
	 * Metodo que llena el modelo del usuario
	 */
	private void llenarModeloUsuario() {
		modeloUsuario.setNombreUsuario(vistaRegistro.getTxtNombreUsuario().getText());
		modeloUsuario.setPasswordUsuario(vistaRegistro.getTxtContraseña().getText());
	}
}
