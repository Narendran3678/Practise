package com.practiseTest.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Predicate;

interface ILogger {
	void log();
}

class A1 {
	public String toString() {
		return null;
	}
}

class X {
	void greet() {
		System.out.println("Good Morning!");
	}
}

class Y extends X {
	void greet() {
		System.out.println("Good Afternoon!");
	}
}

class Z extends Y {
	void greet() {
		System.out.println("Good Night!");
	}
}

interface X1 {
	default void print() {
		System.out.println("X1");
	}
}

interface X2 extends X1 {
	void print();
}

interface X3 extends X2 {
	default void print() {
		System.out.println("X3");
	}
}

class X4 implements X3 {
}

class Square {
	int length;
	Square sq;

	Square(int length) {
		this.length = length;
	}

	void setInner(Square sq) {
		this.sq = sq;
	}

	int getLength() {
		return this.length;
	}
}

interface Shrinkable {
	public static void shrinkPercentage() {
		System.out.println("80%");
	}
}

class AntMan implements Shrinkable {
}

class Parent {
	Parent() throws IOException {
		System.out.print("HAKUNA");
	}
}

class Child extends Parent {
	Child() throws Exception {
		System.out.println("MATATA");
	}
}

class Base {
	static void print() { // Line n1
		System.out.println("BASE");
	}
}

class Derived extends Base {
	static void print() { // Line n2
		System.out.println("DERIVED");
	}
}

public class TestDemo2 {
	private static String s;
	int x = 5____0;
	//int y = ____50;
	//int z = 50____;
	float f = 123.76_86f;
	double d = 1_2_3_4;
	public static void main(String[] args) {
		TestDemo2 td = new TestDemo2();
		td.test14();
	}

	public void test14() {
		int a = 3;
		int b = 5;
		int c = 7;
		int d = 9;
		boolean res = --a + --b < 1 && c++ + d++ > 1;
		System.out.printf("a = %d, b = %d, c = %d, d = %d, res = %b", a, b, c, d, res); 
		
		String [] arr = new String[7];
        System.out.println(arr);
	}

	public void test13() {
		Square sq1 = new Square(10); // Line n1
		Square sq2 = new Square(5); // Line n2
		sq1.setInner(sq2); // Line n3
		System.out.println(sq1.sq.length); // Line n4

		Base b = null;
		Derived d = (Derived) b; // Line n3
		d.print();
	}

	public void test12() {
		boolean flag = false;
		do {
			if (flag = !flag) { // Line n1
				System.out.print(1); // Line n2
				continue; // Line n3
			}
			System.out.print(2); // Line n4
		} while (flag); // Line n5
	}

	public void test11() {
		int i = 0;
		for (System.out.print(i++); i < 2; System.out.print(i++)) {
			System.out.print(i);
		}

		X1 obj = new X4();
		obj.print();
	}

	public void test10() {
		String[] arr = { "L", "I", "V", "E" }; // Line n1
		int i = -2;
		if (i++ == -1) { // Line n2
			arr[-(--i)] = "F"; // Line n3
		} else if (--i == -2) { // Line n4
			System.out.println(i);
			arr[-++i] = "O"; // Line n5
		}

		for (String s : arr) {
			System.out.print(s);
		}

		String str = "ALASKA";
		System.out.println(str.charAt(str.indexOf("A") + 1));
	}

	public void test9() {

		boolean flag = false;
		System.out.println((flag = true) | (flag = false) || (flag = true));
		System.out.println(flag);

		String[][] arr = { { "%", "$$" }, { "***", "@@@@", "#####" } };
		for (String[] str : arr) {
			for (String s : str) {
				System.out.println(s);
				if (s.length() == 4) // Line n1
					break; // Line n2
			}
			break; // Line n3
		}
	}

	private static void m(int i) {
		System.out.print(1);
	}

	private static void m(int i1, int i2) {
		System.out.print(2);
	}

	private static void m(char... args) {
		System.out.print(3);
	}

	public void test8() {
		m('A');
		m('A', 'B');
		m('A', 'B', 'C');
		m('A', 'B', 'C', 'D');

		boolean flag1 = "Java" == "Java".replace('J', 'J'); // Line n1
		boolean flag2 = "Java" == "Java".replace("J", "J"); // Line n2
		System.out.println(flag1 && flag2);

		String s1 = new String("Java");
		String s2 = new String("Java");
		flag1 = s1 == s2.replace('J', 'J'); // Line n1
		flag2 = s1 == s2.replace("J", "J"); // Line n2
		System.out.println(flag1 && flag2);
	}

	public void test7() {
		X x = new Z();
		x.greet(); // Line n1
		Y y = (Y) x;
		y.greet();

		X y1 = new Y();
		y1.greet();
		((Y) x).greet(); // Line n2
		((Z) x).greet(); // Line n3
	}

	public void test6() {
		String text = null;
		text = text + new A1(); // Line n1
		System.out.println(text); // Line n2

		List<String> list = new ArrayList<>();
		list.add("P");
		list.add("O");
		list.add("T");

		List<String> subList = list.subList(1, 2); // Line n1
		subList.set(0, "E"); // Line n2
		System.out.println(subList);
		System.out.println(list);
	}

	public void test5() {
		StringBuilder sb = new StringBuilder("TOMATO");
		System.out.println(sb.reverse().replace(1, 2, "A")); // Line n1
		try {
			availableSeats(); // Line 12
		} catch (SQLException e) {
			System.out.println("SEATS NOT AVAILABLE");
		}
	}

	private static void availableSeats() throws SQLException {
		throw null; // Line 7
	}

	public void test4(String[] args) {
		try {
			try {
				System.out.println(args[1]); // Line n1
			} catch (RuntimeException e) {
				System.out.print("INHALE-"); // Line n2
				throw e; // Line n3
			} finally {
				System.out.print("EXHALE-"); // Line n4
			}
		} catch (RuntimeException e) {
			System.out.print("INHALE-"); // Line n5
		} finally {
			System.out.print("EXHALE"); // Line n6
		}
	}

	public void test3() {
		ILogger[] loggers = new ILogger[2]; // Line n1
		for (ILogger logger : loggers)
			logger.log(); // Line n2

	}

	private static void extractInt(Double obj) {
		System.out.println(obj.intValue());
	}

	public void test2() {

		extractInt(2.7);
		extractInt(new Double(2));

		int a = 3;
		System.out.println(a++ == 3 || --a == 3 && --a == 3);
		System.out.println(a);

		List<StringBuilder> list = new ArrayList<>();
		list.add(new StringBuilder("AAA")); // Line n1
		list.add(new StringBuilder("BBB")); // Line n2
		list.add(new StringBuilder("AAA")); // Line n3

		list.removeIf(sb -> sb.equals(new StringBuilder("AAA"))); // Line n4
		System.out.println(list);
	}

	public void test1() {
		StringBuilder sb = new StringBuilder();
		try {
			for (;;) {
				sb.append("OCA");
			}
		} catch (Exception e) {
			System.out.println("Exception!!!");
		}
		System.out.println("Main ends!!!");
	}

}
