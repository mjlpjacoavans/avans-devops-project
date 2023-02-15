package main.java.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    public static Date getToday(){
        Calendar today = Calendar.getInstance();
        today.clear(Calendar.HOUR); today.clear(Calendar.MINUTE); today.clear(Calendar.SECOND);
        Date date = today.getTime();
        return date;
    }
}
