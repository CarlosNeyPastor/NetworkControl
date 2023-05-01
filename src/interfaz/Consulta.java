package interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import conexiones.Conexion;

public class Consulta extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField campo_IPLibre;
	private JTextField campo_Direccion;
	private JTextField campo_Hostname;
	private JLabel etiqueta_Direccion;
	private static Consulta ventanaConsulta;
	private JTextField campo_Departamento;

	public static Consulta getSesionInstance() {
		if (ventanaConsulta == null) {
			ventanaConsulta = new Consulta();
		}
		return ventanaConsulta;
	}

	public Consulta() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("D:\\\\eclipse-workspace\\\\NetworkControl\\\\icons\\\\RJ45.png"));
		setTitle("Network Control");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 458, 634);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		/*
		 * JLabels
		 */
		
		JLabel etiqueta_DireccionLibre = new JLabel("Direcci\u00F3n libre:");
		etiqueta_DireccionLibre.setFont(new Font("Tahoma", Font.BOLD, 16));
		etiqueta_DireccionLibre.setBounds(24, 73, 142, 23);
		contentPane.add(etiqueta_DireccionLibre);

		JLabel etiqueta_Buscar = new JLabel("Buscar:");
		etiqueta_Buscar.setFont(new Font("Tahoma", Font.BOLD, 16));
		etiqueta_Buscar.setBounds(24, 148, 118, 23);
		contentPane.add(etiqueta_Buscar);

		JLabel etiqueta_Reporte = new JLabel("Reportes:");
		etiqueta_Reporte.setFont(new Font("Tahoma", Font.BOLD, 16));
		etiqueta_Reporte.setBounds(24, 353, 118, 23);
		contentPane.add(etiqueta_Reporte);
		
		JLabel etiqueta_Hostname = new JLabel("Hostname:");
		etiqueta_Hostname.setBounds(34, 247, 82, 14);
		contentPane.add(etiqueta_Hostname);
		
		JLabel etiqueta_Titulo = new JLabel("Consulta");
		etiqueta_Titulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		etiqueta_Titulo.setBounds(150, 11, 153, 51);
		contentPane.add(etiqueta_Titulo);
		
		JLabel etiqueta_Departamento = new JLabel("Departamento:");
		etiqueta_Departamento.setBounds(34, 293, 108, 14);
		contentPane.add(etiqueta_Departamento);
		

		/*
		 * JTextFields
		 */

		campo_IPLibre = new JTextField();
		campo_IPLibre.setBounds(162, 108, 169, 23);
		contentPane.add(campo_IPLibre);
		campo_IPLibre.setColumns(10);
		campo_IPLibre.setEditable(false);

		campo_Direccion = new JTextField();
		campo_Direccion.setColumns(10);
		campo_Direccion.setBounds(162, 203, 169, 20);
		contentPane.add(campo_Direccion);
		
		campo_Hostname = new JTextField();
		campo_Hostname.setEditable(false);
		campo_Hostname.setColumns(10);
		campo_Hostname.setBounds(162, 247, 169, 20);
		contentPane.add(campo_Hostname);

		etiqueta_Direccion = new JLabel("Direcci\u00F3n:");
		etiqueta_Direccion.setBounds(34, 203, 82, 14);
		contentPane.add(etiqueta_Direccion);

		campo_Departamento = new JTextField();
		campo_Departamento.setEditable(false);
		campo_Departamento.setColumns(10);
		campo_Departamento.setBounds(162, 293, 169, 20);
		contentPane.add(campo_Departamento);
		
		/*
		 * JButtons
		 */
		
		
		JButton boton_ReporteListadoCompleto = new JButton("Listado completo");
		boton_ReporteListadoCompleto.setEnabled(false);
		boton_ReporteListadoCompleto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		boton_ReporteListadoCompleto.setBounds(45, 401, 169, 50);
		contentPane.add(boton_ReporteListadoCompleto);

		JButton boton_ReporteDepartamento = new JButton("Departamentos");
		boton_ReporteDepartamento.setEnabled(false);
		boton_ReporteDepartamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		boton_ReporteDepartamento.setBounds(224, 401, 169, 50);
		contentPane.add(boton_ReporteDepartamento);

		JButton boton_ReporteDireccionesLibres = new JButton("Direcciones libres");
		boton_ReporteDireccionesLibres.setEnabled(false);
		boton_ReporteDireccionesLibres.setBounds(45, 468, 169, 50);
		contentPane.add(boton_ReporteDireccionesLibres);

		JButton boton_ReporteDireccionesEnUso = new JButton("Direcciones en uso");
		boton_ReporteDireccionesEnUso.setEnabled(false);
		boton_ReporteDireccionesEnUso.setBounds(224, 468, 169, 50);
		contentPane.add(boton_ReporteDireccionesEnUso);

		JButton boton_Volver = new JButton("Volver");
		boton_Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		boton_Volver.setBounds(326, 548, 89, 23);
		contentPane.add(boton_Volver);

		JButton boton_Consultar = new JButton("Consultar");
		boton_Consultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					// Boton Consulta
				try {	
					Connection conexion = Conexion.ConnectionJDBC();
					
					// Campo Hostname
					String query = "SELECT nombre FROM networkcontrol.equipos\r\n"
							+ "where direccion = ?;";
					
					String direccion = campo_Direccion.getText();
					
				    PreparedStatement preparedStmtH = conexion.prepareStatement(query);
				    preparedStmtH.setString(1, direccion);
				    ResultSet resultadoNombre =  preparedStmtH.executeQuery();
				    
				    preparedStmtH.getResultSet();
				    
				    String nombre = null;
				    while (resultadoNombre.next()) {
				    		
				    	nombre = resultadoNombre.getString("nombre");
					}
				    
				    if (nombre == null) {
				    		JOptionPane.showMessageDialog(null, "La IP no se encuentra asignada");
				    }else {
					campo_Hostname.setText(nombre);
				    }
				    
					// Campo Departamento
					String queryd = "SELECT departamento FROM networkcontrol.equipos\r\n"
							+ "where direccion = ?;";
					
					PreparedStatement preparedStmtD = conexion.prepareStatement(queryd);
					preparedStmtD.setString(1, direccion);
					preparedStmtD.getResultSet();
				    ResultSet resultadoDepartamento =  preparedStmtD.executeQuery();

				    String departamento = null;
				    while (resultadoDepartamento.next()) {
				    		
				    	departamento = resultadoDepartamento.getString("departamento");
					}
				    
					campo_Departamento.setText(departamento);
					
				    conexion.close();
				    
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
				
				
			
			}
		});
		boton_Consultar.setBounds(337, 333, 92, 23);
		contentPane.add(boton_Consultar);
		setLocationRelativeTo(null);
		
		JButton boton_Usar = new JButton("Usar");
		boton_Usar.setEnabled(false);
		boton_Usar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AsignarIP agregar = AsignarIP.getSesionInstance();
				agregar.setVisible(true);
			}
		});
		boton_Usar.setBounds(340, 107, 89, 23);
		contentPane.add(boton_Usar);
		
		JButton boton_DireccionLibreBuscar = new JButton("Buscar");
		boton_DireccionLibreBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Boton Buscar
				try {
					Connection conexion = Conexion.ConnectionJDBC();
				
					String queryip = "SELECT direccion FROM networkcontrol.equipos\r\n"
							+ "where nombre is null or nombre = '' or nombre = 'empty' limit 1;";
					 
					
				    PreparedStatement preparedStmt = conexion.prepareStatement(queryip);
				    ResultSet resultadoIPLibre =  preparedStmt.executeQuery();
				    
				    String IPLibre = null;
				    while (resultadoIPLibre.next()) {
				    		
				    	IPLibre = resultadoIPLibre.getString("direccion");
					}
				    
				    if (IPLibre == null || IPLibre.isBlank()) {
					    	JOptionPane.showMessageDialog(null, "Todas las direcciones IP registradas fueron asignadas");
					    	boton_Usar.setEnabled(false);
				    }else {
				    
					campo_IPLibre.setText(IPLibre);
					boton_Usar.setEnabled(true);
				    }										
				    conexion.close();
				    
				    
				    
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
			}
		});
		boton_DireccionLibreBuscar.setBounds(45, 108, 82, 23);
		contentPane.add(boton_DireccionLibreBuscar);

		
	}
}
