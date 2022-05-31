package clases;

import java.util.ArrayList;
import java.util.Calendar;

public class Programador extends Empleado{
	private ArrayList tecnologia;

	public ArrayList getTecnologia() {
		return tecnologia;
	}

	public void setTecnologia(ArrayList tecnologia) {
		this.tecnologia = tecnologia;
	}

	public Programador(String dni, String nombre, String ap1, String ap2, Calendar fecha_nac, Direccion direccion,
			Calendar fecha_alta, Oficina oficina, ArrayList tecnologia) {
		super(dni, nombre, ap1, ap2, fecha_nac, direccion, fecha_alta, oficina);
		this.tecnologia = tecnologia;
	}
	
	
}
