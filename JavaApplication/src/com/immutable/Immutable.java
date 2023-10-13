package com.immutable;

final class StringClass {
	private final String str ;
	public StringClass(String str)
	{
		this.str=str;
	}
	
	public String getString()
	{
		return str;
	}
}
public class Immutable {
	public static void main(String args[])
	{
		StringClass sc = new StringClass("23");
		System.out.println(sc.getString());
	}
}
