package com.toread.sys;

import org.springframework.format.datetime.DateFormatter;

import java.util.Calendar;
import java.util.Locale;

import static java.util.Calendar.FRIDAY;

/**
 * @author 黎志兵
 */
public class Main {
    public static void main(String[] args) {
        DateFormatter date = new DateFormatter("YYYY-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.set(2017, 1, 0);
        for (int day = 0; day < 35; day++) {
            if (!(calendar.get(Calendar.DAY_OF_WEEK) == FRIDAY
                    || calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
                    || calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)) {
                System.out.println(date.print(calendar.getTime(), Locale.CHINA));
            }
            calendar.add(Calendar.DAY_OF_YEAR, 1);
        }

    }
}
