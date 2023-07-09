package com.javaadv;

import java.io.BufferedReader;
import java.io.Console;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class MyThread implements Callable<Integer> {
	private String str;

	MyThread(String str) {
		this.str = str;
	}

	public void run() {
		System.out.println(str.toUpperCase());
	}

	@Override
	public Integer call() throws Exception {
		return str.length();
	}
}

class Student {
	private String name;
	private int age;

	Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public int hashCode() {
		return name.hashCode() + age;
	}

	public String toString() {
		return "Student[" + name + ", " + age + "]";
	}

	public boolean equals(Object obj) {
		if (obj instanceof Student) {
			Student stud = (Student) obj;
			return this.name.equals(stud.name) && this.age == stud.age;
		}
		return false;
	}

	public static int compareByName(Student s1, Student s2) {
		return s1.getName().compareTo(s2.getName());
	}
}

class Printer1 {
	private static int count = 0;

	private Printer1() {
		System.out.println("Printer");
		count++;
	}

	static Printer1 getInstance() {
		return PrinterCreator.printer;
	}

	static class PrinterCreator {
		static Printer1 printer = new Printer1();
	}

	static int getCount() {
		return count;
	}
}

class Counter implements Runnable {
	private static AtomicInteger ai = new AtomicInteger(4);

	public void run() {
		System.out.print(ai.getAndDecrement());
	}
}

@SuppressWarnings({ "resource", "unused", "hiding", "rawtypes", "unchecked" })
public class TestJava2 {
	private int num1 = 100;

	class N {
		private int num2 = 200;
	}

	public static void main(String[] args) {
		TestJava2 tj = new TestJava2();
		tj.test8();
	}

	public void test8() {
		List<Integer> v = new ArrayList<>();//Arrays.asList(1,2,3);
		Stream<List<Integer>> stream = Stream.of(v);
		Optional<List<Integer>> optional = stream.findFirst();
		System.out.println(optional.orElse(null));
		
		
	}

	public void test7() {
		Consumer<Integer> consumer = System.out::print;
		Integer i = 5;
		consumer.andThen(consumer).accept(i++);

		Path root = Paths.get("E:");
		BiPredicate<Path, BasicFileAttributes> predicate = (p, a) -> p.toString().endsWith("txt");
		try (Stream<Path> paths = Files.find(root, 2, predicate)) {
			paths.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void test6() {
		Stream<Integer> stream = Stream.iterate(1, i -> i + 1);
		System.out.println(stream.anyMatch(i -> i > 1));

		Thread t1 = new Thread(new Counter());
		Thread t2 = new Thread(new Counter());
		Thread t3 = new Thread(new Counter());
		Thread[] threads = { t1, t2, t3 };
		for (Thread thread : threads) {
			thread.start();
		}

		System.out.println();
		LocalDateTime date = LocalDateTime.of(2019, 1, 1, 10, 10);
		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
		DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
		DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
		DateTimeFormatter formatter3 = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		System.out.println(formatter.format(date));
		System.out.println(formatter1.format(date));
		System.out.println(formatter2.format(date));
		System.out.println(formatter3.format(date));

		String[] arr = { "A5", "B4", "C3", "D2", "E1" };
		Arrays.sort(arr, Comparator.comparing(s -> s.substring(1)));
		for (String str : arr) {
			System.out.print(str + " ");
		}

		List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
		list.removeIf(i -> i % 2 == 1);
		System.out.println(list);
	}

	public void test5() {
		Stream<String> stream = Stream.of("java", "python", "c", "c++", "java", "python");
		Set<String> set = stream.collect(Collectors.toSet());
		System.out.println(set.size());

		Locale[] loc = Locale.getAvailableLocales();
		// Arrays.stream(loc).filter( l -> l.getLanguage().equals("fr")
		// ).forEach(System.out::println);
		Arrays.stream(loc).filter(l -> l.toString().startsWith("fr")).forEach(System.out::println);

		Printer1 p1 = Printer1.getInstance();
		Printer1 p2 = Printer1.getInstance();
		Printer1 p3 = Printer1.getInstance();
		System.out.println(Printer1.getCount());
		try {
			File file = new File("E:\\temp.dat");
			try (DataOutputStream os = new DataOutputStream(new FileOutputStream(file));
					DataInputStream is = new DataInputStream((new FileInputStream(file)))) {
				os.writeChars("JAVA");
				while (is.available() > 0) {
					System.out.println(is.readChar());
				}
			}
		} catch (Exception e) {
			System.out.println("Exception");
		}
	}

	public void test4() {
		Path path = Paths.get("E:", "TEMP", "Parent\\Child\\Message.txt");

		try (BufferedReader reader = Files.newBufferedReader(path)) {
			String str = null;
			while ((str = reader.readLine()) != null) {
				System.out.println(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		Set<Student> students = new TreeSet<>(Student::compareByName);
		students.add(new Student("James", 20));
		students.add(new Student("James", 20));
		students.add(new Student("James", 22));
		System.out.println(students.size());

		Stream<String> stream = Stream.of("java", "python", "c", "c++", "java", "python");
		Set<String> set = stream.collect(Collectors.toSet());
		System.out.println(set.size());
	}

	public void test3() {
		Optional<Console> optional = Optional.ofNullable(System.console());
		if (optional.isPresent()) {
			System.out.println(optional.get());
		}

		Path path1 = Paths.get("E:\\A\\B\\C");
		Path path2 = Paths.get("E:\\A");
		System.out.println(path1.relativize(path2));
		System.out.println(path2.relativize(path1));

		List<String> list = Arrays.asList("T", "S", "R", "I", "F");
		ListIterator<String> iter = list.listIterator(2);
		while (iter.hasNext()) {
			System.out.print(iter.next());
		}
	}

	public void test2() {
		ExecutorService es = Executors.newSingleThreadExecutor();
		MyThread thread = new MyThread("ocp");
		Future future = es.submit(thread);
		Integer tmp = 0;
		try {
			tmp = (Integer) future.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Line 22
		System.out.println(tmp);
		es.shutdown();
	}

	public void test1() {
		TestJava2 outer = new TestJava2();
		TestJava2.N inner = outer.new N();
		System.out.println(outer.num1 + inner.num2);

		File dir = new File("E:" + File.separator + "A" + File.separator + "B");
		// File dir = new File("E:" + File.separator + "A" + File.separator + "B"+
		// File.separator +"Test.java");
		System.out.println(dir.getPath());
		System.out.println(dir.getParentFile());
		System.out.println(dir.getParent());
		System.out.println(dir.getParentFile().getParent());
	}
}
