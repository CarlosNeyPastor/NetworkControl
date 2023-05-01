package interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import conexiones.Conexion;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class AgregarHost extends JFrame {

	/**
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField campo_Direccion;
	private JTextField campo_Hostname;
	private static AgregarHost ventanaAgregarHost;
	private JTextField agregar_Departamento;

	public static AgregarHost getSesionInstance() {
		if (ventanaAgregarHost == null) {
			ventanaAgregarHost = new AgregarHost();
		}
		return ventanaAgregarHost;
	}

	public AgregarHost() {
		setResizable(false);
		setTitle("Network Control");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("D:\\\\eclipse-workspace\\\\NetworkControl\\\\icons\\\\RJ45.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 390, 294);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		/*
		 * JLabels
		 */
		
		JLabel etiquera_Direccion = new JLabel("Direccion:");
		etiquera_Direccion.setBounds(10, 79, 70, 14);
		contentPane.add(etiquera_Direccion);

		JLabel etiqueta_Hostname = new JLabel("Hostname:");
		etiqueta_Hostname.setBounds(10, 119, 70, 14);
		contentPane.add(etiqueta_Hostname);

		JLabel etiqueta_Departamento = new JLabel("Departamento:");
		etiqueta_Departamento.setBounds(10, 163, 88, 14);
		contentPane.add(etiqueta_Departamento);

		JLabel etiqueta_Titulo = new JLabel("Agregar host");
		etiqueta_Titulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		etiqueta_Titulo.setBounds(136, 11, 182, 42);
		contentPane.add(etiqueta_Titulo);
		
		/*
		 * JTextFields
		 */
		
		agregar_Departamento = new JTextField();
		agregar_Departamento.setColumns(10);
		agregar_Departamento.setBounds(108, 160, 231, 20);
		contentPane.add(agregar_Departamento);
		
		campo_Direccion = new JTextField();
		campo_Direccion.setColumns(10);
		campo_Direccion.setBounds(108, 76, 231, 20);
		contentPane.add(campo_Direccion);

		campo_Hostname = new JTextField();
		campo_Hostname.setColumns(10);
		campo_Hostname.setBounds(108, 116, 231, 20);
		contentPane.add(campo_Hostname);
		
		/*
		 * JButtons 
		 */

		JButton boton_Volver = new JButton("Volver");
		boton_Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		boton_Volver.setBounds(250, 212, 89, 23);
		contentPane.add(boton_Volver);
		
		final JButton boton_Guardar = new JButton("Guardar");
		boton_Guardar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
				Connection conexion = Conexion.ConnectionJDBC();
				
						String query = " insert into equipos (direccion, nombre, departamento)"
				        + " values (?, ?, ?)";
				
					
				  String direccion = campo_Direccion.getText();
				  String nombre = campo_Hostname.getText();
				  String departamento = agregar_Departamento.getText();

				
			      PreparedStatement preparedStmt = conexion.prepareStatement(query);
				  preparedStmt.setString  (1, direccion);
			      preparedStmt.setString (2, nombre);
			      preparedStmt.setString (3, departamento);		
			      
			      preparedStmt.execute();
				
				conexion.close();
								
				JOptionPane.showMessageDialog(null, "Agregado correctamente");
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
			}
				
		});
		boton_Guardar.setBounds(150, 212, 89, 23);
		contentPane.add(boton_Guardar);
		

	}
}
