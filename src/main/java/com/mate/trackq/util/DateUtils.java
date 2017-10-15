package com.mate.trackq.util;

import java.sql.Timestamp;
import java.util.Calendar;

public class DateUtils {

    public static Timestamp addDay(Timestamp timestamp) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(timestamp);
        cal.add(Calendar.DAY_OF_WEEK, 1);
        timestamp.setTime(cal.getTime().getTime());
        return timestamp;
    }
}
