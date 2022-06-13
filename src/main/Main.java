package main;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import accesoADatos.ConexionBD;
import accesoADatos.RepositorioDireccion;
import accesoADatos.RepositorioOficina;
import accesoADatos.RepositorioProgramador;
import accesoADatos.RepositorioVendedor;
import clases.Direccion;
import clases.Empleado;
import clases.Oficina;
import clases.Programador;
import clases.Vendedor;
import gui.VentanaPrincipal;

public class Main {
	

	public static void main(String[] args) {
		
		ConexionBD.abreConexion();
		VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
		ventanaPrincipal.setVisible(true); 
//		try {
//			Calendar cal = helpers.Converters.StringACalendar("2002-02-23");
//			System.out.println(cal);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
//		Empleado e = RepositorioVendedor.getVendedor("54593460Q");
//		double nom = e.nomina(4);
	//	System.out.println(nom);
		
		//System.out.println(v.getFecha_nac());
		
	//	RepositorioVendedor.newVendedor(new Vendedor("78682588W", "Manuela", "Berdonces", "Cubillas", "23-02-2002", "Empleado", RepositorioDireccion.getDireccion(12),
	//		"23-02-2015", "Vendedor", RepositorioOficina.getOficina(1), "Barrio alto"));
		
	//	RepositorioVendedor.updateVendedor(new Vendedor("78682588W", "Manuela", "Berdonces", "Cubillas", "08-04-1975", "Empleado", RepositorioDireccion.getDireccion(12),
	//		"23-02-2015", "Vendedor", RepositorioOficina.getOficina(1), "Barrio bajo"));

	}
}
