package main;

import accesoADatos.ConexionBD;
import accesoADatos.RepositorioOficina;

public class Main {
	
	

	public static void main(String[] args) {
		
		ConexionBD.abreConexion();
		
		System.out.println(RepositorioOficina.getOficinas());

	}

}
