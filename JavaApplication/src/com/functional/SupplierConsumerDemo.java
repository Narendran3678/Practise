package com.functional;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

class Document {
	void printAuthor() {
		System.out.println("Document-Author");
	}
}

class RFP extends Document {
	@Override
	void printAuthor() {
		System.out.println("RFP-Author");
	}
}

class FunctionalReference {
	String s;
	static FunctionalReference methodRef = new FunctionalReference();

	public FunctionalReference() {
		s = "Default Constructor";
	}

	public FunctionalReference(String s) {
		this.s = s;
	}

	public String genMethod(String str) {
		return "This is Method Reference Method - [" + str + "]";
	}

	public static String staticMethod(String str) {
		return "This is Static Method - [" + str + "]";
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	@Override
	public String toString() {
		return "FunctionalReference [s=" + s + "]";
	}

}

interface ObjectConsumer<T> extends Consumer<T> {
	@Override
	default void accept(T t) {
		if (t instanceof String) {
			System.out.println(t);
		}
		if (t instanceof Certification) {
			System.out.println(t);
		}
	}
}

public class SupplierConsumerDemo{
	public static void main(String[] args) {
		System.out.println("Supplier Demo");
		/*
		System.out.println(printInfo(() -> {
			return getSystemInfo();
		}));
		
		constructorReferenceDemo();
		methodReferenceDemo();
		*/
		consumerOverride();
		
	}
	public static void consumerOverride()
	{
		String str="Naren";
		ObjectConsumer<String> strCons = new ObjectConsumer<>() {
			
		};
		
		Consumer<String> strConsumer = strCons::accept;
		List<String> strList = Arrays.asList("1","2","3");
		strList.stream().forEach(strConsumer);
		
		
		Certification c1 = new Certification("S001", "OCA", 87);
        Certification c2 = new Certification("S002", "OCA", 82);
        Certification c3 = new Certification("S001", "OCP", 79);
        Certification c4 = new Certification("S002", "OCP", 89);
        Certification c5 = new Certification("S003", "OCA", 60);
        Certification c6 = new Certification("S004", "OCA", 88);
        ObjectConsumer<Certification> certCons = new ObjectConsumer<>() {
			@Override
			public void accept(Certification t) {
				System.out.println(t.getStudId());
			}
		};
        Consumer<Certification> crtConsumer = certCons::accept;
		List<Certification> list = Arrays.asList(c1,c2,c3,c4,c5,c6);
		list.stream().forEach(crtConsumer);
	}
	public static void constructorReferenceDemo() {
		Supplier<FunctionalReference> supRef = FunctionalReference::new;
		FunctionalReference fref = supRef.get();
		System.out.println(fref.toString());

		Consumer<String> setValue = fref::setS;
		setValue.accept("SetValue for S in Default Constructor");
		System.out.println(fref.toString());

		Function<String, FunctionalReference> supParRef = FunctionalReference::new;
		FunctionalReference fpRef = supParRef.apply("Creating Parameterized Constructor");
		System.out.println(fpRef.toString());

	}

	public static void methodReferenceDemo() {
		Function<String, String> staticRef = FunctionalReference::staticMethod;
		System.out.println(staticRef.apply(getSystemInfo()));

		Function<String, String> methRef = FunctionalReference.methodRef::genMethod;
		System.out.println(methRef.apply(getSystemInfo()));
	}

	public static String getSystemInfo() {
		return "OS-" + System.getProperty("os.name");
	}

	public static String printInfo(Supplier<Object> supplier) {
		return (String) supplier.get();
	}

	public static void supplierDemo() {
		check(Document::new);
		check(RFP::new);
	}

	private static void check(Supplier<? extends Document> supplier) {
		supplier.get().printAuthor();
	}
}
