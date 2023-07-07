package com.practiseTest;

import java.util.ArrayList;
import java.util.List;

class PenDrive {
	int capacity;

	PenDrive(int capacity) {
		this.capacity = capacity;
	}
}

class OTG extends PenDrive {
	String type;
	String make;

	OTG(int capacity, String type) {
		super(capacity);
		this.type = type;
	}

	OTG(String make) {
		super(128);
		this.make = make;
	}
}

class Student {
	private String name;
	private int age;

	Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String toString() {
		return "Student[" + name + ", " + age + "]";
	}
}
class Counter {
    int count;
    Counter(int count) {
        this.count = count;
    }

    public String toString() {
        return "Counter-" + count;
    }
}
public class TestCLs {
	
	public static void main(String[] args) {	
		 test6();
		 
		 
	}
	public static void test1() {
		List<Student> students = new ArrayList<>();
		students.add(new Student("James", 25));
		students.add(new Student("James", 27));
		students.add(new Student("James", 25));
		students.add(new Student("James", 25));

		students.remove(new Student("James", 25));

		for (Student stud : students) {
			System.out.println(stud);
		}

		String str = "java";
		StringBuilder sb = new StringBuilder("java");

	}
	public static void test6() 
	{
		ArrayList<Counter> original = new ArrayList<>();
        original.add(new Counter(10));

        ArrayList<Counter> cloned = (ArrayList<Counter>) original.clone();
        cloned.get(0).count = 5;

        System.out.println(original);
        
        StringBuilder sb = new StringBuilder(100);
        System.out.println(sb.length() + ":" + sb.toString().length());
        
        int a = 100;
        System.out.println(-a++ +"="+a);
	}
	public static void test5() {
		List<Character> list = new ArrayList<>();
		list.add(0, 'V');
		list.add('T');
		list.add(1, 'E');
		list.add(2, 'O');
		list.add(4, 'E');

		if (list.contains('O')) {
//				list.remove('O');
		}

		for (char ch : list) {
			System.out.print(ch);
		}
	}

	public static void test4() {
		String s1 = "OCAJP";
		String s2 = "OCAJP" + "";
		System.out.println(s1 == s2);
	}

	public static void test3() {
		OTG obj = new OTG(128, "TYPE-C");
		System.out.println(obj.capacity + ":" + obj.type);

	}

	public static void test2() {
		String str = "java";
		StringBuilder sb = new StringBuilder("java");
		System.out.println(str.equals(sb) + ":" + sb.equals(str));
	}

	
}