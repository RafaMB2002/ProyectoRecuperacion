package clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public abstract class Empleado extends Persona{
	private String fecha_alta;
	private String tipo_empleado;
	private Oficina oficina;
	
	public String getFecha_alta() {
		return fecha_alta;
	}
	public String getTipo_empleado() {
		return tipo_empleado;
	}
	public void setTipo_empleado(String tipo_empleado) {
		this.tipo_empleado = tipo_empleado;
	}
	public void setFecha_alta(String fecha_alta) {
		this.fecha_alta = fecha_alta;
	}
	public Oficina getOficina() {
		return oficina;
	}
	public void setOficina(Oficina oficina) {
		this.oficina = oficina;
	}
	@Override
	public String toString() {
		return "Empleado [fecha_alta=" + fecha_alta + ", oficina=" + oficina + "]";
	}
	public Empleado(String dni, String nombre, String ap1, String ap2, String fecha_nac, String tipo_persona, Direccion direccion,
			String fecha_alta, String tipo_empleado, Oficina oficina) {
		super(dni, nombre, ap1, ap2, fecha_nac, tipo_persona, direccion);
		this.fecha_alta = fecha_alta;
		this.tipo_empleado = tipo_empleado;
		this.oficina = oficina;
	}
	
	public int antiguedad() {
		Date fecha1 = Date.valueOf(this.getFecha_alta());
		int antiguedad=0;
		Calendar fecha = new GregorianCalendar();
		
		
		
		Calendar a = getCalendar(fecha1);
		Calendar b = helpers.Converters.toCalendar(fecha.getTime());
		
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
	
	
	

