package accesoADatos;

import java.util.ArrayList;
import java.util.Collections;

import clases.ComparadorNominas;
import clases.Empleado;

public class RepositorioEmpleado {
	public static ArrayList<Empleado> getEmpleados(){
		ComparadorNominas herramientaComparadora = new ComparadorNominas();
		ArrayList<Empleado> lista = new ArrayList<Empleado>();
		lista.addAll(RepositorioVendedor.getVendedores());
		lista.addAll(RepositorioProgramador.getProgramadores());
		Collections.sort(lista, herramientaComparadora);
		
		return lista;
		
	}
}
