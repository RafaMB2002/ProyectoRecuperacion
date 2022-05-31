package clases;

import java.util.Objects;

public class Oficina {
	private int codigo;
	private String nombre;
	private Direccion direccion;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
	public Oficina(int codigo, String nombre, Direccion direccion) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.direccion = direccion;
	}
	
	@Override
	public String toString() {
		return "Oficina [codigo=" + codigo + ", nombre=" + nombre + ", direccion=" + direccion + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(codigo, direccion, nombre);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Oficina other = (Oficina) obj;
		return codigo == other.codigo && Objects.equals(direccion, other.direccion)
				&& Objects.equals(nombre, other.nombre);
	}
	
	
}
