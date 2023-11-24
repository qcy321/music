package com.mu.util;

import java.util.Calendar;
import java.util.Date;

public class DateFormatUtil {

    public static Date getDate(String time){
        Calendar instance = Calendar.getInstance();
        int year = time.indexOf("年");
        int month = time.indexOf("月");
        instance.set(Integer.valueOf(time.substring(0,year)),Integer.valueOf(time.substring(year+1,month))-1,Integer.valueOf(time.substring(month+1,time.length()-1)));
        return instance.getTime();
    }

    public static Date getDate1(String time){
        Calendar instance = Calendar.getInstance();
        String[] split = time.split("-");
        /*for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }*/
        instance.set(Integer.valueOf(split[0]),Integer.valueOf(split[1])-1,Integer.valueOf(split[2]));
        return instance.getTime();
    }
}
