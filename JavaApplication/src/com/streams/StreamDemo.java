package com.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamDemo {
	public static void main(String args[]) {
		characterCount();
	}
	public static void charactersCount() {
		String str="online java Compiler";
		Map<String,Long> mapV = Arrays.asList(str.split("")).stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));	
		mapV.forEach((k,v)-> System.out.println(k+"="+v));
	}
	public static void characterCount() {
		String str="online java Compiler";
		char c = 'e';
		//long charCount =  str.chars().filter(s-> s==c).count();
		long charCount = Arrays.asList(str.split("")).stream().filter(s->(s.charAt(0)==c)).count();
		System.out.println(charCount);
	}
	public static void stringReverse() {
		String str="online java Compiler";
		List<String> listS= Arrays.asList(str.split(" "));
		List<String> reverseList = listS.stream().map(s-> { return new StringBuilder(s).reverse().toString();} ).collect(Collectors.toList());
		reverseList.forEach(System.out::println);
	}
}
