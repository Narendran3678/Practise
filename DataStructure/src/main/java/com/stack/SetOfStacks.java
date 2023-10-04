package com.stack;

import java.util.*;

class StackNode<T> {
	public StackNode<T> above = null;
	public T value;
	public StackNode<T> below = null;

	public StackNode(T value) {
		this.value = value;
	}
}

class StackG<T> {
	private StackNode<T> top = null;
	private StackNode<T> bottom = null;
	private int capacity = 5;
	private int size;

	public StackG() {

	}

	public StackG(int capacity) {
		this.capacity = capacity;
	}

	public boolean isFull() {
		return capacity == size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean push(T data) {
		if (isFull()) {
			System.out.println("Stack is Full");
			return false;
		}
		size++;
		StackNode<T> newNode = new StackNode<T>(data);
		if (size == 1)
			bottom = newNode;

		joinNode(newNode, top);
		top = newNode;
		return true;
	}

	public void joinNode(StackNode<T> newNode, StackNode<T> currentTop) {
		if (newNode != null)
			newNode.below = currentTop;
		if (currentTop != null)
			currentTop.above = newNode;
	}

	public boolean pop() {
		if (isEmpty()) {
			System.out.println("Stack is Empty");
			return false;
		}
		StackNode<T> tempNode = top.below;
		top = tempNode;
		if (top != null)
			top.above = null;
		size--;
		return true;
	}

	public void iterate() {
		StackNode<T> currNode = bottom;
		for (int i = 0; i < size; i++) {
			System.out.print(currNode.below != null ? currNode.below.value : null);
			System.out.print(" <- ");
			System.out.print(currNode.value);
			System.out.print(" -> ");
			System.out.print(currNode.above != null ? currNode.above.value : null);
			System.out.println();
			currNode = currNode.above;
		}
	}
}

public class SetOfStacks<T> {
	private int capacity = 0;
	private List<StackG<T>> stackList = new ArrayList<StackG<T>>();

	public SetOfStacks() {

	}

	public SetOfStacks(int capacity) {
		this.capacity = capacity;
	}

	public int getSize() {
		return stackList.size();
	}

	public StackG<T> getLastStack() {
		if (stackList.size() == 0)
			return null;
		return stackList.get(stackList.size() - 1);
	}

	public boolean push(T data) {
		try {
			if (getLastStack() != null && !getLastStack().isFull()) {
				StackG<T> lastStack = getLastStack();
				lastStack.push(data);
			} else {
				StackG<T> stack = new StackG<>(capacity);
				stack.push(data);
				stackList.add(stack);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean pop() {
		try {
			StackG<T> lastStack = getLastStack();
			if (lastStack != null && !lastStack.isEmpty()) {
				lastStack.pop();
			} else {
				stackList.remove(stackList.size()-1);
				System.out.println("Empty Stack Removed");
				lastStack = getLastStack();
				if(!lastStack.isEmpty())
					lastStack.pop();
				else
					System.out.println("Not Stack");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public void iterate() {
		for (StackG<T> stack : stackList) {
			stack.iterate();
			System.out.println();
		}
	}
	public void popAt(int index)
	{
		if(stackList.size()>=index)
		{
			StackG<T> s = stackList.get(index-1);
			if(s.isEmpty())
			{
				stackList.remove(s);
			}
			else
			{
				s.pop();
			}
		}
		else
		{
			System.out.println("Index Not Found");
		}
	}

	public static void main(String args[]) {
		/*
		 * StackG<Integer> stackg = new StackG<Integer>(); stackg.push(1);
		 * stackg.push(2); stackg.push(3); stackg.push(4); stackg.iterate();
		 * 
		 * stackg.pop(); stackg.pop(); stackg.pop(); stackg.pop(); System.out.println();
		 * stackg.iterate();
		 */
		SetOfStacks<Integer> stackSet = new SetOfStacks<>(3);
		stackSet.push(1);
		stackSet.push(2);
		stackSet.push(3);
		stackSet.push(4);
		stackSet.push(5);
		stackSet.push(6);
		stackSet.push(7);
		stackSet.push(8);
		stackSet.push(9);
		/*
		stackSet.iterate();
		stackSet.pop();
		stackSet.pop();
		stackSet.pop();
		stackSet.pop();*/
		
		System.out.println("After Pop...");
		stackSet.popAt(2);
		stackSet.popAt(2);
		stackSet.popAt(2);
		stackSet.popAt(1);
		stackSet.popAt(1);
		stackSet.popAt(1);
		
		stackSet.iterate();
	}
}
