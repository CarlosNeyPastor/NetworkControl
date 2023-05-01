package interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import inicio.Login;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class MenuPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final Window agregar = null;
	private JPanel contentPane;

	public MenuPrincipal() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("D:\\\\eclipse-workspace\\\\NetworkControl\\\\icons\\\\RJ45.png"));
		setTitle("Network Control");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 527);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JButton boton_Cerrar_sesion = new JButton("Cerrar sesion");
		boton_Cerrar_sesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login login = new Login();
				login.setVisible(true);
			}
		});
		boton_Cerrar_sesion.setBounds(341, 454, 131, 23);
		contentPane.add(boton_Cerrar_sesion);

		JButton boton_Salir = new JButton("Salir");
		boton_Salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		boton_Salir.setBounds(478, 454, 131, 23);
		contentPane.add(boton_Salir);

		JButton boton_Agregar = new JButton("Agregar host");
		boton_Agregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarHost agregar = AgregarHost.getSesionInstance();
				agregar.setVisible(true);
			}
		});
		boton_Agregar.setFont(new Font("Tahoma", Font.BOLD, 11));
		boton_Agregar.setBounds(59, 115, 241, 139);
		contentPane.add(boton_Agregar);

		JButton boton_Consulta = new JButton("Consultar");
		boton_Consulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Consulta consulta = Consulta.getSesionInstance();
				consulta.setVisible(true);

			}
		});
		boton_Consulta.setFont(new Font("Tahoma", Font.BOLD, 11));
		boton_Consulta.setBounds(59, 260, 241, 139);
		contentPane.add(boton_Consulta);

		JButton boton_Modificar = new JButton("Modificar host");
		boton_Modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarHost modificar = ModificarHost.getSesionInstance();
				modificar.setVisible(true);
			}
		});
		boton_Modificar.setFont(new Font("Tahoma", Font.BOLD, 11));
		boton_Modificar.setBounds(312, 115, 241, 139);
		contentPane.add(boton_Modificar);

		JButton boton_Eliminar = new JButton("Eliminar host");
		boton_Eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EliminarHost eliminar = EliminarHost.getSesionInstance();
				eliminar.setVisible(true);
			}
		});
		boton_Eliminar.setFont(new Font("Tahoma", Font.BOLD, 11));
		boton_Eliminar.setBounds(310, 260, 241, 139);
		contentPane.add(boton_Eliminar);

		JLabel etiqueta_Titulo = new JLabel("Men\u00FA principal");
		etiqueta_Titulo.setFont(new Font("Tahoma", Font.BOLD, 30));
		etiqueta_Titulo.setBounds(196, 11, 298, 77);
		contentPane.add(etiqueta_Titulo);
		

	}

}
