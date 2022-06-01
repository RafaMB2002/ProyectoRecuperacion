package clases;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Programador extends Empleado{
	private ArrayList tecnologia;

	public ArrayList getTecnologia() {
		return tecnologia;
	}

	public void setTecnologia(ArrayList tecnologia) {
		this.tecnologia = tecnologia;
	}

	public Programador(String dni, String nombre, String ap1, String ap2, Date fecha_nac, Direccion direccion,
			Date fecha_alta, Oficina oficina, ArrayList tecnologia) {
		super(dni, nombre, ap1, ap2, fecha_nac, direccion, fecha_alta, oficina);
		this.tecnologia = tecnologia;
	}

	@Override
	public double nomina(int mes) {
		double nomina=0;
		int sueldoPorDia=0;
		int sueldoPorTecnologia=0;
		final int sueldoBase = 500;
		final int sueldoAntiguedad = antiguedad()*25;
		
		if(mes == 2) {
			sueldoPorDia = 5*28;
		}
		if(mes == 4 || mes == 6 || mes == 9 || mes == 11) {
			sueldoPorDia = 5*30;
		}
		if(mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
			sueldoPorDia = 5*31;
		}
		sueldoPorTecnologia = tecnologia.size()*20;
		nomina = sueldoBase+sueldoAntiguedad+sueldoPorDia+sueldoPorTecnologia;
		
		return nomina;
	}
	
	
}
