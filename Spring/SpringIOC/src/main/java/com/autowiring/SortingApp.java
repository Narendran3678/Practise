package com.autowiring;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
;


public class SortingApp<T extends Comparable<T>> {

	private BubbleSort<T> bubbleSort;
	private QuickSort<T> quickSort;
	private Sorting<T> sorting;
	
	private String sortingComplexity;
	
	
	@Value("${sorting-heapsize}")
	private String sortingHeapSize;
	
	public SortingApp(){}
	
	public SortingApp(Sorting<T> sorting) {  // autowire="Constructor"
		super();
		this.sorting = sorting;
	}

	public SortingApp(BubbleSort<T> bubbleSort, QuickSort<T> quickSort) // autowire="Constructor"
	{
		this.bubbleSort = bubbleSort;
		this.quickSort  = quickSort;
	}

	//Getters
	public String getSortingHeapSize() {
		return sortingHeapSize;
	}
	public String getSortingComplexity() {
		return sortingComplexity;
	}
	public List<T> bubbleSort(List<T> listObj)
	{
		return bubbleSort.sort(listObj);
	}
	public List<T> quickSort(List<T> listObj)
	{
		return quickSort.sort(listObj);
	}	
	public List<T> sort(List<T> listObj) // Generic
	{
		return sorting.sort(listObj);
	}	
	
	//Setters
	public void setSortingHeapSize(String sortingHeapSize) {
		this.sortingHeapSize = sortingHeapSize;
	}
	public void setSortingComplexity(String sortingComplexity) {
		this.sortingComplexity = sortingComplexity;
	}
	
	@Autowired
	public void setBubbleSort(BubbleSort<T> bubbleSort) { // autowire="byName" 
		this.bubbleSort = bubbleSort;
	}
	@Autowired
	public QuickSort<T> getQuickSort() { // autowire="byName" 
		return quickSort;
	}
	@Autowired
	@Qualifier("bubbleSort") // To Choose which sorting algorithm to use
	public void setSorting(Sorting<T> sorting) { // autowire="byName" 
		this.sorting = sorting;
	}
	
	
	
	public Sorting<T> getSorting() {
		return sorting;
	}
	public BubbleSort<T> getBubbleSort() 
	{
		return bubbleSort;
	}
	public void setQuickSort(QuickSort<T> quickSort) {
		this.quickSort = quickSort;
	}
	
	
}
