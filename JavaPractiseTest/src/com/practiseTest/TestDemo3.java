package com.practiseTest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Predicate;

interface Multiplier {
	void multiply(int... x) throws SQLException;
}

class Calculator implements Multiplier {
	public void multiply(int... x) throws Error {
		System.out.println(x.length);
	}
}

interface Profitable {
	double profitPercentage = 42.0;
}

class Business implements Profitable {
	double profitPercentage = 50.0; // Line n1
}

interface Profitable1 {
	default double profit() {
		return 12.5;
	}
}

interface Profitable2 {
	default double profit() {
		return 25.5;
	}
}

interface I1 {
	int i = 10;
}

interface I2 {
	int i = 20;
}

interface I3 extends I1, I2 { // Line n1

}

abstract class Profit implements Profitable1, Profitable2 {

	@Override
	public double profit() {
		// TODO Auto-generated method stub
		return Profitable1.super.profit();
	}

}

class TestP extends Profit {

	@Override
	public double profit() {
		// TODO Auto-generated method stub
		return super.profit();
	}

}

class M {
	public void printName() {
		System.out.println("M");
	}
}

class N extends M {
	public void printName() {
		System.out.println("N");
	}
}

class Currency {

	String notation = "-"; // Line n1

	String getNotation() { // Line n2
		return notation;
	}
}

class USDollar extends Currency {
	String notation = "$"; // Line n3

	String getNotation() { // Line n4
		return notation;
	}
}

class Euro extends Currency {
	protected String notation = "€"; // Line n5

	protected String getNotation() { // Line n6
		return notation;
	}
}

class Counter1 {
	static int ctr = 0;
	int count = 0;
}

public class TestDemo3 {

	public static void main(String[] args) {
		final int i = 10;
		short s1 = 10;

		TestDemo3 td = new TestDemo3();
		td.test14();
	}

	public static void test16() {

	}

	public static void test15() {
		Counter1 ctr1 = new Counter1();
		Counter1 ctr2 = new Counter1();
		Counter1 ctr3 = new Counter1();

		for (int i = 1; i <= 5; i++) {
			ctr1.ctr++;
			ctr1.count++;
			ctr2.ctr++;
			ctr2.count++;
			ctr3.ctr++;
			ctr3.count++;
		}

		System.out.println(ctr3.ctr + ":" + ctr3.count);

		List<String> words = new ArrayList<>();
		words.add("A");
		words.add("an");
		words.add("the");
		words.add("when");
		words.add("what");
		words.add("Where");
		words.add("whether");

		processStringArray(words, p -> p.length() >= 1);
		System.out.println();
		processStringArray(words, (String p) -> p.length() > 0);

		System.out.println();
		processStringArray(words, (String p) -> p.length() < 100);
		System.out.println();
		processStringArray(words, p -> !!!!true);
		System.out.println();
	}

	private static void processStringArray(List<String> list, Predicate<String> predicate) {
		for (String str : list) {
			if (predicate.test(str)) {
				System.out.println(str);
			}
		}
	}

	public static void convert(String s) throws IllegalArgumentException, RuntimeException, Exception {
		if (s.length() == 0) {
			throw new RuntimeException("LENGTH SHOULD BE GREATER THAN 0");
		}
	}

	public void test14() {

		try {
			convert("");
		} catch (RuntimeException e) { // Line 14
			System.out.println(e.getMessage()); // Line 15
		} // Line 16
		catch (Exception e) {
			e.printStackTrace();
		}

		try {
			play();
			return;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return;
		} finally {
			System.out.println("MATCH ABANDONED");
		}
		// System.out.println("DONE");

	}

	static void play() throws Exception {
		throw new Exception("INJURED");
	}

	public void test13() {
		List<String> places = new ArrayList<>();
		places.add("Austin");
		places.add("Okinawa");
		places.add("Giza");
		places.add("Manila");
		places.add("Batam");
		places.add("Giza");

		if (places.remove("Giza"))
			places.remove("Austin");

		System.out.println(places);

		String str = "Game on"; // Line n1
		StringBuilder sb = new StringBuilder(str); // Line n2

		String str1 = "PANIC";
		StringBuilder sb1 = new StringBuilder("THET");
		System.out.println(str1.replace("N", sb1)); // Line n1
	}

	public void test12() {
		try { // outer
			try { // inner
				System.out.println(1 / 0);
			} catch (ArithmeticException e) {
				System.out.println("INNER");
			} finally {
				System.out.println("FINALLY 1");
			}
		} catch (ArithmeticException e) {
			System.out.println("OUTER");
		} finally {
			System.out.println("FINALLY 2");
		}

		String text = "ONE ";
		System.out.println(text.concat(text.concat("ELEVEN ")).trim());

	}

	public void test11() {
		String[] arr = { "1st", "2nd", "3rd", "4th", "5th" };
		String place = "faraaay";
		System.out.println(place.indexOf("a", 3));
		System.out.println(arr[place.indexOf("a", 3)]); // Line n1
	}

	private static void getReport() throws SQLException {
		try {
			throw new SQLException();
		} catch (Exception e) {
			throw null; // Line 10
		}
	}

	public void test10() {
		int ctr = 100;
		one: for (int i = 0; i < 10; i++) {
			two: for (int j = 0; j < 7; j++) {
				three: while (true) {
					ctr++;
					if (i > j) {
						break one;
					} else if (i == j) {
						break two;
					} else {
						break three;
					}
				}
			}
		}
		System.out.println(ctr);

		char c1 = 'a'; // ASCII code of 'a' is 97
		int i1 = c1; // Line n1
		System.out.println(i1); // Line n2

	}

	public void test9() {
		Currency c1 = new USDollar();
		System.out.println(c1.notation + ":" + c1.getNotation());

		Currency c2 = new Euro();
		System.out.println(c2.notation + ":" + c2.getNotation());
	}

	public void test8() {
		System.out.println(I1.i); // Line n2
		System.out.println(I2.i); // Line n3
		// System.out.println(I3.i); // Line n4

		StringBuilder sb = new StringBuilder("B"); // Line n1
		sb.append(sb.append("A")); // Line n2
		System.out.println(sb); // Line n3

		int i = 10;
		System.out.println(i > 3 != false);

		int var = 3;
		String[][] arr = new String[--var][var++]; // Line n1
		arr[0][1] = "X"; // Line n2
		arr[1][1] = "Y"; // Line n3
		for (String[] arr1 : arr) {
			for (String s : arr1) {
				// if(s != null)
				System.out.print(s);
			}
			System.out.println();
		}

	}

	public void test7() {
		int x = 10; // Line n1
		if (false)
			System.out.println(x); // Line n2
		System.out.println("HELLO"); // Line n3

		String place = "MISSS";
		System.out.println(place.replace("SS", "T"));

		LocalDate date = LocalDate.parse("2020-08-31");
		System.out.println(date.plusMonths(-6));

		outer: for (int i = 0; i < 3; System.out.print(i)) {
			i++;
			inner: for (int j = 0; j < 3; System.out.print(j)) {
				if (i > ++j) {
					break outer;
				}
			}
		}
	}

	public void test6() {
		List<String> list = new ArrayList<>();
		list.add("P");
		list.add("O");
		list.add("T");

		List<String> subList = list.subList(1, 2); // Line n1
		subList.set(0, "E"); // Line n2

		// list.remove(2);
		System.out.println(list);
		System.out.println(subList);

		try {
			getReport(); // Line 16
		} catch (SQLException e) {
			System.out.println("REPORT ERROR");
		}

	}

	public void test5() {
		TestDemo3 td = new TestDemo3();
		Profit p = new TestP();
		System.out.println(p.profit());

		M obj1 = new M();
		N obj2 = (N) obj1;
		obj2.printName();

	}

	public void test4() {
		int i = 1;
		int j = 5;
		int k = 0;
		A: while (true) {
			i++;
			B: while (true) {
				j--;
				C: while (true) {
					k += i + j;
					if (i == j)
						break A;
					else if (i > j)
						continue A;
					else
						continue B;
				}
			}
		}
		System.out.println(k);
	}

	public void test3() {
		boolean flag1 = true;
		boolean flag2 = false;
		boolean flag3 = true;
		boolean flag4 = false;

		System.out.println(!flag1 == flag2 != flag3 == !flag4); // Line n1
		System.out.println(flag1 = flag2 != flag3 == !flag4); // Line n2

		int[][] arr = new int[6][6]; // Line n1
		arr[1][4] = 100;
		arr[6][6] = 200;
		arr[3][6] = 300;

	}

	public void test2() {
		try {
			save();
			log();
		} catch (SQLException | IOException e) {
			System.out.println(e);
		}
		Profitable obj = new Business(); // Line n2
		System.out.println(obj.profitPercentage); // Line n3

		int val = 25;
		if (val++ < 26) {
			System.out.println(val++);
		}

		LocalDate date = LocalDate.parse("1983-06-30");
		System.out.println(date.plusMonths(8));

		String word = "REBUS";
		word = word.substring(2, 5);
		System.out.println(word);

		word = "REBUS";
		word = word.replace("RE", "");
		System.out.println(word);
	}

	private static void save() throws IOException {
	}

	private static void log() throws SQLException {
	}

	public void test1() {
		try {
			Multiplier obj = new Calculator(); // Line n1
			obj.multiply(1, 2, 3);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}
