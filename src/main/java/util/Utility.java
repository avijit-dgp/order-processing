package util;

import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import model.Currency;

public abstract class Utility {
	
	public static Date getBusinessDay(Date actualDate, Currency currency) {
		Calendar calendar= Calendar.getInstance(Locale.US);
		calendar.setTime(actualDate);
		while(currency.getHodayList().contains(DayOfWeek.of(calendar.get(Calendar.DAY_OF_WEEK)).minus(1))) {
			calendar.add(Calendar.DAY_OF_YEAR, 1);
		}
		return calendar.getTime();
	}

}
