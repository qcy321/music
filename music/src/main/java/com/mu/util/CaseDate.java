package com.mu.util;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CaseDate {

    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(date));
        System.out.println(date.getTime());

        Calendar instance = Calendar.getInstance();
        instance.set(2014,7,23,0,0,0);
        System.out.println(instance.getTime());
        System.out.println(instance.getTimeInMillis());

        date.setTime(1408723200046L);
        System.out.println(simpleDateFormat.format(date));
    }

}
class ss{
    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY年MM月dd日");
        String a = "1999年4月15";

        /*instance.set();
        Calendar instance = Calendar.getInstance();
        instance.set
        System.out.println();*/
    }
}
