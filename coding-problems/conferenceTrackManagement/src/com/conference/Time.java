//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.conference;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Time extends GregorianCalendar {
    private final String format = "hh:mma";
    private SimpleDateFormat sdf = new SimpleDateFormat("hh:mma");

    public Time(String timeStr) {
        try {
            Date date = this.sdf.parse(timeStr);
            this.setTime(date);
        } catch (ParseException var4) {
            var4.printStackTrace();
        }

    }

    public Time(Time time) {
        this.setTime(((Time)time.clone()).getTime());
    }

    public Time incrementMinutesBy(int min) {
        this.add(12, min);
        return this;
    }

    public Time incrementHoursBy(int hour) {
        this.add(10, hour);
        return this;
    }

    public String toString() {
        return this.sdf.format(this.getTime());
    }
}
