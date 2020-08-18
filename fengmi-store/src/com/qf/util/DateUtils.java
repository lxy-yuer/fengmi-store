package com.qf.util;


import java.text.SimpleDateFormat;

public class DateUtils {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static java.sql.Date toSqlDate(java.util.Date date) {
        return new java.sql.Date(date.getTime());
    }

    public static java.util.Date toUtilDate(java.sql.Date date) {
        return new java.util.Date(date.getTime());
    }

    public static String toStringDate(java.util.Date date) {
        return sdf.format(date);
    }

    public static String toStringDate(java.sql.Date date) {
        return sdf.format(date);
    }
}
