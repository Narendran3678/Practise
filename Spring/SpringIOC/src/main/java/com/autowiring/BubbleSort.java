package com.autowiring;

import java.util.*;

public class BubbleSort<T extends Comparable<T>> implements Sorting<T> {
	
	public BubbleSort()
	{
		System.out.println("BubbleSort Initiated");
	}
	
	@Override
	public List<T> sort(List<T > listObj) {
		//listObj.sort((i1,i2) -> i1 < i2 );
		System.out.println("Bubble Sort");
		listObj.sort( new Comparator<T>() {

			@Override
			public int compare(T o1, T o2) {
				
				return o1.compareTo(o2);
			}
		});
		listObj.forEach(System.out::println);
		return listObj;
	}

}
