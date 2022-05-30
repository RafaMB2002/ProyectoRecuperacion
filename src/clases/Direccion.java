package clases;

public class Direccion {
	private String nombre_via;
	private int num_via;
	private int cod_postal;
	
	//Setter and getters
	
	public String getNombre_via() {
		return nombre_via;
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
	
	public Direccion(String nombre_via, int num_via, int cod_postal) {
		super();
		this.nombre_via = nombre_via;
		this.num_via = num_via;
		this.cod_postal = cod_postal;
	}
	
	//Metodo toString
	
	@Override
	public String toString() {
		return "Direccion [nombre_via=" + nombre_via + ", num_via=" + num_via + ", cod_postal=" + cod_postal + "]";
	}
	
	
	
	
	
}



