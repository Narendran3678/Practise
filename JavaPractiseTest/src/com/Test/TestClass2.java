package com.Test;

import java.util.Iterator;
import java.util.function.Predicate;
import java.time.LocalDate;
import java.util.*;

class Employee {
	private String name;
	private int age;
	private double salary;

	public Employee(String name, int age, double salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public double getSalary() {
		return salary;
	}

	public String toString() {
		return name;
	}
}

abstract class Helper {
	int num = 100;
	String operation = null;

	protected abstract void help();

	void log() {
		System.out.println("Helper-log");
	}
}

class LogHelper extends Helper {
	private int num = 200;
	protected String operation = "LOGGING";

	public void help() {
		System.out.println("LogHelper-help");
	}

	void log() {
		System.out.println("LogHelper-log");
	}

}

public class TestClass2 {

	private int num = 200;
	protected String operation = "LOGGING";

	public static void main(String[] args) {
		TestClass2 tc = new TestClass2();
		// new LogHelper().help();
		// System.out.println(new LogHelper().operation);
		m1(null);
		tc.test6();
	}
	public void test6()
	{
		LocalDate d1 = LocalDate.parse("1999-09-09");
        LocalDate d2 = LocalDate.parse("1999-09-09");
        LocalDate d3 = LocalDate.of(1999, 9, 9);
        LocalDate d4 = LocalDate.of(1999, 9, 9);
        
        System.out.println(d1.equals(d2) + ":" + d2.equals(d3) + ":" + d3.equals(d4));
        System.out.println((d1 == d2) + ":" + (d2 == d3) + ":" + (d3 == d4));
	}
	static void m1(CharSequence s) {
		System.out.println("CharSequence");
	}
	static void m1(Object s) {
		System.out.println("Object");
	}
	static void m1(String s) {
		System.out.println("String");
	}
	
	public void test5() {
		Boolean b1 = new Boolean("tRuE");
		Boolean b2 = new Boolean("fAlSe");
		Boolean b3 = new Boolean("abc");
		Boolean b4 = null;
		System.out.println(b1 + ":" + b2 + ":" + b3 + ":" + b4);
	}

	public void test4() {
		List<Integer> list = new ArrayList<>();
		list.add(100);
		list.add(200);
		list.add(100);
		list.add(200);
		list.remove(new Integer(100));

		System.out.println(list);
	}

	public void test3() {
		List<String> list = new ArrayList<>();
		list.add("ONE");
		list.add("TWO");
		list.add("THREE");
		list.add("THREE");

		if (list.remove(2).length() > 1) {
			list.remove("THREE");
		}

		System.out.println(list);
	}

	public void test2() {
		// long var=10; //Failed
		int var = 10;
		// byte var=10;
		// short var=10;
		// char var=10;
		// double var=10; //Failed
		// float var=10; // Failed
		switch (var) {
		case 10:
			System.out.println("TEN");
			break;
		default:
			System.out.println("DEFAULT");
		}
	}

	public void test1() {
		List<Employee> list = new ArrayList<>();
		list.add(new Employee("James", 25, 15000));
		list.add(new Employee("Lucy", 23, 12000));
		list.add(new Employee("Bill", 27, 10000));
		list.add(new Employee("Jack", 19, 5000));
		list.add(new Employee("Liya", 20, 8000));

		process(list, e -> e.getAge() > 20);
	}

	private static void process(List<Employee> list, Predicate<Employee> predicate) {
		Iterator<Employee> iterator = list.iterator();
		while (iterator.hasNext()) {
			Employee e = iterator.next();
			if (predicate.test(e))
				System.out.print(e + " ");
		}
	}
}
