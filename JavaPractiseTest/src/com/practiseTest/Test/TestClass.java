package com.practiseTest.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.function.Predicate;
import java.util.*;
abstract class Super {
	public abstract void m1() throws IOException;
}

class Sub extends Super {
	@Override
	public void m1() throws IOException {
		throw new FileNotFoundException();
	}
}

class SpecialString {
	String str;

	SpecialString(String str) {
		this.str = str;
	}
}

class Student {
	String name;
	int marks;

	Student(String name, int marks) {
		this.name = name;
		this.marks = marks;
	}
}

class Point {
	int x;
	int y;

	void assign(int x, int y) {
		x = this.x;
		this.y = y;
	}

	public String toString() {
		return "Point(" + x + ", " + y + ")";
	}
}

public class TestClass extends ClassA {
	char var1;
	double var2;
	float var3;

	// public static void main(String[] args) {
	static public void main(String[] args) {
		new TestClass().test17();
	}
	public void test17()
	{
		String str="ICICINBBRT4";
		System.out.println(str.substring(0,4));
		System.out.println(str.substring(4,6));
		System.out.println(str.substring(4,6));
		System.out.println(str.substring(6,9));
		System.out.println(str.substring(9,11));
	}
	public void test16()
	{
		List<LocalDate> dates = new ArrayList<>();
        dates.add(LocalDate.parse("2018-07-11"));
        dates.add(LocalDate.parse("1919-02-25"));
        dates.add(LocalDate.of(2020, 4, 8));
        dates.add(LocalDate.of(1980, Month.DECEMBER, 31));
        dates.forEach(System.out::println);
        dates.removeIf(x -> x.getYear() < 2000);

        System.out.println(dates);
	}
	public void test15() {
		String fruit = "mango";
		switch (fruit) {
		default:
			System.out.println("ANY FRUIT WILL DO");
		case "Apple":
			System.out.println("APPLE");
		case "Mango":
			System.out.println("MANGO");
		case "Banana":
			System.out.println("BANANA");
			break;
		}
	}

	public void test14() {
		StringBuilder sb = new StringBuilder("Java");
		String s1 = sb.toString();
		String s2 = sb.toString();

		System.out.println(s1 == s2);

		String[] arr = { "I", "N", "S", "E", "R", "T" };
		// for(int n = 0; n <= arr.length; n += 1)
		// for(int n = 1; n < arr.length; n += 2)
		// for(int n = 1; n <= arr.length; n += 2)
		for (int n = 0; n < arr.length; n += 1) {
			if (n % 2 == 0) {
				continue;
			}
			System.out.print(arr[n]); // Line n1
		}
	}

	public void test13() {
		LocalDate newYear = LocalDate.of(2018, 1, 1);
		LocalDate christmas = LocalDate.of(2018, 12, 25);
		boolean flag1 = newYear.isAfter(christmas);
		boolean flag2 = newYear.isBefore(christmas);
		System.out.println(flag1 + ":" + flag2);

		LocalDateTime obj = LocalDateTime.now();
		System.out.println(obj);
	}

	public void test12() {
		Point p1 = new Point();
		p1.x = 10;
		p1.y = 20;
		Point p2 = new Point();
		p2.assign(p1.x, p1.y);
		System.out.println(p1.toString() + ";" + p2.toString());
	}

	public void test11() {
		TestClass obj = new TestClass();
		System.out.println(">" + obj.var1);
		System.out.println(">" + obj.var2);
		System.out.println(">" + obj.var3);
	}

	public void test10() {
		LocalDate date = LocalDate.of(2012, 1, 11);
		Period period = Period.ofMonths(2);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yy");
		System.out.print(formatter.format(date.minus(period)));
	}

	public void test9() {
		Student student = new Student("James", 25);
		int marks = 25;
		review(student, marks);
		System.out.println(marks + "-" + student.marks);
	}

	public void test8() {
		String[] arr = { "A", "ab", "bab", "Aa", "bb", "baba", "aba", "Abab" };

		Predicate<String> p = s -> s.toUpperCase().substring(0, 1).equals("A");

		processStringArray(arr, p);
	}

	public void test7() {
		int x = 1;
		while (checkAndIncrement(x)) {
			System.out.println(x);
		}
	}

	public void test4() {
		Period period = Period.of(1996, 8, 21);
		Period period1 = Period.of(2023, 4, 19);
		System.out.println(period1.minus(period));
	}

	public void test5() {
		LocalDate date = LocalDate.parse("1947-08-14");
		LocalTime time = LocalTime.MAX;
		System.out.println(date);
		System.out.println(time);
		System.out.println(date.atTime(time));
	}

	public void test6() {
		Object[] arr = new Object[4];
		for (int i = 1; i <= 3; i++) {
			switch (i) {
			case 1:
				arr[i] = new String("Java");
				break;
			case 2:
				arr[i] = new StringBuilder("Java");
				break;
			case 3:
				arr[i] = new SpecialString("Java");
				break;
			}
		}
		for (Object obj : arr) {
			System.out.println(obj);
		}
	}

	public void test3() {
		Super s = new Sub();
		try {
			s.m1();
		} catch (IOException e) {
			System.out.print("M");
		} finally {
			System.out.print("N");
		}
	}

	public void test1() {
		double price = 90000;
		String model;
		if (price > 100000) {
			model = "Tesla Model X";
		} else if (price <= 100000) {
			model = "Tesla Model S";
		}
		// System.out.println(model);
	}

	public void test2() {
		// ClassA obj1 = new ClassA();
		ClassA obj = new ClassA();
		System.out.println(obj.i1); // Line 8
		System.out.println(obj.i2); // Line 9
		System.out.println(this.i2); // Line 10
		System.out.println(super.i2); // Line 11
	}

	private static boolean checkAndIncrement(int x) {
		if (x < 5) {
			x++;
			return true;
		} else {
			return false;
		}
	}

	private static void processStringArray(String[] arr, Predicate<String> predicate) {
		for (String str : arr) {
			if (predicate.test(str)) {
				System.out.println(str);
			}
		}
	}

	private static void review(Student stud, int marks) {
		marks = marks + 10;
		stud.marks += marks;
	}
}
