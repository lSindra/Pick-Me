package com.sap.pickme.services.utils;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;

public class Utils {

    private final static String TIME_SERVER = "time-a.nist.gov";

    public static Date getCurrentTime() {
        return java.sql.Timestamp.valueOf(LocalDateTime.now());
    }

    public static Date getEndOfDay() {
        Date time = getCurrentTime();
        return DateUtils.addMilliseconds(DateUtils.ceiling(time, Calendar.DATE), -1000 );
    }
}