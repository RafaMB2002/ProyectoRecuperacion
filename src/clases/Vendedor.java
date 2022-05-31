package clases;

import java.util.Calendar;

public class Vendedor extends Empleado{
	private String zona;

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public Vendedor(String dni, String nombre, String ap1, String ap2, Calendar fecha_nac, Direccion direccion,
			Calendar fecha_alta, Oficina oficina, String zona) {
		super(dni, nombre, ap1, ap2, fecha_nac, direccion, fecha_alta, oficina);
		this.zona = zona;
	}

}
