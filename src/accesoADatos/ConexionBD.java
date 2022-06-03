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
		public static Connection cn;
		
		
		public static void abreConexion() {
			Statement st;
			ResultSet rs;
			if(cn==null) {
				try {
					cn = (Connection) DriverManager.getConnection(URL, usuario, password);
					//JOptionPane.showMessageDialog(null, "Conexion correcta!");
				}catch(Exception ex) {
					System.out.println("Error, "+ex);
				}	
			}
			
		}
		
		
}
