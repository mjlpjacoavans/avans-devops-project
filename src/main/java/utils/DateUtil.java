package utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {
    public static boolean dateIsAfterToday(Date inputDate) {
        int startDateYear = inputDate.getYear();
        int startDateMonth = inputDate.getMonth();
        int startDateDay = inputDate.getDay();
        int startDateHour = inputDate.getHours();
        int startDateMinute = inputDate.getMinutes();
        int startDateSecond = inputDate.getSeconds();

        Date today = new Date();
        Calendar calendar2 = new GregorianCalendar();
        calendar2.setTime(today);
        int todayYear = calendar2.get(Calendar.YEAR);
        int todayMonth = calendar2.get(Calendar.MONTH) + 1;
        int todayDay = calendar2.get(Calendar.DAY_OF_MONTH);
        int todayHour = calendar2.get(Calendar.HOUR);
        int todayMinute = calendar2.get(Calendar.MINUTE);
        int todaySecond = calendar2.get(Calendar.SECOND);


        boolean yearPassed = startDateYear < todayYear;
        boolean monthPassed = startDateYear == todayYear && startDateMonth < todayMonth;
        boolean dayPassed = startDateYear == todayYear && startDateMonth == todayMonth && startDateDay < todayDay;
        boolean hourPassed = startDateYear == todayYear && startDateMonth == todayMonth && startDateDay == todayDay && startDateHour < todayHour;
        boolean minutePassed = startDateYear == todayYear && startDateMonth == todayMonth && startDateDay == todayDay && startDateHour == todayHour && startDateMinute < todayMinute;
        boolean secondPassed = startDateYear == todayYear && startDateMonth == todayMonth && startDateDay == todayDay && startDateHour == todayHour && startDateMinute == todayMinute && startDateSecond < todaySecond;

        return (yearPassed || monthPassed || dayPassed || hourPassed || minutePassed || secondPassed);
    }
}
