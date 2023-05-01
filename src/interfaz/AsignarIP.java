package interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import conexiones.Conexion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class AsignarIP extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static AsignarIP ventantaUsarIP;
	private JTextField campo_Direccion;
	private JTextField campo_Hostname;
	private JTextField campo_Departamento;
	
	public static AsignarIP getSesionInstance() {
		if (ventantaUsarIP == null) {
			ventantaUsarIP = new AsignarIP();
		}
		return ventantaUsarIP;
	}
	
	/**
	 * Create the frame.
	 */
	public AsignarIP() {
		setTitle("Network Control");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 409, 257);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel etiqueta_Titulo = new JLabel("Asignar IP");
		etiqueta_Titulo.setFont(new Font("Dialog", Font.BOLD, 20));
		etiqueta_Titulo.setBounds(144, 0, 182, 42);
		contentPane.add(etiqueta_Titulo);
		
		JLabel etiqueta_Direccion = new JLabel("Direccion:");
		etiqueta_Direccion.setBounds(12, 65, 97, 17);
		contentPane.add(etiqueta_Direccion);
		
		JLabel etiqueta_Hostname = new JLabel("Hostname:");
		etiqueta_Hostname.setBounds(12, 101, 97, 17);
		contentPane.add(etiqueta_Hostname);
		
		JLabel etiqueta_Departamento = new JLabel("Departamento:");
		etiqueta_Departamento.setBounds(12, 142, 97, 17);
		contentPane.add(etiqueta_Departamento);
		
		campo_Direccion = new JTextField();
		campo_Direccion.setBounds(144, 63, 237, 21);
		contentPane.add(campo_Direccion);
		campo_Direccion.setColumns(10);
		
		campo_Hostname = new JTextField();
		campo_Hostname.setColumns(10);
		campo_Hostname.setBounds(144, 97, 237, 21);
		contentPane.add(campo_Hostname);
		
		campo_Departamento = new JTextField();
		campo_Departamento.setColumns(10);
		campo_Departamento.setBounds(144, 130, 237, 21);
		contentPane.add(campo_Departamento);
		setLocationRelativeTo(null);
		
		JButton boton_Guardar = new JButton("Guardar");
		boton_Guardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conexion = Conexion.ConnectionJDBC();
					
					String direccionIP = campo_Direccion.getText().toString();
					
															
						String query="UPDATE equipos SET  direccion = ?, nombre = ?, departamento = ? where direccion = '"+ direccionIP +"'";
					
						
						String nombre = campo_Hostname.getText();
						String departamento = campo_Departamento.getText();
						
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
		boton_Guardar.setBounds(144, 173, 105, 27);
		contentPane.add(boton_Guardar);
		
		JButton boton_Cerrar = new JButton("Cerrar");
		boton_Cerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		boton_Cerrar.setBounds(276, 173, 105, 27);
		contentPane.add(boton_Cerrar);
		

	}
}
