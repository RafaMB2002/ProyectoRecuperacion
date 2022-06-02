package clases;

import java.util.Objects;

public class Direccion {
	private int codigo_direccion;
	private String nombre_via;
	private int num_via;
	private int cod_postal;
	
	//Setter and getters
	
	public String getNombre_via() {
		return nombre_via;
	}
	public int getCodigo_direccion() {
		return codigo_direccion;
	}
	public void setCodigo_direccion(int codigo_direccion) {
		this.codigo_direccion = codigo_direccion;
	}
	public void setNombre_via(String nombre_via) {
		this.nombre_via = nombre_via;
	}
	public int getNum_via() {
		return num_via;
	}
	public void setNum_via(int num_via) {
		this.num_via = num_via;
	}
	public int getCod_postal() {
		return cod_postal;
	}
	public void setCod_postal(int cod_postal) {
		this.cod_postal = cod_postal;
	}
	
	
	//Metodo Constructor
	
	public Direccion(int codigo_direccion, String nombre_via, int num_via, int cod_postal) {
		super();
		this.codigo_direccion = codigo_direccion;
		this.nombre_via = nombre_via;
		this.num_via = num_via;
		this.cod_postal = cod_postal;
	}
	
	//Metodo toString
	
	@Override
	public String toString() {
		return "Direccion [nombre_via=" + nombre_via + ", num_via=" + num_via + ", cod_postal=" + cod_postal + "]\n";
	}
	
	//Metodo eQuals y hashCode
	
	@Override
	public int hashCode() {
		return Objects.hash(cod_postal, nombre_via, num_via);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Direccion other = (Direccion) obj;
		return cod_postal == other.cod_postal && Objects.equals(nombre_via, other.nombre_via)
				&& num_via == other.num_via;
	}
	
	
	
	
	
	
	
}



