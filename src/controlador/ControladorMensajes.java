package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import conexion.GestionBd;
import modelo.ModeloMensaje;
import modelo.ModeloUsuario;
import view.VentanaMensajes;

/**
 * 
 * @author Daniel Alejandro Alfaro Quintanar
 *
 */
public class ControladorMensajes implements ActionListener {
	private VentanaMensajes vistaMensajes;
	private ModeloUsuario modeloUsuarios;
	private List<ModeloMensaje> mensajes;
	private GestionBd gestiones;
	private List<ModeloUsuario> usuarios;

	/**
	 * 
	 * @param vistaMensajes parametro vistaMensajes en constructor que apertura
	 */
	public ControladorMensajes(VentanaMensajes vistaMensajes) {
		this.vistaMensajes = vistaMensajes;
		this.modeloUsuarios = ModeloUsuario.getUsuarioModel();
		this.gestiones = gestiones.getGestionBD();
		vistaMensajes.onClickBotonAgregar(this);
		vistaMensajes.onClickBotonSalir(this);
		llenarMensajes();
	}

	/**
	 * Metodo que llena los mensajes de la base de datos
	 */
	private void llenarMensajes() {
		try {
			mensajes = gestiones.consultarMensajes();
		} catch (SQLException e) {
			e.getMessage();
		}
		DefaultTableModel modelo = (DefaultTableModel) vistaMensajes.getTable().getModel();
		Object a[] = { null };
		int count = modelo.getRowCount();

		for (int i = 0; i < count; i++) {
			modelo.removeRow(0);
		}

		for (int i = 0; i < mensajes.size(); i++) {
			modelo.addRow(a);

			vistaMensajes.getTable().setValueAt(mensajes.get(i).getNombreUsuario(), i, 0);
			vistaMensajes.getTable().setValueAt(mensajes.get(i).getMensaje(), i, 1);
			vistaMensajes.getTable().setValueAt(mensajes.get(i).getFecha(), i, 2);
			vistaMensajes.getTable().setValueAt(mensajes.get(i).getHora(), i, 3);
		}
		vistaMensajes.getScrollPane().getVerticalScrollBar()
				.setValue(vistaMensajes.getScrollPane().getVerticalScrollBar().getMaximum());
	}

	/**
	 * Metodo ActionPerformed que escucha a los botones
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == vistaMensajes.getBtnAgregar()) {
			if (vistaMensajes.getTxtMensaje().getText().isEmpty()) {
				vistaMensajes.mostrarAlerta("Ingresar mensaje");
				return;
			}

			ModeloMensaje mensajeModel = new ModeloMensaje();

			String[] meses = new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto",
					"Septiembre", "Octubre", "Noviembre", "Diciembre" };

			Calendar now = Calendar.getInstance();

			int dia = now.get(Calendar.DAY_OF_MONTH);
			String mes = meses[now.get(Calendar.MONTH)];
			int area = now.get(Calendar.YEAR);
			String hora, minutos, segundos, ampm;

			ampm = now.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";

			if (ampm.equals("PM")) {
				int h = now.get(Calendar.HOUR_OF_DAY) - 12;

				hora = h > 9 ? "" + h : "0" + h;

			} else {
				hora = now.get(Calendar.HOUR_OF_DAY) > 9 ? "" + now.get(Calendar.HOUR_OF_DAY)
						: "0" + now.get(Calendar.HOUR_OF_DAY);
			}

			minutos = now.get(Calendar.MINUTE) > 9 ? "" + now.get(Calendar.MINUTE) : "0" + now.get(Calendar.MINUTE);
			segundos = now.get(Calendar.SECOND) > 9 ? "" + now.get(Calendar.SECOND) : "0" + now.get(Calendar.SECOND);

			mensajeModel.setNombreUsuario(modeloUsuarios.getNombreUsuario());
			mensajeModel.setMensaje(vistaMensajes.getTxtMensaje().getText());
			mensajeModel.setFecha(mes + " " + dia + ", " + area);
			mensajeModel.setHora(hora + ":" + minutos + ":" + segundos + " " + ampm);

			try {
				gestiones.agregarMensaje(mensajeModel);
			} catch (SQLException e) {
				e.getMessage();
			}
			vistaMensajes.getTxtMensaje().setText(null);
			llenarMensajes();
		} else if (ae.getSource() == vistaMensajes.getBtnCambiarUsuario()) {
			vistaMensajes.mostrarInicio();
		}
	}
}
