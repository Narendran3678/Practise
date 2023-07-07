package com.practiseTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Predicate;

class ADemo {
	public void print() {
		System.out.println("A");
	}
}

class BDemo extends ADemo {
	public void print() {
		System.out.println("B");
	}
}

class Student1 {
	String name;
	int age;

	Student1() {
		this("James", 25);
	}

	Student1(String name, int age) {
		this.name = name;
		this.age = age;
	}
}

class Animal {
	protected void jump() {
		System.out.println("Animal");
	}
}

class Cat extends Animal {
	public void jump(int a) {
		System.out.println("Cat");
	}
}

class Deer extends Animal {
	public void jump() {
		System.out.println("Deer");
	}
}

public class TestDemo {

	private static int[] arr;
	int count;

	public static void main(String[] args) {
		TestDemo td = new TestDemo();
		td.test18();
		// td.test6(i -> i % 2 != 0);
	}

	private static void m(int i, int j) {
		i++;
		j--;
	}

	public void test18() {
		char[][] arr = { { 'A', 'B', 'C' }, { 'D', 'E', 'F' }, { 'G', 'H', 'I' } };

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][1]);
			}
			System.out.println();
		}
	}

	public void test17() {
		System.out.println(LocalDate.now());
		System.out.println(LocalDateTime.now());

		Boolean[] arr = new Boolean[2];
		List<Boolean> list = new ArrayList<>();
		list.add(arr[0]);
		list.add(arr[1]);
		/*
		 * if (list.remove(0)) { list.remove(1); }
		 */
		System.out.println(list);

		int a = 3;
		m(++a, a++);
		System.out.println(a);
	}

	public void test16() {
		Integer i = 10;
		List<Integer> list = new ArrayList<>();
		list.add(i);
		list.add(new Integer(i));
		list.add(i);

		list.removeIf(i1 -> i1 == 10);

		System.out.println(list);
	}

	public void test15() {
		int a = 5;
		int x = 10;
		switch (x) {
		case 10:
			a *= 2;
		case 20:
			a *= 3;
		case 30:
			a *= 4;
		}
		System.out.println(a);

		LocalDate date1 = LocalDate.parse("1947-08-15", DateTimeFormatter.ISO_DATE);
		LocalDate date2 = LocalDate.parse("1947-08-15", DateTimeFormatter.ISO_LOCAL_DATE);
		LocalDate date3 = LocalDate.of(1947, 8, 15);

		System.out.println(date1 + " - " + date2 + " - " + date3);
		System.out.println(date1.equals(date2) + " : " + date2.equals(date3));

		String[] arr = { "A", "B", "C", "D" };
		arr[0] = arr[1];
		arr[1] = "E";
		for (String s : arr) {
			System.out.print(s + " ");
		}
	}

	private static void add(int i, int j) {
		System.out.println("int version");
	}

	private static void add(Integer i, Integer j) {
		System.out.println("Integer version");
	}

	public static void change(int num) {
		num++;
		System.out.println(num);
	}

	public void test14() {
		Boolean[] arr = new Boolean[2];
		System.out.println(arr[0] + ":" + arr[1]);

		System.out.println(23 / 2.0);
		System.out.println(23 % 2.0);

		LocalDate date = LocalDate.of(2068, 4, 15);
		System.out.println(date.getMonth() + ":" + date.getMonthValue());
	}

	public void test13() {
		List<Character> list = new ArrayList<>();
		list.add(0, 'V');
		list.add('T');
		list.add(1, 'E');
		list.add(3, 'O');

		if (list.contains('O')) {
			list.remove(3);
		}

		for (char ch : list) {
			System.out.print(ch);
		}
		System.out.println();

		LocalDate date1 = LocalDate.parse("1980-03-16");
		LocalDate date2 = LocalDate.parse("1980-03-16");
		System.out.println(date1.equals(date2) + " : " + date1.isEqual(date2));
	}

	public void test12() {
		final boolean flag;
		flag = false;
		while (flag) {
			System.out.println("Good Morning!");
		}

		//
		int a = 7;
		boolean res = a++ == 7 && ++a == 9 || a++ == 9;
		System.out.println("a = " + a);
		System.out.println("res = " + res);

		//
		String[] arr = { "abc", "TrUe", "false", null, "FALSE" };
		for (String s : arr) {
			System.out.print(Boolean.valueOf(s) ? "T" : "F");
		}

		System.out.println(1 + 2 + 3 + 4 + "Hello");

	}

	public void test11() {
		String fName = "James";
		String lName = "Gosling";
		System.out.println(fName = lName);

		byte b1 = (byte) (127 + 21);
		System.out.println(b1);

		LocalTime time = LocalTime.of(23, 60);
		System.out.println(time);
	}

	public void test10() {
		StringBuilder sb = new StringBuilder("Hello");
		List<StringBuilder> list = new ArrayList<>();
		list.add(sb);
		list.add(new StringBuilder("Hello"));
		list.add(sb);
		sb.append("World!");

		System.out.println(list);

		if (arr.length > 0 && arr != null) {
			System.out.println(arr[0]);
		}
	}

	public void test9() {
		Animal cat = new Cat();
		Animal deer = new Deer();
		cat.jump();
		deer.jump();

		Period period = Period.of(0, 1000, 0);
		System.out.println(period);

		add(10, 20);
		add(null, null);
	}

	public void test8() {
		int i;
		outer: do {
			i = 5;
			inner: while (true) {
				System.out.println(i--);
				if (i == 4) {
					break outer;
				}
			}
		} while (true);
	}

	public void test7() {
		int i1 = 1;
		TestDemo.change(i1);
		System.out.println(i1);
	}

	public void test6(Predicate<Integer> predicate) {

		for (int i = 1; i <= 10; i++) {
			if (predicate.test(i)) {
				System.out.print(i);
			}
		}
	}

	public void test5() {
		List<StringBuilder> dryFruits = new ArrayList<>();
		dryFruits.add(new StringBuilder("Walnut"));
		dryFruits.add(new StringBuilder("Apricot"));
		dryFruits.add(new StringBuilder("Almond"));
		dryFruits.add(new StringBuilder("Date"));

		for (int i = 0; i < dryFruits.size(); i++) {
			if (i == 0) {
				dryFruits.remove(new StringBuilder("Almond"));
			}
		}

		System.out.println(dryFruits);
	}

	public void test4() {
		char c = 'Z';
		long l = 100_00l;
		int i = 9_2;
		float f = 2.02f;
		double d = 10_0.35d;
		l = c + i; // 90 + 92
		f = c * l * i * f; // 90 * 182 * 92 * 2.02 = 3044059.2
		f = l + i + c; // 182 + 92 + 90 = 364;
		i = (int) d;
		f = (long) d;
	}

	public void test3() {
		LocalDate date = LocalDate.parse("2000-01-01");
		Period period = Period.ofYears(-3000);
		System.out.println(date.plus(period));
	}

	public void test2() {
		ADemo obj1 = new ADemo();
		BDemo obj2 = (BDemo) obj1;
		obj2.print();
	}

	public void test1() {
		String[] arr = new String[7];
		System.out.println(arr);

		System.out.println(new Boolean("ture"));

		int a = 2;
		boolean res = false;
		res = a++ == 2 || --a == 2 && --a == 2;
		System.out.println(a);
		System.out.println(res);
	}

}
