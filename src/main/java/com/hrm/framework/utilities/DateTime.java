package com.hrm.framework.utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTime {

	public static String getCurrentDateTime() {
		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedDateTime = currentDateTime.format(formatter);
		return formattedDateTime;
	}

	public static String getCurrentDateTime(String dateTimeFormat) {
		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimeFormat);
		String formattedDateTime = currentDateTime.format(formatter);
		return formattedDateTime;
	}
}
