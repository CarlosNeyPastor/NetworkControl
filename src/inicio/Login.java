package inicio;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;

public class Login extends JFrame {
	/*
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField campo_Usuario;
	private JPasswordField campo_Contrasena;
	/*
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/*
	 */
	
	public Login() { 
		setResizable(false);
		setTitle("Login");
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\\\eclipse-workspace\\\\NetworkControl\\\\icons\\\\RJ45.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 415, 293);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		/*
		 * JLabels
		 */
		
		JLabel etiqueta_Usuario = new JLabel("Usuario:");
		etiqueta_Usuario.setBounds(32, 97, 60, 14);
		contentPane.add(etiqueta_Usuario);
		
		JLabel etiqueta_contrasena = new JLabel("Contrase\u00F1a:");
		etiqueta_contrasena.setBounds(32, 141, 74, 14);
		contentPane.add(etiqueta_contrasena);
		
		JLabel etiqueta_Titulo = new JLabel(	"Network Control");
		etiqueta_Titulo.setFont(new Font("Tahoma", Font.BOLD, 30));
		etiqueta_Titulo.setBounds(65, 11, 312, 60);
		contentPane.add(etiqueta_Titulo);
		
		/*
		 * JTextFields
		 */
		
		campo_Usuario = new JTextField();
		campo_Usuario.setBounds(116, 94, 240, 20);
		contentPane.add(campo_Usuario);
		campo_Usuario.setColumns(10);
		
		campo_Contrasena = new JPasswordField();
		campo_Contrasena.setBounds(116, 138, 240, 20);
		contentPane.add(campo_Contrasena);
		
		/*
		 * JButtons
		 */
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				if (campo_Usuario.getText().equals("") && campo_Contrasena.getText().equals("")) {
					dispose();
					new interfaz.MenuPrincipal().setVisible(true);
				}else{
					 JOptionPane.showMessageDialog(null, "El usuario o contrase�a no son correctos",
						      "Error!", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnAceptar.setBounds(116, 208, 89, 23);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(267, 208, 89, 23);
		contentPane.add(btnCancelar);
	}
}
