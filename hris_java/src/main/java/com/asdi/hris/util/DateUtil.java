package com.asdi.hris.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateUtil {

	public DateUtil() {
		// TODO Auto-generated constructor stub
	}

	public static String getDateToday() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		df.setTimeZone(TimeZone.getTimeZone("Asia/Manila"));
		Date date = new Date();

		return df.format(date.getTime());
	}

	public static String reformatDate(String date) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		df.setTimeZone(TimeZone.getTimeZone("Asia/Manila"));
		Date dt = df.parse(date);
		return new SimpleDateFormat("yyyy-MM-dd").format(dt);
	}
}
