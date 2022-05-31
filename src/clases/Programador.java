package clases;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Programador extends Empleado{
	private ArrayList tecnologia;

	public ArrayList getTecnologia() {
		return tecnologia;
	}

	public void setTecnologia(ArrayList tecnologia) {
		this.tecnologia = tecnologia;
	}

	public Programador(String dni, String nombre, String ap1, String ap2, Date fecha_nac, Direccion direccion,
			Date fecha_alta, Oficina oficina, ArrayList tecnologia) {
		super(dni, nombre, ap1, ap2, fecha_nac, direccion, fecha_alta, oficina);
		this.tecnologia = tecnologia;
	}
	
	
}
