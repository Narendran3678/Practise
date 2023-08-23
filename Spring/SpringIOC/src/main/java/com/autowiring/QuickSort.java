package com.autowiring;
import java.util.Comparator;
import java.util.List;
public class QuickSort<T extends Comparable<T>> implements Sorting<T> {
	
	public QuickSort()
	{
		System.out.println("QuickSort Initiated");
	}
	
	@Override
	public List<T> sort(List<T> listObj) {
		System.out.println("QuickSort Sort");
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
