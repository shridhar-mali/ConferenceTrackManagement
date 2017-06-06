package com.conference;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Time extends GregorianCalendar {

	private final String format = "hh:mma";
	private SimpleDateFormat sdf = new SimpleDateFormat(format);

	public Time(String timeStr) {

		Date date;
		try {
			date = sdf.parse(timeStr);
			setTime(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	public Time(Time time) {
		this.setTime(((Time) time.clone()).getTime());
	}

	public Time incrementMinutesBy(int min) {
		this.add(Calendar.MINUTE, min);
		return this;
	}

	public Time incrementHoursBy(int hour) {
		this.add(Calendar.HOUR, hour);
		return this;
	}

	@Override
	public String toString() {
		return sdf.format(getTime());
	}
}
