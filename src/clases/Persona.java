package clases;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

public class Persona{
	private String dni;
	private String nombre;
	private String ap1;
	private String ap2;
	private Calendar fecha_nac;
	private Direccion direccion;
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAp1() {
		return ap1;
	}
	public void setAp1(String ap1) {
		this.ap1 = ap1;
	}
	public String getAp2() {
		return ap2;
	}
	public void setAp2(String ap2) {
		this.ap2 = ap2;
	}
	public Calendar getFecha_nac() {
		return fecha_nac;
	}
	public void setFecha_nac(Calendar fecha_nac) {
		this.fecha_nac = fecha_nac;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	public Persona(String dni, String nombre, String ap1, String ap2, Calendar fecha_nac, Direccion direccion) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.ap1 = ap1;
		this.ap2 = ap2;
		this.fecha_nac = fecha_nac;
		this.direccion = direccion;
	}
	@Override
	public int hashCode() {
		return Objects.hash(ap1, ap2, direccion, dni, fecha_nac, nombre);
	}
	@Override
	public boolean equals(Object obj) {
			if (this == obj)
		return true;
			if (obj == null)
		return false;
			if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(ap1, other.ap1) && Objects.equals(ap2, other.ap2)
			&& Objects.equals(direccion, other.direccion) && Objects.equals(dni, other.dni)
				&& Objects.equals(fecha_nac, other.fecha_nac) && Objects.equals(nombre, other.nombre);
	}
	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombre=" + nombre + ", ap1=" + ap1 + ", ap2=" + ap2 + ", fecha_nac="
				+ fecha_nac + ", direccion=" + direccion + "]";
	}
	
	
	
}
