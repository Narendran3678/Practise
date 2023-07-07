package com.javaadv;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.*;

class Testc {
	public static boolean testV1(String s, String s1) {
		return true;
	}

	public static boolean testV2(String s) {
		return true;
	}
}

enum Flags {
	TRUE, FALSE, TRUEFALSE;

	Flags() {
		System.out.println("HELLO");
	}

}

public class TestJava {
	public static void main(String args[]) {
		TestJava tc = new TestJava();
		tc.test9();
	}

	private static void checkStatus() {
		assert 1 == 2 : 2 == 2;
	}

	public void test9() {
		System.out.println(Flags.FALSE);
		try {
			checkStatus();
			/*
			 * int age = 14; assert age >= 18 : "Cannot Vote";
			 * System.out.println("The voter's age is " + age);
			 */
		} catch (AssertionError ae) {
			System.out.println(ae);
		}
	}

	public void test8() {
		NavigableMap<String, String> map1 = new TreeMap<>();
		map1.put("14", "One");
		map1.put("5", "Two");
		map1.put("130", "Three");
		map1.put("4", "Four");
		map1.put("4", "FOUR");
		System.out.println(map1);

		NavigableMap<Integer, String> map = new TreeMap<>();
		BiConsumer<Integer, String> consumer = map::putIfAbsent;
		consumer.accept(1, null);
		consumer.accept(2, "two");
		consumer.accept(1, "ONE");
		consumer.accept(2, "TWO");

		System.out.println(map);
	}

	public void test7() {
		try {
			deleteFiles(new File("C:\\Users\\Narendran\\Desktop\\Desk"), ".java");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LocalTime t1 = LocalTime.now();
		LocalDateTime t2 = LocalDateTime.now();
		t2.plusDays(1);
		System.out.println(t1 + "  -  " + t2);
		System.out.println(Duration.between(t2, t1));
	}

	public static void deleteFiles(File dir, String extension) throws IOException {
		File[] list = dir.listFiles();
		if (list != null && list.length > 0) {
			for (File file : list) {
				if (file.isDirectory()) {
					deleteFiles(file, extension);
				} else if (file.getName().endsWith(extension)) {
					file.delete();
				}
			}
		}
	}

	public void test6() {
		try {
			// Files.lines(Paths.get("E://Eclipse_Workspace/JavaApplication/src/com/nested/Book.java")).forEach(System.out::println);

			// Files.readAllLines(Paths.get("E://Eclipse_Workspace/JavaApplication/src/com/nested/Book.java")).forEach(System.out::println);

			Files.readAllLines(Paths.get("E://Eclipse_Workspace/JavaApplication/src/com/nested/Book.java")).stream()
					.forEach(System.out::println);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void test5() {
		try { // outer
			try { // inner
				System.out.println(1 / 0);
			} catch (ArithmeticException e) {
				System.out.println("Inner");
			} finally {
				System.out.println("Finally 1");
			}
		} catch (ArithmeticException e) {
			System.out.println("Outer");
		} finally {
			System.out.println("Finally 2");
		}
		System.out.println();
		Deque<Boolean> deque = new ArrayDeque<>();
		deque.push(new Boolean("abc"));
		deque.push(new Boolean("tRuE"));
		deque.push(new Boolean("FALSE"));
		deque.push(true);
		deque.push(new Boolean("abc"));
		System.out.println(deque.pop() + ":" + deque.peek() + ":" + deque.size());

		NavigableMap<Integer, String> map = new TreeMap<>();
		map.put(25, "Pune");
		map.put(32, "Mumbai");
		map.put(11, "Sri Nagar");
		map.put(39, "Chennai");
		System.out.println(map.headMap(25, true));
	}

	public void test4() {
		List<Integer> list = Arrays.asList(-80, 100, -40, 25, 200);
		Predicate<Integer> predicate = num -> {
			int ctr = 1;
			boolean result = num > 0;
			System.out.print(ctr++ + "." + num + "-");
			return result;
		};

		list.stream().filter(predicate).findFirst();

		System.out.println();
		Map<String, String> map = new TreeMap<>();
		map.put("1", "one");
		map.put("2", "two");
		map.put("3", "three");
		map.put(null, null);// Not Allow Null Value
		map.forEach((key, value) -> System.out.println("{" + key + ": " + value + "}"));
	}

	public void test3() {
		LocalDate date = LocalDate.of(2018, 11, 4);
		LocalTime time = LocalTime.of(13, 59, 59);
		ZonedDateTime dt = ZonedDateTime.of(date, time, ZoneId.of("America/New_York"));
		dt = dt.plusSeconds(1);
		System.out.println(dt);
		System.out.println(dt.getHour() + ":" + dt.getMinute() + ":" + dt.getSecond());
	}

	public void test2() {
		Instant instant = Instant.now();
		System.out.println(instant);
		LocalDateTime obj = instant.atZone(ZoneId.systemDefault()).toLocalDateTime(); // Line n1
		System.out.println(obj);
	}

	public void test1() {
		IntStream.rangeClosed(1, 10).parallel().forEachOrdered(System.out::println);

		BiPredicate<String, String> bipredicate = String::equalsIgnoreCase;
		System.out.println(bipredicate.test("JaVa", "Java"));

		BiPredicate<String, String> bipredicate1 = Testc::testV1;
		System.out.println(bipredicate1.test("JaVa", "Java"));

		Predicate<String> bipredicate2 = Testc::testV2;
		System.out.println(bipredicate2.test("JaVa"));

		BiFunction<String, String, String> func = (x, y) -> x + y;
		System.out.println(func.apply("1", "2"));

		int sum = IntStream.rangeClosed(1, 3).map(i -> i * i).map(i -> i * i).sum();
		System.out.println(sum);
	}
}

interface Square {
	int calculate(int x);
}