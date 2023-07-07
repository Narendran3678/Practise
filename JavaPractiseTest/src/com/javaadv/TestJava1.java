package com.javaadv;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.IntBinaryOperator;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Animal {
}

class Dog extends Animal {
}

class Cat extends Animal {
}

@SuppressWarnings("hiding")
class A<T> {
	T t;

	void set(T t) {
		this.t = t;
	}

	T get() {
		return t;
	}
}
/*
 * interface Operation { int operate(int x,int y); }
 */

/*
 * interface Operation { long operate(long x,long y); }
 */

interface Operation<T extends Integer> {
	T operate(T x, T y);
}

@FunctionalInterface
interface I5 {
	void print();
}

class T {
	@Override
	public String toString() {
		return "T";
	}
}

@SuppressWarnings("hiding")
class Printer<T> {
	private T t;

	Printer(T t) {
		this.t = t;
	}

	public T getObj() {
		return t;
	}

	@Override
	public String toString() {
		return "Printer";
	}
}

enum ShapeType {
	CIRCLE, SQUARE, RECTANGLE;
}

abstract class Shape {
	private ShapeType type = ShapeType.SQUARE; // default ShapeType

	Shape(ShapeType type) {
		this.type = type;
	}

	public ShapeType getType() {
		return type;
	}

	abstract void draw();
}

class Book {
	String title;
	String author;
	double price;

	public Book(String title, String author, double price) {
		this.title = title;
		this.author = author;
		this.price = price;
	}

	public String getAuthor() {
		return this.author;
	}

	public String toString() {
		return "{" + title + "," + author + "," + price + "}";
	}
}

class Outer {
	private String name = "James Gosling";

	class Inner {

		public void printName() {
			System.out.println(name);
		}
	}
}

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public String toString() {
		return "Point(" + x + ", " + y + ")";
	}

	/*
	 * boolean filter() { return this.x == this.y; }
	 */
	boolean filter(Point p) {
		return p.x == p.y;
	}

}

interface StringConsumer extends Consumer<String> {

	public void consumeMethod(String s);

	@Override
	default void accept(String t) {
		System.out.println(t.toUpperCase());
	}

}

@SuppressWarnings("serial")
class MyException extends RuntimeException {
}
@SuppressWarnings({"resource","unused","hiding","rawtypes","unchecked"})
public class TestJava1 {
	public static void main(String[] args) {
		TestJava1 tj = new TestJava1();
		tj.test10();
	}
	
	public void test10() {
		List<String> list = new ArrayList<>();
		System.out.println(list.size());
		System.out.println(list.stream().anyMatch(s -> s.length() > 0));
		System.out.println(list.stream().allMatch(s -> s.length() > 0));
		System.out.println(list.stream().noneMatch(s -> s.length() > 0));
		System.out.println();
		OptionalDouble opDouble = OptionalDouble.of(44356);
		if (!opDouble.isEmpty()) {
			System.out.println("Have");
		}

		OptionalDouble optional = OptionalDouble.empty();
		System.out.println(optional.orElseThrow(MyException::new));
	}

	public void test9() {
		new Outer().new Inner().printName();

		StringConsumer consumer = s -> System.out.println(s.toLowerCase());
		List<String> list1 = Arrays.asList("Dr", "Mr", "Miss", "Mrs");
		list1.stream().forEach(consumer);

		List<Point> list = new ArrayList<>();
		list.add(new Point(0, 0));
		list.add(new Point(1, 2));
		list.add(new Point(-1, -1));
		Point p = new Point(0, 0);
		list.stream().filter(p::filter).forEach(System.out::println); // Line n1
	}

	public void test8() {
		Shape shape = new Shape(ShapeType.CIRCLE) {
			@Override
			void draw() {
				System.out.println("Drawing a " + getType());
			}
		};
		shape.draw();

		List<Book> books = Arrays.asList(new Book("Head First Java", "Kathy Sierra", 24.5),
				new Book("OCP", "Udayan Khattry", 20.99), new Book("OCA", "Udayan Khattry", 14.99));
		books.stream().collect(Collectors.groupingBy(Book::getAuthor)).forEach((a, b) -> System.out.println(b));

		int res = 1;

		IntStream stream = IntStream.rangeClosed(1, 5);
		IntBinaryOperator ino = (a, b) -> a * b;

		System.out.println(stream.reduce(res, ino));
	}

	public void test7() {
		LocalDate date = LocalDate.ofEpochDay(365);
		System.out.println(date);

		Path path = Paths.get("E:/A/B/C/Book.java");
		System.out.println(path);
		System.out.println(path.subpath(2, 4));

		LocalTime t1 = LocalTime.parse("11:03:15.987");
		System.out.println(t1.plus(22, ChronoUnit.HOURS));
		System.out.println(t1.plus(22, ChronoUnit.HOURS) + " = " + (t1.plusHours(22)));
		System.out.println(t1.plus(22, ChronoUnit.HOURS).equals(t1.plusHours(22)));

		IntStream stream = "Naren".chars();
		stream.forEach(c -> System.out.print(c + "-"));
		// System.out.println(stream.count()); // Line 9
		System.out.println();
		System.out.println();
		try {
			System.setProperty("user.home", "E:\\A\\B\\C");
			Stream<Path> files = Files.list(Paths.get(System.getProperty("user.home")));
			files.forEach(System.out::println);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	int i = 100;
	I5 obj1 = new I5() {
		int i = 200;

		public void print() {
			System.out.println(this.i);
		}
	};

	I5 obj2 = () -> {
		int i = 300;
		System.out.println(this.i);
	};

	public void test6() {
		TestJava1 ques = new TestJava1();
		ques.obj1.print();
		ques.obj2.print();

		Printer<T> obj = new Printer<>(new T());
		System.out.println(obj.getObj());

	}
	/*
	 * public static <T> void print1(A<? extends Animal> obj) { obj.set(new Dog());
	 * // Line 22 System.out.println(obj.get().getClass()); }
	 */

	public static <T> void print2(A<? super Dog> obj) {
		obj.set(new Dog()); // Line 27
		System.out.println(obj.get().getClass());
	}

	public void test5() {
		Optional<Integer> optional = Optional.ofNullable(null);
		System.out.println(optional);

		String text = "Aa aA aB Ba aC Ca";
		ToIntFunction<String> func = text::indexOf;
		System.out.println(func.applyAsInt("a"));
		System.out.println();
		Properties prop = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("E:\\Eclipse_Workspace\\JavaPractiseTest\\Message.properties");
			prop.load(fis);
			System.out.println(prop.getProperty("key1"));
			System.out.println(prop.getProperty("key2", "Good Day!"));
			System.out.println(prop.getProperty("key3", "Good Day!"));
			System.out.println(prop.getProperty("key4"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void test4() throws InterruptedException, ExecutionException {
		Callable<String> c = new Callable<String>() {
			@Override
			public String call() throws Exception {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
				}
				return "HELLO";
			}
		};

		ExecutorService es = Executors.newFixedThreadPool(10);
		List<Callable<String>> list = Arrays.asList(c, c, c, c, c);
		List<Future<String>> futures = es.invokeAll(list);
		System.out.println(futures.size());
		for (Future<String> future : futures) {
			System.out.println(future.get());
		}
		es.shutdown();

	}

	public void test3() {
		String[] arr = { "A", "ab", "bab", "Aa", "bb", "baba", "aba", "Abab" };
		BiPredicate<String, String> predicate = String::startsWith;

		for (String str : arr) {
			if (predicate.negate().test(str, "A"))
				System.out.println(str);
		}

		Operation o1 = (x, y) -> x + y;
		System.out.println(o1.operate(5, 10));

	}

	public void test2() {
		Locale.setDefault(new Locale("fr", "CA"));
		Locale loc1 = Locale.getDefault();
		System.out.println(loc1.getLanguage() + "-" + loc1.getCountry());

		Locale loc = new Locale("en", "IN");
		ResourceBundle rb = ResourceBundle.getBundle("ResourceBundle", loc);
		System.out.println(rb.getObject("locale"));

	}

	public void test1() {
		A<Dog> obj = new A<Dog>();
		// print1(obj); //Line 33
		print2(obj); // Line 34

		try (FileInputStream fis = new FileInputStream("E:\\Test.java");
				FileOutputStream fos = new FileOutputStream("E:\\test.txt")) {
			int res;
			byte[] arr = new byte[500000]; // Line 10
			while ((res = fis.read(arr)) != -1) { // L ine 11
				fos.write(arr); // Line 12
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
