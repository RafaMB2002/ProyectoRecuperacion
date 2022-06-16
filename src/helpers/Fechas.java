package helpers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Fechas {
	public static LocalDateTime FechaActual() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern( "dd-MM-yyyy");  
		   LocalDateTime ahora = LocalDateTime.now();
		return ahora;
	}
}
