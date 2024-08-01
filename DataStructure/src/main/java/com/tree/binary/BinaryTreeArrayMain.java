package com.tree.binary;

import java.util.Arrays;

class BinaryTreeArray
{
	private int arraySize = 8;
	private int arr[];
	private int size =1;
	
/*  To Find Left Node = ( 2 * currentPosition )
	To Find Right Node = ( 2 * currentPosition ) + 1

		........ >>>>>>>>>>>>>>>>
		|   |  | |			|	|
  | X | 1 | 2 | 3 | 4 | 5 | 6 | 7 |
			|		|	|
			>>>>>>>>>>>>>	
*/
	public BinaryTreeArray() {
		arr = new int[arraySize];
	}
	public void insert(int data) 	{
		if(!isFull()) {
			arr[size++]=data;
		}
		else
		{
			arr = resize(arr);
			arr[size++]=data;
	//		System.out.println("Tree Filled resizing for ["+data+"] to Length["+arr.length+"] CurrSize["+size+"]");			
		}
	}

	
	public boolean isFull()
	{
		if(size==arraySize)
			return true;
		return false;
	}
	public boolean isEmpty()
	{
		if(size==0)
			return true;
		return false;
	}
	public int[] resize(int[] arr) {
		arraySize +=2;
		return Arrays.copyOf(arr, arraySize);
	}
	public int getSize() {
		return size;
	}
/*
							1
			2 								3
	4				5				6    			7
8		9		10		11		12		13		14		15	
*/	
	public void print(int i, String space)
	{
		int leftPosition=0,currNode = 0,rightPosition=0;
		if(isEmpty() || i >= size) {
			return;
		}
		currNode = arr[i];
		System.out.println(space+currNode);
		leftPosition = i*2;
		rightPosition = (i*2)+1;
		
		if( rightPosition < size || leftPosition<size ) { // -> Added Condition (leftPosition<size) to display even when single node exist
			space = space+"  ";
			print(leftPosition,space);
			print(rightPosition,space);
		}
	}
	/*
								1
				2 								3
		4				5				6    			7
	*/	
	public void inOrderTraversal(int i) // Left -> Root -> Right  -> 4-> 2-> 5-> 1-> 6-> 3-> 7
	{
		int leftPosition = 0,currNode = 0,rightPosition = 0;
		if(isEmpty() || i >= size) {
			return;
		}
		currNode = arr[i];
		leftPosition = i*2;
		rightPosition = (i*2)+1;
		
		inOrderTraversal(leftPosition);
		System.out.print("-> "+currNode);
		inOrderTraversal(rightPosition);
		
	}
	public void preOrderTraversal(int i ) { // Root -> Left -> Right -> 1-> 2-> 4-> 5-> 3-> 6-> 7
		int leftPosition = 0,currNode = 0,rightPosition = 0;
		if(isEmpty() || i >= size) {
			return;
		}
		currNode = arr[i];
		leftPosition = i*2;
		rightPosition = (i*2)+1;
		
		System.out.print("-> "+currNode);
		preOrderTraversal(leftPosition);
		preOrderTraversal(rightPosition);
	}
	public void postOrderTraversal(int i ) { // Left -> Right -> Root -> 1-> 2-> 4-> 5-> 3-> 6-> 7
		int leftPosition = 0,currNode = 0,rightPosition = 0;
		if(isEmpty() || i >= size) {
			return;
		}
		currNode = arr[i];
		leftPosition = i*2;
		rightPosition = (i*2)+1;
		
		postOrderTraversal(leftPosition);
		postOrderTraversal(rightPosition);
		System.out.print("-> "+currNode);
	}
	public void levelOrderTraversal() {
		for(int i = 1;i<size;i++)
		{
			System.out.print("-> "+arr[i]);
		}
	}
	public int search(int searchItem) {
		for(int i = 1;i<size;i++)
		{
			if(searchItem ==arr[i]) {
				System.out.println("Item Found");
				return i;
			}
		}
		return -1;
	}
}

public class BinaryTreeArrayMain {
	public static void main(String[] args) {
		BinaryTreeArray binaryTree = new BinaryTreeArray();
		binaryTree.insert(1);
		binaryTree.insert(2);
		binaryTree.insert(3);
		binaryTree.insert(4);
		binaryTree.insert(5);
		binaryTree.insert(6);
		binaryTree.insert(7);
		/*binaryTree.insert(8);
		binaryTree.insert(9);
		binaryTree.insert(10);
		binaryTree.insert(11);
		binaryTree.insert(12);
		binaryTree.insert(13);
		binaryTree.insert(14);
		binaryTree.insert(15);*/
		//binaryTree.print(1,"");
		binaryTree.inOrderTraversal(1);
		System.out.println();
		binaryTree.preOrderTraversal(1);
		System.out.println();
		binaryTree.postOrderTraversal(1);
		System.out.println();
		binaryTree.levelOrderTraversal();
		System.out.println();
		System.out.println(binaryTree.search(3));
	}
}
