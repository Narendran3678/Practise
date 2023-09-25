package com.linkedlist.singlelinkedlist;

public class SingleLinkedList<T> {
	private Node head = null;
	private Node tail = null;
	private int size = 0;

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
		while (iterateNode != null) {
			System.out.println(iterateNode.value);
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
		while (currentNode != null)
		{
			if (c == location) {
				currentNode.next = currentNode.next.next;
			}
			currentNode = currentNode.next;
			c++;
		}
		return status;
	}
	public boolean addFirst(T value) {
		boolean status = false;
		Node newNode = new Node(value);
		newNode.next=head;
		head=newNode;
		return status;
	}
	public int getSize() {
		return size;
	}

	private class Node {
		T value;
		Node next;

		public Node() {
		}

		public Node(T value) {
			this.value = value;
			this.next = null;
		}
	}

	@Override
	public String toString() {
		iterate();
		return "";
	}
	
	
}
