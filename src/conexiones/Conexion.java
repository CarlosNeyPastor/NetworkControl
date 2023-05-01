package conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Conexion {

	private static Connection connection_;

	public static Connection ConnectionJDBC() {
		try {
			connection_ = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/networkcontrol?user=root&password=");

			if (connection_ != null) {
				//System.out.println(" Conexion a base de datos correcta.");
			} else
				System.out.println(" Conexion fallida.");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection_;

	}

	
	   public static void main(String[] args) { ConnectionJDBC(); }


	public PreparedStatement prepareStatement(String query) {
		// TODO Auto-generated method stub
		return null;
	}
	  
}
