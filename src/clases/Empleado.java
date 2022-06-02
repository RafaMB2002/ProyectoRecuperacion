package clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public abstract class Empleado extends Persona{
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
	
	public Empleado(String dni, String nombre, String ap1, String ap2, Date fecha_nac, ArrayList<Direccion> direccion,
			Date fecha_alta, Oficina oficina) {
		super(dni, nombre, ap1, ap2, fecha_nac, direccion);
		this.fecha_alta = fecha_alta;
		this.oficina = oficina;
	}
	
	public int antiguedad() {
		int antiguedad=0;
		Calendar fecha = new GregorianCalendar();
		Date fechaActual = fecha.getTime();
		
		Calendar a = getCalendar(this.getFecha_alta());
		Calendar b = getCalendar(fechaActual);
		
		antiguedad = b.get(Calendar.YEAR) - a.get(Calendar.YEAR);
		
		if (a.get(Calendar.MONTH) > b.get(Calendar.MONTH) ||
	            (a.get(Calendar.MONTH) == b.get(Calendar.MONTH) &&   
	            a.get(Calendar.DATE) > b.get(Calendar.DATE))) {
	            antiguedad--;
	        }
		
		return antiguedad;
		
	}
	
	public static Calendar getCalendar(Date date) {
        Calendar cal = Calendar.getInstance(Locale.US);
        cal.setTime(date);
        return cal;
    }
	
	public abstract double nomina(int mes);
	
	}
	
	
	

