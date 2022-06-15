package clases;

import java.util.Comparator;

public class ComparadorNominas implements Comparator<Empleado> {

	@Override
	public int compare(Empleado e1, Empleado e2) {
		String s1=e1.getOficina().getNombre();
		String s2=e2.getOficina().getNombre();
		return s1.compareTo(s2);
	}

}
