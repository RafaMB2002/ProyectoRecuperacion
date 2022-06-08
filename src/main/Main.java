package main;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import accesoADatos.ConexionBD;
import accesoADatos.RepositorioDireccion;
import accesoADatos.RepositorioOficina;
import accesoADatos.RepositorioProgramador;
import accesoADatos.RepositorioVendedor;
import clases.Direccion;
import clases.Oficina;
import clases.Programador;
import clases.Vendedor;
import gui.VentanaPrincipal;

public class Main {
	

	public static void main(String[] args) {
		
		ConexionBD.abreConexion();
		VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
		ventanaPrincipal.setVisible(true); 

	}
}
