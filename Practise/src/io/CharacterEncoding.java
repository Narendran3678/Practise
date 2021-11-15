package io;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class CharacterEncoding {
	public static void main(String args[])
	{
		characterEncode("a");
	}
	public static void characterEncode(String symbol) 
	{
		try 
		{
			System.out.println(Arrays.toString(symbol.getBytes("US-ASCII")));
			System.out.println(Arrays.toString(symbol.getBytes("ISO-8859-1")));
			System.out.println(Arrays.toString(symbol.getBytes("UTF-8")));
			System.out.println(Arrays.toString(symbol.getBytes("UTF-16")));
			System.out.println(Arrays.toString(symbol.getBytes("UTF-16BE")));//Big Endian
			System.out.println(Arrays.toString(symbol.getBytes("UTF-16LE")));//Log Endian
		} 
		catch (UnsupportedEncodingException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
