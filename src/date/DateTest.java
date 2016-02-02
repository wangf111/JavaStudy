package date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class DateTest {
	public static void main(String[] args) {
		/*String date = "2010/01/11 00:00:00";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime ym = LocalDateTime.parse(date, formatter);*/
		
		LocalDate today = LocalDate.now();
		System.out.println(today);
		
		String kk = DateTimeFormatter.ISO_DATE.format(today);
		System.out.println(kk);
	}
}
