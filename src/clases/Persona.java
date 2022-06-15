package clases;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

import excepciones.ExcepcionDni;
import helpers.Validadores;

public class Persona {
	private String dni;
	private String nombre;
	private String ap1;
	private String ap2;
	private String fecha_nac;
	private String tipo_persona;
	private Direccion direccion;
	
	public String getDni() {
		return dni;
	}
	public void setDni (String dni) throws ExcepcionDni {
		if(Validadores.validaDNI(dni)==true) {
			this.dni = dni;
		}else {
			throw new ExcepcionDni();
		}
		
	}
	public String getNombre() {
		return nombre;
	}
	public String getTipo_persona() {
		return tipo_persona;
	}
	public void setTipo_persona(String tipo_persona) {
		this.tipo_persona = tipo_persona;
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
	public String getFecha_nac() {
		return fecha_nac;
	}
	public void setFecha_nac(String fecha_nac) {
		this.fecha_nac = fecha_nac;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
	
	public Persona(String dni, String nombre, String ap1, String ap2, String fecha_nac, String tipo_persona, Direccion direccion) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.ap1 = ap1;
		this.ap2 = ap2;
		this.fecha_nac = fecha_nac;
		this.tipo_persona = tipo_persona;
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
				+ fecha_nac + ", direccion=" + direccion + "]\n";
	}
	
public String getNombreCompleto() {
		
		return this.getNombre()+" "+this.getAp1()+" "+this.getAp2();
	}
	
	
	
}
