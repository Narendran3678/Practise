package com.linkedlist.singlelinkedlist;

import java.util.LinkedList;

public class LinkedListTest {
	public static void main(String args[])
	{
		SingleLinkedList<Integer> single = new SingleLinkedList<>();
		single.add(1);
		single.add(2);
		single.add(4);
		single.add(5);
		single.put(2,3);
		single.remove(4);
		single.addFirst(-1);
		single.addFirst(-2);
		System.out.println("After Inserting");
		System.out.println(single);
		
		System.out.println();
		LinkedList<Integer> test = new LinkedList<>();
		test.add(1);
		test.add(2);
		test.add(4);
		test.add(5);
		test.add(2, 3);
		test.remove(1);
		System.out.println(test);
	}
}
