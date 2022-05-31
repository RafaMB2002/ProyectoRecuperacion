package clases;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Empleado extends Persona{
	private Date fecha_alta;
	private Oficina oficina;
	
	public Date getFecha_alta() {
		return fecha_alta;
	}
	public void setFecha_alta(Date fecha_alta) {
		this.fecha_alta = fecha_alta;
	}
	public Oficina getOficina() {
		return oficina;
	}
	public void setOficina(Oficina oficina) {
		this.oficina = oficina;
	}
	
	public Empleado(String dni, String nombre, String ap1, String ap2, Date fecha_nac, Direccion direccion,
			Date fecha_alta, Oficina oficina) {
		super(dni, nombre, ap1, ap2, fecha_nac, direccion);
		this.fecha_alta = fecha_alta;
		this.oficina = oficina;
	}
	
	public int antiguedad() {
		int antiguedad=0;
		
		
		
		
		
		return antiguedad;
		
	}
	
	
	
	}
	
	
	

