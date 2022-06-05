package main;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import accesoADatos.ConexionBD;
import accesoADatos.RepositorioOficina;
import accesoADatos.RepositorioProgramador;

public class Main {
	

	public static void main(String[] args) {
		
		ConexionBD.abreConexion();
	
	
		
		RepositorioProgramador.newProgramador("54593460Q", "Rafael", "Montoro", "Berdonces", "23-02-2002", 12,
				"Empleado", "23-02-2015", 12, "Programador", "HTML#CSS#JAVA");
		
	
		
		
	
	}
}
