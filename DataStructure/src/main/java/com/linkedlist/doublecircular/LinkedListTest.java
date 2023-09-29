package com.linkedlist.doublecircular;


public class LinkedListTest {
	public static void main(String args[])
	{
		circularDoubleLinkedList();
	}
	public static void circularDoubleLinkedList()
	{
		DoubleCircularLinkedList<Integer> doubleList = new DoubleCircularLinkedList<>();
		doubleList.add(1);
		doubleList.add(2);
		doubleList.add(4);
		doubleList.add(5);
		doubleList.add(6);
		doubleList.put(2,3);
		System.out.println("After Insert...");
		doubleList.iterate();
		
		
		System.out.println("After Delete...");
		doubleList.remove(6);
	//	doubleList.iterate();
		
		System.out.println("After Head First...");
		doubleList.addFirst(-1);
		doubleList.addFirst(-2);
		doubleList.iterate();
		System.out.println();
		doubleList.getHeadTailInfo();
	}
}
