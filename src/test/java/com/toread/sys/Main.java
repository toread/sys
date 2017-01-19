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
        DateFormatter date = new DateFormatter("YYYY-MM-DD");
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016,11,0);
        for(int day=0;day<30;day++){
            calendar.add(Calendar.DAY_OF_YEAR,1);
            if(calendar.get(Calendar.DAY_OF_WEEK)!= FRIDAY||calendar.get(Calendar.DAY_OF_WEEK)!= Calendar.SATURDAY){
                System.out.println(date.print(calendar.getTime(), Locale.CHINA));
            }
        }

    }
}
