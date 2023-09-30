package com.linkedlist.doublecircular;


public class DoubleCircularLinkedList<T> {
	class Node {
		int address=100;
		Node previous;
		T value;
		Node next;
		public Node() {

		}
		public Node(T value) {
			this.previous = null;
			this.value = value;
			this.next = null;
		}
		@Override
		public String toString() {
			return "(NodeValue=" + value +")";
		}
		
	}

	Node head = null;
	Node tail = null;
	private int size = 0;

	public void add(T value) {
		
		Node newNode = new Node(value);
		if (size == 0) {
			head = newNode;
			tail = newNode;
			newNode.next = newNode;
			newNode.previous = newNode;
		} else {
			newNode.previous=tail;
			newNode.next=head;
			head.previous=newNode;
			tail.next=newNode;
			tail=newNode;
		}
		size++;
	}

	public void put(int position, T value) {
		// [100 | 1 |102] , [101 | 2 |103] , [102 | 3 |104] , [103 | 4 |100]
		//      [101]			 [102]			  [103]			   [104]
		
		Node newNode = new Node(value);
		Node currentCursor = head;
		for(int i=1;i<=size;i++)
		{
			if(i==position)
			{
				currentCursor.next.previous=newNode;
				newNode.next = currentCursor.next;
				newNode.previous=currentCursor;
				currentCursor.next=newNode;
				if(position==size)
				{
					tail=newNode;
				}
				size++;
			}
			currentCursor=currentCursor.next;
		}
	}

	public void remove(int position) {
		// [100 | 1 |102] , [101 | 2 |103] , [102 | 3 |104] , [103 | 4 |100]
		//      [101]			 [102]			  [103]			   [104]
		Node currentCursor = head;
		int tSize = size;
		for(int i=1;i<=tSize;i++)
		{
			if(i==position)
			{
				if(position==size)
				{
					tail=currentCursor.previous;
				}
				currentCursor.previous.next = currentCursor.next;
				currentCursor.next.previous = currentCursor.previous;
				currentCursor=null;
				size--;
				break;
			}
			currentCursor =currentCursor.next;
		}
	}
	public void getHeadTailInfo()
	{
		System.out.println("HeadNode Value.."+head.value+" <-> TailNode Value.."+tail.value);
	}
	
	public void addFirst(T data)
	{
		Node tempNode = head;
		Node newNode = new Node(data);
		head=newNode;
		tempNode.previous= newNode;
		newNode.next=tempNode;
		newNode.previous= tail;
		tail.next=newNode;
		size++;
	}
	public void iterate() {
		Node iteration = head;
		for(int i=1;i<=size+1;i++)
		{
			System.out.println("[ "+iteration.previous+" <- "+iteration.value+" -> "+iteration.next+" ]");
			iteration=iteration.next;
		}
	}

	public int getSize() {
		return size;
	}

	@Override
	public String toString() {
		this.iterate();
		return "";
	}

}
