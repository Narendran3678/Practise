package com.entity;

public class SingletonClass {
	public static SingletonClass singleton = new SingletonClass();
	
	private SingletonClass()
	{
		
	}
	private static SingletonClass getInstance()
	{
		return singleton;
	}
	
}
