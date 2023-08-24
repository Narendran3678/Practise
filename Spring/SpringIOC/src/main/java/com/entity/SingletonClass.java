package com.entity;

@SuppressWarnings("unused")
public class SingletonClass {
	public static SingletonClass singleton = new SingletonClass();
	private SingletonClass() {

	}
	private static SingletonClass getInstance() {
		return singleton;
	}

}
