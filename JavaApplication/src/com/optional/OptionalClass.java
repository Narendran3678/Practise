package com.optional;

import java.util.Optional;

public class OptionalClass {

	public static void main(String[] args) {
		
		String str =null;
		Optional<String> optStr =  Optional.ofNullable(str); 
		
		if(optStr.isPresent())	
			System.out.println(optStr);
		else
			System.out.println(optStr.get());
	}

}
