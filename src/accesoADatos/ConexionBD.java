package accesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class ConexionBD {
	//Declaracion de atributos
		public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
		public static final String usuario = "System";
		public static final String password = "1477";
		private static Connection conexion=null;
		Statement st;
		ResultSet rs;
		/**
		 * Metodo para conectar a base de datos
		 * @return devuelve la conexion
		 */
		public Connection getConnection() {
			if(conexion==null) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					conexion = (Connection) DriverManager.getConnection(URL, usuario, password);
					//JOptionPane.showMessageDialog(null, "Conexion correcta!");
				}catch(Exception ex) {
					System.out.println("Error, "+ex);
				}	
			}
			
			return conexion;
		}
}
