package helpers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Converters {
	public static Calendar StringACalendar(String fecha) throws ParseException {
		Calendar cal = new GregorianCalendar();
		int year, month, day;
		year = Integer.parseInt(fecha.substring(0, fecha.indexOf("-")));
		month = Integer.parseInt(fecha.substring(5,7));
		day = Integer.parseInt(fecha.substring(8));
		
		cal.set(year, month-1, day);
		return cal;
	}
	
	public static String JChooserCalendarAString(Date fecha) {
		String fech = String.format("%1$td/%1$tm/%1$tY", fecha);
		return fech;
	}
	
	public static Date StringADate(String fecha) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-YYYY");
		Date date = null;
		try {
			date = formatter.parse(fecha);
		}catch(ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

}
