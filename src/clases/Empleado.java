package clases;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Empleado extends Persona{
	private Calendar fecha_alta;
	private Oficina oficina;
	public Calendar getFecha_alta() {
		return fecha_alta;
	}
	public void setFecha_alta(Calendar fecha_alta) {
		this.fecha_alta = fecha_alta;
	}
	public Oficina getOficina() {
		return oficina;
	}
	public void setOficina(Oficina oficina) {
		this.oficina = oficina;
	}
	
	public Empleado(String dni, String nombre, String ap1, String ap2, Calendar fecha_nac, Direccion direccion,
			Calendar fecha_alta, Oficina oficina) {
		super(dni, nombre, ap1, ap2, fecha_nac, direccion);
		this.fecha_alta = fecha_alta;
		this.oficina = oficina;
	}
	
	
	
}
