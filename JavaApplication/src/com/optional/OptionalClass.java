package com.optional;

import java.util.Optional;

public class OptionalClass {

	public static void main(String[] args) {
		
		String str ="1";
		Optional<String> optStr =  Optional.ofNullable(str); 
		System.out.println(optStr);
		if(optStr.isEmpty())	
			System.out.println(optStr);
		else
			System.out.println(optStr.get());
	}

}
