package interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import conexiones.Conexion;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class EliminarHost extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField campo_Direccion;
	private JTextField campo_Hostname;
	private static EliminarHost ventanaEliminarHost;

	public static EliminarHost getSesionInstance() {
		if (ventanaEliminarHost == null) {
			ventanaEliminarHost = new EliminarHost();
		}
		return ventanaEliminarHost;
	}

	public EliminarHost() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("D:\\\\eclipse-workspace\\\\NetworkControl\\\\icons\\\\RJ45.png"));
		setTitle("Network Control");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 411, 205);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		/*
		 * JLabels
		 */
		
		JLabel etiqueta_Titulo = new JLabel("Eliminar Host");
		etiqueta_Titulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		etiqueta_Titulo.setBounds(111, 11, 144, 35);
		contentPane.add(etiqueta_Titulo);
		setLocationRelativeTo(null);
		
		JLabel etiqueta_Direccion = new JLabel("Direcci\u00F3n:");
		etiqueta_Direccion.setBounds(10, 60, 91, 14);
		contentPane.add(etiqueta_Direccion);

		JLabel etiqueta_Hostname = new JLabel("Hostname:");
		etiqueta_Hostname.setBounds(10, 89, 91, 14);
		contentPane.add(etiqueta_Hostname);
		
		/*
		 * JTextFields
		 */

		campo_Direccion = new JTextField();
		campo_Direccion.setBounds(111, 57, 270, 20);
		contentPane.add(campo_Direccion);
		campo_Direccion.setColumns(10);

		campo_Hostname = new JTextField();
		campo_Hostname.setEditable(false);
		campo_Hostname.setColumns(10);
		campo_Hostname.setBounds(111, 86, 270, 20);
		contentPane.add(campo_Hostname);
		
		/*
		 * JButtons
		 */

		JButton boton_Eliminar = new JButton("Eliminar");
		boton_Eliminar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
				Connection conexion = Conexion.ConnectionJDBC();
				
				String direccionIP = campo_Direccion.getText().toString();
				
														
					String query="UPDATE equipos SET  direccion = ?, nombre = ?, departamento = ? where direccion = '"+ direccionIP +"'";
				
					
			      PreparedStatement preparedStmt = conexion.prepareStatement(query);
			      
			    			      
			      preparedStmt.setString(1, direccionIP);
			      	String nombre="empty";
			      preparedStmt.setString(2, nombre);
			      	String departamento="empty";
			      preparedStmt.setString(3, departamento);
			      
			      preparedStmt.execute();
			      
			      conexion.close();
			      
			      JOptionPane.showMessageDialog(null, "Eliminado correctamente");
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
			}
				
		});
						

		boton_Eliminar.setBounds(197, 127, 89, 23);
		contentPane.add(boton_Eliminar);

		JButton boton_Volver = new JButton("Volver");
		boton_Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		boton_Volver.setBounds(292, 127, 89, 23);
		contentPane.add(boton_Volver);


	}
}
