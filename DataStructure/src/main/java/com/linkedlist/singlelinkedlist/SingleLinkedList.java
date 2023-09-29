package com.linkedlist.singlelinkedlist;



class Question<T> {
	// [ 1 | 102] , [ 9 | 103] , [ 7 | 104] , [ -9 | 105], [ 2 | 106] , [ 6 | null]
	// 	 [101] 		   [102] 		[103] 		 [104] 		 [105]		  [106]
	public SingleLinkedList<T> partition(SingleLinkedList<T> list, int value) { // Not Tested For All case
		SingleLinkedList<T>.Node currentNode = list.head;
		list.tail = list.head;		
		for (int i = 0; i < list.size; i++) {
			SingleLinkedList<T>.Node next =  currentNode.next;
			if (Integer.valueOf(String.valueOf(currentNode.value)) < value) 
			{
				currentNode.next=list.head;
				list.head=currentNode;
			}
			else
			{
				list.tail.next=currentNode;
				list.tail=currentNode;
			}
			currentNode =  next;
		}
		list.tail.next = null;
		return list;
	}
	// [1 |102] ,[2 | 103] , [1 | 104] , [ 4 |null]
	// [101] [102] [103] [104]
	public void deleteDups(SingleLinkedList<T> list) {
		SingleLinkedList<T>.Node out = list.head;
		while (out != null) {
			SingleLinkedList<T>.Node inner = out;
			while (inner != null) {
				if (inner.next != null && out.value == inner.next.value) {
					SingleLinkedList<T>.Node temp = inner.next;
					inner.next = inner.next.next;
					temp.next = null;
					list.size--;
				}
				inner = inner.next;
			}
			out = out.next;
		}
	}

	public SingleLinkedList<T>.Node nthToLast(SingleLinkedList<T> list, int position) {
		SingleLinkedList<T>.Node returnNode = null;
		SingleLinkedList<T>.Node tempNode = list.head;
		for (int i = 0; i < list.size; i++) {
			if (i != ((list.size + 1) - position)) {
				returnNode = tempNode;
			}
			tempNode = tempNode.next;
		}
		return returnNode;
	}
	
	@SuppressWarnings("unchecked")
	public SingleLinkedList<T> sumList(SingleLinkedList<T> list1, SingleLinkedList<T> list2) {
		String s1 = "";
		String s2 = "";
		SingleLinkedList<T>.Node tempNode1 = list1.head;
		SingleLinkedList<T>.Node tempNode2 = list2.head;
		SingleLinkedList<T> sumList = new SingleLinkedList<>();
		for (int i = 0; i < list1.size; i++) {
			s1 = tempNode1.value + s1;
			s2 = tempNode2.value + s2;
			tempNode1 = tempNode1.next;
			tempNode2 = tempNode2.next;
		}
		String sum[] = String.valueOf(Integer.valueOf(s1) + Integer.valueOf(s2)).split("");
		for (int i = sum.length - 1; i >= 0; i--) {
			sumList.add((T) sum[i]);
		}
		return sumList;
	}
}

public class SingleLinkedList<T> {
	Node head = null;
	Node tail = null;
	int size = 0;

	public SingleLinkedList() {
		head = new Node();
		tail = new Node();
	}

	public void add(T value) {
		Node node = new Node();
		node.value = value;
		node.next = null;
		if (size == 0) {
			head = node;
			tail = node;
		} else {
			tail.next = node;
			tail = node;
		}
		size++;
	}

	public void iterate() {
		Node iterateNode = head;
		for (int i = 0; i < size; i++) {
			System.out.println("[ " + iterateNode.value + " -> " + iterateNode.next + " ]");
			iterateNode = iterateNode.next;
		}
	}

	public boolean put(int location, T value) {
		if (location > size) {
			throw new ArrayIndexOutOfBoundsException("Given Size Exceeds");
		}
		boolean status = false;
		Node currentNode = head;
		Node newNode = new Node(value);
		int c = 1;
		while (currentNode != null) {
			if (c == location) {
				Node temp = newNode;
				newNode.next = currentNode.next;
				currentNode.next = temp;

				status = true;
				size++;
				break;
			}
			currentNode = currentNode.next;
			c++;
		}
		return status;
	}

	public boolean remove(int location) {
		if (location >= size) {
			throw new ArrayIndexOutOfBoundsException("Given Location Exceeds");
		}
		boolean status = false;
		Node currentNode = head;
		int c = 1;
		while (currentNode != null) {
			if (c == location) {
				currentNode.next = currentNode.next.next;
				size--;
			}
			currentNode = currentNode.next;
			c++;
		}
		return status;
	}

	public boolean addFirst(T value) {
		boolean status = false;
		Node newNode = new Node(value);
		newNode.next = head;
		head = newNode;
		size++;
		return status;
	}

	public int getSize() {
		return size;
	}

	public boolean contains(T value) {
		boolean status = false;
		Node currentNode = head;
		while (currentNode != null) {
			if (currentNode.value == value) {
				return true;
			}
			currentNode = currentNode.next;
		}
		return status;
	}

	class Node {
		T value;
		Node next;

		public Node() {
		}

		public Node(T value) {
			this.value = value;
			this.next = null;
		}

		@Override
		public String toString() {
			return  value+"" ;
		}
	}

	@Override
	public String toString() {
		iterate();
		return "";
	}
	public static void main(String args[])
	{
		singleLinkedList();
	}
	public static void singleLinkedList()
	{
		Question<Integer> q = new Question<Integer>();
		SingleLinkedList<Integer> single = new SingleLinkedList<>();
		single.add(1);
		single.add(1);
		single.add(2);
		single.add(4);
		single.add(4);
		single.add(5);
		single.add(5);
		single.put(3,3);
		single.remove(4);
		single.addFirst(-1);
		single.addFirst(-2);
		System.out.println("After Inserting....");
		System.out.println(single);
		System.out.println("List Contain 9 = "+single.contains(9));
		
		System.out.println("After Removing Duplicates...");
		q.deleteDups(single);
		System.out.println(single);
		
		SingleLinkedList<Integer>  list1 = new SingleLinkedList<Integer> ();
		list1.add(7);
		list1.add(1);
		list1.add(6);
		SingleLinkedList<Integer>  list2 = new SingleLinkedList<Integer> ();
		list2.add(5);
		list2.add(9);
		list2.add(2);
		System.out.println("\nAfter Sum...");
		SingleLinkedList<Integer>  sumlist = q.sumList(list1,list2);
		sumlist.iterate();
		
		int nthValue = q.nthToLast(single, 2) != null ? q.nthToLast(single, 2).value : 0;
		System.out.println("\nValue at 2 Position from last...." + nthValue);
		
		System.out.println("Final List....");
		single.iterate();
		
		System.out.println("\nAfter Partition...");
		SingleLinkedList<Integer> single1 = new SingleLinkedList<>();
		single1.add(1);
		single1.add(2);
		single1.add(65);
		single1.add(-9);
		single1.add(4);
		single1.add(-90);
		single1 = q.partition(single1,3);
		single1.iterate();
	}
}