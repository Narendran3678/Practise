package com.collections;
import java.util.*;
public class SpliteratorDemo {
	public static void main(String args[]) {
		
		List<String> names = new ArrayList<>();
		names.add("Rams");
		names.add("Posa");
		names.add("Chinni");
		
		
		Spliterator<String> s = names.spliterator();
		
		while( 
				s.tryAdvance((st) -> {
					System.out.print(st+" ");
					}) 
			) {
			
		}
		System.out.println();
		
		Spliterator<String> s1 = names.spliterator();
		s1.forEachRemaining((st) -> {System.out.print(st+" ");});
	}
}
