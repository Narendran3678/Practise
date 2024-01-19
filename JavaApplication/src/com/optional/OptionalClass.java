package com.optional;

import java.util.Optional;

public class OptionalClass {

	public static void main(String[] args) {
		
		try { test1(); } catch(Exception e)  { e.printStackTrace(); }
		
		try { test2(); } catch(Exception e)  { e.printStackTrace(); }
		
		try { test3(); } catch(Exception e)  { e.printStackTrace(); }
		
		try { test4(); } catch(Exception e)  { e.printStackTrace(); }
		
	}
	public static void test1() {
		String str = null;
		Optional<String> optStr =  Optional.of(str); //Throw Null Pointer Exception when null sent
		System.out.println(optStr);
		
	}
	
	public static void test2() {
		String str = null;
		Optional<String> optStr =  Optional.ofNullable(str); //Return Optional Empty when sent null;
		System.out.println(optStr);
		
	}
	public static void test3() {
		String str = null;
		String Name =  Optional.ofNullable(str).orElse("Sent Value is Empty");
		System.out.println(Name);
		
	}
	
	public static void test4() {
		String str1 = "Test4-1";
		String str2 = null;
		String Name =  Optional.ofNullable(str1).or( () -> Optional.ofNullable(str2)).orElse("Empty");
		System.out.println(Name);
		
		String str3 = null;
		String str4 = "Test4-2";
		System.out.println(  Optional.ofNullable(str3).or( () -> Optional.ofNullable(str4)).orElse("Empty") );
		
		String str5 = null;
		String str6 = null;
		System.out.println(  Optional.ofNullable(str5).or( () -> Optional.ofNullable(str6)).orElse("Empty") );
		
		
	}

}
