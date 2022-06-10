package helpers;

import java.util.ArrayList;
import java.util.Scanner;

public class Validadores {

	Scanner lector = new Scanner(System.in);

	public static boolean validaDNI(String dni) {

		int numeros;
		int resto;
		String letra;
		String cadenaNumeros;
		//String dniSinEspacios;
		boolean esValido = false;

		ArrayList<String> numDNI = new ArrayList<String>();

		numDNI.add("T");
		numDNI.add("R");
		numDNI.add("W");
		numDNI.add("A");
		numDNI.add("G");
		numDNI.add("M");
		numDNI.add("Y");
		numDNI.add("F");
		numDNI.add("P");
		numDNI.add("D");
		numDNI.add("X");
		numDNI.add("B");
		numDNI.add("N");
		numDNI.add("J");
		numDNI.add("Z");
		numDNI.add("S");
		numDNI.add("Q");
		numDNI.add("V");
		numDNI.add("H");
		numDNI.add("L");
		numDNI.add("C");
		numDNI.add("K");

		if (!dni.equals("")) {

			//dniSinEspacios = dni.replace(" ", "");
			cadenaNumeros = dni.substring(0, dni.length() - 1);
			numeros = Integer.parseInt(cadenaNumeros);
			letra = dni.substring(dni.length() - 1);

			resto = numeros % 23;

			if (numDNI.get(resto).equals(letra.toUpperCase())) {
				esValido = true;
			}
		}

		return esValido;
	}

}
