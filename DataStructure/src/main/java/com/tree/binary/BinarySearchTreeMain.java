package com.tree.binary;

class BinarySearchTree {
	private int value = 0;
	private BinarySearchTree left = null;
	private BinarySearchTree right = null;
	
	public BinarySearchTree(int value) {
		this.value = value;
	}
	/*
	 				70
	 		50				90
	 	30		60		80		100
	*/
	public void insert(BinarySearchTree currentNode,int data) {		
		if(currentNode.value<= data) {
			if(currentNode.left !=null) {
				insert(currentNode.left,data);
			}
			else {
				//System.out.println("Data Left  ["+currentNode.value+"] ["+data+"] Inserted");
				currentNode.left = new BinarySearchTree(data);
			}
		}
		else {
			if(currentNode.right !=null) {
				insert(currentNode.right,data);
			}
			else {
				//System.out.println("Data Right ["+currentNode.value+"] ["+data+"] Inserted");
				currentNode.right = new BinarySearchTree(data);
			}
		}
	}
	public void print(BinarySearchTree currentNode)
	{
		print(currentNode,"");
	}
	public void print(BinarySearchTree currentNode,String space)
	{
		if(currentNode.right==null && currentNode.left==null)	{
			System.out.println(space+currentNode);
			return ;
		}
		System.out.println(space+currentNode);
		space+="  ";
		print(currentNode.left,space);
		print(currentNode.right,space);
	}
	@Override
	public String toString() {
		return String.valueOf(value);
	}
	
}


public class BinarySearchTreeMain {
	public static void main(String args[]) {
		BinarySearchTree bst = new BinarySearchTree(70);
		bst.insert(bst, 50);
		bst.insert(bst, 90);
		bst.insert(bst, 30);
		bst.insert(bst, 60);
		bst.insert(bst, 80);
		bst.insert(bst, 100);
		bst.print(bst);
	}
}