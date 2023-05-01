package interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import conexiones.Conexion;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class ModificarHost extends JFrame {

	/*
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField campo_BuscarDireccion;
	private JTextField campo_BuscarHostname;
	private JTextField campo_ModificarDireccion;
	private JTextField campo_ModificarHostname;
	private static ModificarHost ventanaModificarHost;
	private JTextField campo_modificarDepartamento;

	public static ModificarHost getSesionInstance() {
		if (ventanaModificarHost == null) {
			ventanaModificarHost = new ModificarHost();
		}
		return ventanaModificarHost;
	}

	public ModificarHost() {
		setResizable(false);
		setTitle("Network Control");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("D:\\\\eclipse-workspace\\\\NetworkControl\\\\icons\\\\RJ45.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 390, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*
		 * JLabels
		 */
		
		JLabel etiqueta_Buscar = new JLabel("BUSCAR");
		etiqueta_Buscar.setFont(new Font("Tahoma", Font.BOLD, 15));
		etiqueta_Buscar.setBounds(10, 67, 84, 32);
		contentPane.add(etiqueta_Buscar);

		JLabel etiqueta_BuscarDireccion = new JLabel("Direcci\u00F3n:");
		etiqueta_BuscarDireccion.setBounds(30, 110, 84, 14);
		contentPane.add(etiqueta_BuscarDireccion);

		JLabel etiqueta_BuscarHostname = new JLabel("Hostname:");
		etiqueta_BuscarHostname.setBounds(30, 141, 84, 14);
		contentPane.add(etiqueta_BuscarHostname);

		JLabel etiqueta_Modificar = new JLabel("MODIFICAR");
		etiqueta_Modificar.setFont(new Font("Tahoma", Font.BOLD, 15));
		etiqueta_Modificar.setBounds(12, 217, 146, 32);
		contentPane.add(etiqueta_Modificar);

		JLabel etiqueta_ModificarDireccion = new JLabel("Direcci\u00F3n:");
		etiqueta_ModificarDireccion.setBounds(31, 273, 84, 14);
		contentPane.add(etiqueta_ModificarDireccion);

		JLabel etiqueta_ModificarHostname = new JLabel("Hostname:");
		etiqueta_ModificarHostname.setBounds(31, 304, 84, 14);
		contentPane.add(etiqueta_ModificarHostname);

		JLabel etiqueta_ModificarDepartamento = new JLabel("Departamento:");
		etiqueta_ModificarDepartamento.setBounds(31, 336, 104, 14);
		contentPane.add(etiqueta_ModificarDepartamento);

		JLabel etiqueta_Titulo = new JLabel("Modificar Host");
		etiqueta_Titulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		etiqueta_Titulo.setBounds(98, 11, 220, 47);
		contentPane.add(etiqueta_Titulo);
		setLocationRelativeTo(null);

		/*
		 * JTextFields
		 */
		
		campo_ModificarDireccion = new JTextField();
		campo_ModificarDireccion.setEnabled(false);
		campo_ModificarDireccion.setColumns(10);
		campo_ModificarDireccion.setBounds(153, 270, 190, 20);
		contentPane.add(campo_ModificarDireccion);

		campo_ModificarHostname = new JTextField();
		campo_ModificarHostname.setColumns(10);
		campo_ModificarHostname.setBounds(153, 301, 190, 20);
		contentPane.add(campo_ModificarHostname);

		campo_BuscarDireccion = new JTextField();
		campo_BuscarDireccion.setBounds(153, 107, 190, 20);
		contentPane.add(campo_BuscarDireccion);
		campo_BuscarDireccion.setColumns(10);

		campo_BuscarHostname = new JTextField();
		campo_BuscarHostname.setEnabled(false);
		campo_BuscarHostname.setColumns(10);
		campo_BuscarHostname.setBounds(153, 138, 190, 20);
		contentPane.add(campo_BuscarHostname);
		
		campo_modificarDepartamento = new JTextField();
		campo_modificarDepartamento.setColumns(10);
		campo_modificarDepartamento.setBounds(153, 333, 190, 20);
		contentPane.add(campo_modificarDepartamento);
		setLocationRelativeTo(null);
		
		/*
		 * JButtons
		 */
		
		JButton boton_Volver = new JButton("Volver");
		boton_Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		boton_Volver.setBounds(252, 380, 89, 23);
		contentPane.add(boton_Volver);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				
			}
		});
		btnNewButton.setBounds(252, 180, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton boton_Guardar = new JButton("Guardar");
		boton_Guardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
				Connection conexion = Conexion.ConnectionJDBC();
				
				String direccionIP = campo_BuscarDireccion.getText().toString();
				
														
					String query="UPDATE equipos SET  direccion = ?, nombre = ?, departamento = ? where direccion = '"+ direccionIP +"'";
				
					
					String nombre = campo_ModificarHostname.getText();
					String departamento = campo_modificarDepartamento.getText();
					
			      PreparedStatement preparedStmt = conexion.prepareStatement(query);
				
			      preparedStmt.setString(1, direccionIP);
			      preparedStmt.setString (2, nombre);
			      preparedStmt.setString (3, departamento);	
			      preparedStmt.execute();
			      
			      conexion.close();
			      
			      JOptionPane.showMessageDialog(null, "Modificado correctamente");

				} catch (Exception e1) {
					System.out.println(e1.getMessage());
			     }
			}
		});
		
		boton_Guardar.setBounds(153, 380, 89, 23);
		contentPane.add(boton_Guardar);

	}
}
