package com.ziluck.iastate.mis320final.utils;

import java.sql.Date;
import java.util.concurrent.ThreadLocalRandom;

public class DateUtils {
    public static Date randomDayBetween(Date t1, Date t2) {
        return new Date(ThreadLocalRandom.current().nextLong(t1.getTime(), t2.getTime()));
    }
}
