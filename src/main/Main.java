package main;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import accesoADatos.ConexionBD;
import accesoADatos.RepositorioDireccion;
import accesoADatos.RepositorioOficina;
import accesoADatos.RepositorioProgramador;
import gui.VentanaPrincipal;

public class Main {
	

	public static void main(String[] args) {
		
		ConexionBD.abreConexion();
		VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
		ventanaPrincipal.setVisible(true); 
	
		//RepositorioProgramador.newProgramador("11111111Q", "Juan", "Berdonces", "Cubillas", "11-11-1999", 12, "Empleado", "11-11-1111", 1, "Preogramador", "JAVA#CSS#HTML");
		//System.out.println(RepositorioProgramador.getProgramadores());
		//System.out.println(RepositorioOficina.getOficinas());
		//System.out.println(RepositorioDireccion.getDirecciones());
		
	
		
	
		
		
	
	}
}
