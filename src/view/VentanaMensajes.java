package view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorAcceso;
import javax.swing.JTextArea;

/**
 * 
 * @author JuanAlberto
 *
 */
public class VentanaMensajes extends JFrame{
	private JScrollPane scrollPane = new JScrollPane();
	private JLabel lblMensaje = new JLabel("Mensaje:");
	private JButton btnAgregar = new JButton("Enviar");
	private JTable table = new JTable();
	private JButton btnSalir;
	private JTextArea txtMensaje;
	private Container c = getContentPane();

	
	/**
	 * Constructor de la clase PullMensajesView
	 */
	public VentanaMensajes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Chat");
		this.setBounds(100, 100, 630, 350);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		c.setLayout(null);
		
		scrollPane.setBounds(191, 40, 421, 237);
		scrollPane.getVerticalScrollBar().setUnitIncrement(10);
		
		btnAgregar.setBounds(78, 293, 81, 20);
		lblMensaje.setVerticalAlignment(SwingConstants.TOP);
		lblMensaje.setHorizontalAlignment(SwingConstants.LEFT);
		lblMensaje.setBounds(20, 40, 81, 20);
		
		c.add(scrollPane);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Usuario", "Mensaje", "Fecha", "Hora"
			}
		){
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		table.getColumnModel().getColumn(1).setPreferredWidth(250);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		
		scrollPane.setViewportView(table);
		c.add(btnAgregar);
		c.add(lblMensaje);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(466, 288, 90, 23);
		getContentPane().add(btnSalir);
		
		JLabel lblBienvenido = new JLabel("Bienvenido...");
		lblBienvenido.setBounds(10, 13, 284, 16);
		getContentPane().add(lblBienvenido);
		
		txtMensaje = new JTextArea();
		txtMensaje.setBounds(10, 72, 169, 205);
		getContentPane().add(txtMensaje);
	}

	/**
	 * @return the scrollPane
	 */
	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	/**
	 * @return the txtMensaje
	 */


	/**
	 * @return the btnAgregar
	 */
	public JButton getBtnAgregar() {
		return btnAgregar;
	}



	public JTextArea getTxtMensaje() {
		return txtMensaje;
	}

	/**
	 * @return the table
	 */
	public JTable getTable() {
		return table;
	}
	
	/**
	 * @return the btnCambiarUsuario
	 */
	public JButton getBtnCambiarUsuario() {
		return btnSalir;
	}

	/**
	 * M�todo para agregar el evento click al boton
	 * @param al evento click
	 */
	public void onClickBotonAgregar(ActionListener al){
		btnAgregar.addActionListener(al);
	}
	public void onClickBotonSalir(ActionListener al){
		btnSalir.addActionListener(al);
	}
	/**
	 * M�todo para mostrar mensaje en pantalla
	 * @param mensaje generado
	 */
	public void mostrarMensaje(String mensaje){
		JOptionPane.showMessageDialog(this, mensaje);
	}
	
	/**
	 * M�todo para mostrar alerta en pantalla
	 * @param alerta generada
	 */
	public void mostrarAlerta(String alerta){
		JOptionPane.showMessageDialog(this, alerta, "Alerta", JOptionPane.WARNING_MESSAGE);
	}
	
	/**
	 * M�todo para mostrar error en pantalla
	 * @param error generado
	 */
	public void mostrarError(String error){
		JOptionPane.showMessageDialog(this, error, "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * M�todo para limpiar ventana
	 */
	
	public void mostrarInicio(){
		Login accesoView=new Login();
		ControladorAcceso accesoController=new ControladorAcceso(accesoView);
		this.setVisible(false);
		accesoView.setVisible(true);
	}
}
