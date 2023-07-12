package com.io.serialization;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;

class Counter implements Serializable {
	private static int count = 0;

	public Counter() {
		count++;
	}

	public static int getCount() {
		return count;
	}
}

public class SerializaitonDemo {
	public static void serializationMethod(Object object) {
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(new File("serial.ser"))));) {
			oos.writeObject(object);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static Object deSerializationMethod(String serializedFile) {
		Object object = null;
		try (ObjectInputStream ois = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream(new File(serializedFile))));) {
			object = ois.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return object;
	}

	public static void main(String arg[]) {
		Editor editor = new Editor(1, "OvalOffice");
		Person person = new Person(1, "Naren", "naren@gmail.com");
		Person.setPhoneNumber(7092802533l);
		person.setEditor(editor);
		// SerializaitonDemo.serializationMethod(person);

		Person serPerson = (Person) SerializaitonDemo.deSerializationMethod("serial.ser");
		System.out.println(serPerson.toString());
		System.out.println(serPerson.getEditor().toString());

	}

	public static void sampleSerialization() {
		LocalDate optional = LocalDate.of(2018, 12, 1);
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(("E:\\date.txt")));
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream("E:\\date.txt"))) {
			oos.writeObject(optional);

			LocalDate object = null;
			try {
				object = (LocalDate) ois.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			System.out.println(object);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void serializeTest() {
		try {
			Counter ctr = new Counter();
			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\Counter.dat"))) {
				oos.writeObject(ctr);
			}

			new Counter();
			new Counter();

			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\Counter.dat"))) {
				ctr = (Counter) ois.readObject();
				System.out.println(Counter.getCount());
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
