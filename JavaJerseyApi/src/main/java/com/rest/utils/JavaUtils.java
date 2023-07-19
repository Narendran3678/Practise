package com.rest.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class JavaUtils {
	private static JavaUtils javaUtils = new JavaUtils();
	private JavaUtils(){}
	public static JavaUtils getInstance()
	{
		return javaUtils;
	}
	public LocalDateTime convertToLocalDateTime(Date date)
	{
		LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
		return localDateTime;
	}
	public static void main(String args[])
	{
		System.out.println(JavaUtils.getInstance().convertToLocalDateTime(new Date()));
	}
}
