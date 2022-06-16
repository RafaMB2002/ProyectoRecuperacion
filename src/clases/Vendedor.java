package clases;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Vendedor extends Empleado{
	private String zona;

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public Vendedor(String dni, String nombre, String ap1, String ap2, String fecha_nac, String tipo_persona, Direccion direccion,
			String fecha_alta, String tipo_empleado, Oficina oficina, String zona) {
		super(dni, nombre, ap1, ap2, fecha_nac, tipo_persona, direccion, fecha_alta, tipo_empleado, oficina);
		this.zona = zona;
	}

	@Override
	public double nomina(int mes) {
		double nomina=0;
		int sueldoPorDia=0;
		final int sueldoBase = 500;
		final int sueldoAntiguedad = antiguedad()*25;
		
		if(mes == 2) {
			sueldoPorDia = 6*28;
		}
		if(mes == 4 || mes == 6 || mes == 9 || mes == 11) {
			sueldoPorDia = 6*30;
		}
		if(mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
			sueldoPorDia = 6*31;
		}
		
		nomina = sueldoBase+sueldoAntiguedad+sueldoPorDia;
		
		return nomina;
	}

	@Override
	public String toString() {
		return this.getDni();
	}

	
	

}
