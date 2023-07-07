package com.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Predicate;

import com.practiseTest.Test.A;

class Student {
	private String name;
	private int age;

	/*
	 * Student() { Student("James", 25); }
	 */
	Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String toString() {
		return "Student[" + name + ", " + age + "]";
	}

	public boolean equals(Object obj) {
		if (obj instanceof Student) {
			Student stud = (Student) obj;
			if (this.name.equals(stud.name) && this.age == stud.age) {
				return true;
			}
		}
		return false;
	}
}

class Parent {
	int i = 10;

	Parent(int i) {
		super();
		this.i = i;
	}

}

class Child extends Parent {
	int j = 20;

	Child(int j) {
		super(0);
		this.j = j;
	}

	Child(int i, int j) {
		super(i);
		this.j = j;
	}

	public void method1() {

	}

}

class Point {
	static int x;
	int y, z;

	public String toString() {
		return "Point(" + x + ", " + y + ", " + z + ")";
	}
}

abstract class Super {
	public abstract void m1() throws IOException;
}

class Sub extends Super {
	@Override
	public void m1() throws IOException {
		throw new FileNotFoundException();
	}
}

class ParentCLs {

	public String toString() {
		return "Inner ";
	}
}

class ChildCls extends ParentCLs {

	public String toString() {
		return super.toString().concat("Peace!");
	}
}

public class TestCls2 {

	public static void main(String[] args) throws IOException {
		TestCls2 tc = new TestCls2();
		tc.test18();
		

	}
	public void test18()
	{
		Integer i = new Integer(1);
		int i1=1;
		System.out.println(i==i1);
		
		List<Integer> list = new ArrayList<Integer>();

		list.add(27);
		list.add(27);

		list.add(new Integer(27));
		list.add(new Integer(27));

		System.out.println(list.get(0) == list.get(1));
		System.out.println(list.get(2) == list.get(3));
	}
	public void test17() {
		String[] arr = { "*", "**", "***", "****", "*****" };
		Predicate<String> pr1 = s -> s.length() < 4;
		print(arr, pr1);

		String[] arr1 = { "A", "ab", "bab", "Aa", "bb", "baba", "aba", "Abab" };
		processStringArray(arr1, (p) ->  p.length()>=1);
	}

	private static void processStringArray(String[] arr, Predicate<String> predicate) {
		for (String str : arr) {
			if (predicate.test(str)) {
				System.out.println(str);
			}
		}
	}

	private static void print(String[] arr, Predicate<String> predicate) {
		for (String str : arr) {
			if (predicate.test(str)) {
				System.out.println(str);
			}
		}
	}

	public void test16() throws IOException {
		System.out.println("Output is: " + (10 != 5));
		System.out.println(new ChildCls());
		LocalDate date = LocalDate.parse("1980-03-16");
        System.out.println(date.minusYears(-5));
	}

	public void test15() {
		A obj = new A(); // Line 7
		System.out.println(obj.i1); // Line 8
		/*
		 * System.out.println(obj.i2); //Line 9 System.out.println(obj.i3); //Line 10
		 * System.out.println(obj.i4); //Line 11
		 */
	}

	private static void add(double d1, double d2) {
		System.out.println("double version: " + (d1 + d2));
	}

	private static void add(Double d1, Double d2) {
		System.out.println("Double version: " + (d1 + d2));
	}

	public void test14() {
		String str1 = " ";
		boolean b1 = str1.isEmpty();
		System.out.println("-" + str1 + "-" + b1);
		str1.trim();
		b1 = str1.isEmpty();
		System.out.println(b1);
		add(10.0, null);

	}

	public void test13() {
		String fruit = "Apple";
		switch (fruit) {
		case "Apple":
			System.out.println("APPLE");
		case "Mango":
			System.out.println("MANGO");
		case "Banana":
			System.out.println("BANANA");
			break;
		default:
			System.out.println("ANY FRUIT WILL DO");
		}

		Period period = Period.of(2, 1, 0).ofYears(10).ofMonths(5).ofDays(12);
		System.out.println(period);
	}

	public void test12() {
		StringBuilder sb = new StringBuilder("Hurrah! I Passed...");
		sb.delete(0, 100);
		System.out.println(sb.length());

	}

	public void test11() {
		Super s = new Sub();
		try {
			s.m1();
		} catch (FileNotFoundException e) {
			System.out.print("B");
		} catch (IOException e) {
			System.out.print("A");
		} finally {
			System.out.print("C");
		}
	}

	public void test10() {
		String[][] arr = { { "7", "6", "5" }, { "4", "3" }, { "2", "1" } };
		for (int i = 0; i < arr.length; i++) { // Line n1
			for (int j = 0; j < arr[i].length; j++) { // Line n2
				switch (arr[i][j]) { // Line n3
				case "2":
				case "4":
				case "6":
					break; // Line n4
				default:
					continue; // Line n5
				}
				System.out.print(arr[i][j]); // Line n6
			}
		}
	}

	public void test9() {
		LocalDate newYear = LocalDate.of(2018, 1, 1);
		LocalDate eventDate = LocalDate.of(2018, 1, 1);
		boolean flag1 = newYear.isAfter(eventDate);
		boolean flag2 = newYear.isBefore(eventDate);
		System.out.println(flag1 + ":" + flag2);
	}

	public void test8() {
		List<LocalDate> dates = new ArrayList<>();
		dates.add(LocalDate.parse("2018-7-11")); // 07
		dates.add(LocalDate.parse("1919-10-25"));
		dates.add(LocalDate.of(2020, 4, 8));
		dates.add(LocalDate.of(1980, Month.DECEMBER, 31));

		dates.removeIf(x -> x.getYear() < 2000);
		dates.forEach(System.out::println);
	}

	public void test7() {
		Point p1 = new Point();
		p1.x = 17;
		p1.y = 35;
		p1.z = -1;

		Point p2 = new Point();
		p2.x = 19;
		p2.y = 40;
		p2.z = 0;

		System.out.println(p1); // Line n1
		System.out.println(p2); // Line n2
	}

	public void test6() {
		List<String> dryFruits = new ArrayList<>();
		dryFruits.add("Walnut");
		dryFruits.add("Apricot");
		dryFruits.add("Almond");
		dryFruits.add("Date");

		ListIterator<String> iterator = dryFruits.listIterator();
		while (iterator.hasNext()) {
			if (iterator.next().startsWith("A")) {
				iterator.remove();
			}
		}

		System.out.println(dryFruits);

		List<String> list = new ArrayList<>();
		list.add(0, "Array");
		list.add(0, "List");

		System.out.println(list);
	}

	public void test5() {
		StringBuilder sb = new StringBuilder("Java");
		String s1 = sb.toString();
		String s2 = "Java";

		System.out.println(s1 == s2);
	}

	public void test4() {
		ArrayList<Integer> original = new ArrayList<>();
		original.add(new Integer(10));

		ArrayList<Integer> cloned = (ArrayList<Integer>) original.clone();
		Integer i1 = cloned.get(0);
		++i1;

		System.out.println(cloned);
	}

	public void test3() {
		Child child = new Child(1000, 2000);

		System.out.println(child.i + ":" + child.j);
	}

	public void test2() {
		List<Student> students = new ArrayList<>();
		students.add(new Student("James", 25));
		students.add(new Student("James", 27));
		students.add(new Student("James", 25));
		students.add(new Student("James", 25));

		students.remove(new Student("James", 25));

		for (Student stud : students) {
			System.out.println(stud);
		}
	}

	public void test1() {
		List<String> list = new ArrayList<>();
		list.add("X");
		list.add("Y");
		list.add("X");
		list.add("Y");
		list.add("Z");
		list.remove(new String("Y"));
		System.out.println(list);
	}

}