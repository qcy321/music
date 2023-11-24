package com.mu.util;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class MyTimeUtil {

    /**
     * LocalDateTime 转long
     *
     * @param time
     * @return
     */
    public static Long getDateTimeLong(LocalDateTime time) {
        ZoneId zoneId = ZoneId.systemDefault();
        Instant instant = time.atZone(zoneId).toInstant();
        return instant.toEpochMilli();
    }

    /**
     * LocalDate 转 long
     *
     * @param date
     * @return
     */

    public static Long getDateLong(LocalDate date) {
        LocalDateTime dateTime = date.atStartOfDay();
        return getDateTimeLong(dateTime);
    }

    /**
     * LocalTime 转 long
     *
     * @param time
     * @return
     */
    public static Long getTimeLong(LocalTime time) {
        LocalDateTime dateTime = time.atDate(LocalDate.now());
        return getDateTimeLong(dateTime);
    }

    /**
     * long 转 LocalDateTime
     *
     * @param l
     * @return
     */
    public static LocalDateTime dateTimeToLong(long l) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(l), ZoneId.systemDefault());
    }

    /**
     * long 转 LocalDate
     *
     * @param l
     * @return
     */
    public static LocalDate dateToLong(long l) {
        return dateTimeToLong(l).toLocalDate();
    }

    /**
     * long 转 LocalTime
     *
     * @param l
     * @return
     */
    public static LocalTime timeToLong(long l) {
        return dateTimeToLong(l).toLocalTime();
    }

    /**
     * long  转 String
     * LocalDateTime 时间格式  yyyy-MM-dd HH:mm:ss  MM-dd HH:mm:ss  yyyy-MM-dd HH:mm等（日期加时间）
     *
     * @param format
     * @param l
     * @return
     */
    public static String dateTimeToString(DateTimeFormatter format, long l) {
        LocalDateTime time = dateTimeToLong(l);
        return time.format(format);
    }

    /**
     * long  转 String
     * LocalDate 时间格式  yyyy-MM-dd  yyyy-MM  MM-dd等（纯日期）
     *
     * @param formatter 格式  yyyy-MM-dd  yyyy-MM  MM-dd
     * @param l
     * @return
     */
    public static String dateToString(DateTimeFormatter formatter, long l) {
        LocalDate date = dateToLong(l);
        return date.format(formatter);

    }

    /**
     * long  转 String
     * LocalTime 时间格式 HH:mm:ss  HH:mm  mm:ss等（纯时间）
     *
     * @param formatter 时间格式 HH:mm:ss  HH:mm  mm:ss
     * @param l
     * @return
     */
    public static String timeToString(DateTimeFormatter formatter, long l) {
        LocalTime time = timeToLong(l);
        return time.format(formatter);
    }

    /**
     * 获取当前日期
     *
     * @param formatter
     * @return
     */
    public static String getCurrentDate(DateTimeFormatter formatter) {
        return LocalDate.now().format(formatter);
    }

    /**
     * 获取当前时间
     *
     * @param formatter
     * @return
     */
    public static String getCurrentTime(DateTimeFormatter formatter) {
        return LocalTime.now().format(formatter);
    }

    /**
     * 获取当前日期和时间
     *
     * @param formatter
     * @return
     */
    public static String getCurrentDateTime(DateTimeFormatter formatter) {
        return LocalDateTime.now().format(formatter);
    }


    /**
     * 获取当前毫秒值
     *
     * @return
     */
    public static long getCurrentMillLong() {
        return System.currentTimeMillis();
    }

    /**
     * 自定义时间格式 可返回 日期加时间格式
     *
     * @param timeFormat
     * @return
     */
    public static DateTimeFormatter getDateTimeFormat(String timeFormat) {
        return DateTimeFormatter.ofPattern(timeFormat);
    }

    /**
     * 常见日期和时间格式6位
     *
     * @return
     */
    public static DateTimeFormatter getDateTimeFormat6() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 常见日期和时间格式5位
     *
     * @return
     */
    public static DateTimeFormatter getDateTimeFormat5() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    }

    /**
     * 常见日期和时间格式4位
     *
     * @return
     */
    public static DateTimeFormatter getDateTimeFormat4() {
        return DateTimeFormatter.ofPattern("MM-dd HH:mm");
    }

    /**
     * 常见日期格式3位
     *
     * @return
     */
    public static DateTimeFormatter getDateFormat3() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd");
    }

    /**
     * 常见日期格式2位
     *
     * @return
     */
    public static DateTimeFormatter getDateFormat2() {
        return DateTimeFormatter.ofPattern("MM-dd");
    }

    /**
     * 常见时间格式3位
     *
     * @return
     */
    public static DateTimeFormatter getTimeFormat3() {
        return DateTimeFormatter.ofPattern("HH:mm:ss");
    }

    /**
     * 常见时间格式2位
     *
     * @return
     */
    public static DateTimeFormatter getTimeFormat2() {
        return DateTimeFormatter.ofPattern("HH:mm");
    }
}
