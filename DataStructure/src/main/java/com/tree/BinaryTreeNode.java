package com.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeNode<T> {
	private T data;
	private BinaryTreeNode<T> left = null;
	private BinaryTreeNode<T> right = null;
	private int height= 0;
	public BinaryTreeNode(T data)
	{
		this.data =data;
	}
	
	public void insertChild(BinaryTreeNode<T> node) {		
		if(this.left == null)
		{
			this.left=node;
		}
		else if(this.right == null)
		{
			this.right=node;
		}
		else 
		{
			System.out.println("Tree Filed");
		}
	}
	public void print(BinaryTreeNode<T> node)
	{
		print(node,"");
	}
	public void print(BinaryTreeNode<T> node , String space)
	{
		BinaryTreeNode<T> currNode=node;
		System.out.println(space+currNode.data);
		if(currNode.right==null && currNode.left==null)
			return;
		
		print(currNode.left,space+=" ");
		print(currNode.right,space);
	}
	public void preOrderTraversal(BinaryTreeNode<T> node)
	{
		BinaryTreeNode<T> currNode=node;
		System.out.print(" -> "+currNode.data);
		if(currNode.right==null && currNode.left==null)
		{	
			return;
		}
		preOrderTraversal(currNode.left);
		preOrderTraversal(currNode.right);
	}
	public void inOrderTraversal(BinaryTreeNode<T> node)
	{
		BinaryTreeNode<T> currNode=node;
		if(currNode.right==null && currNode.left==null)
		{
			System.out.print(" -> "+currNode.data);
			return;
		}
		inOrderTraversal(currNode.left);
		System.out.print(" -> "+currNode.data);
		inOrderTraversal(currNode.right);
	}
	public void postOrderTraversal(BinaryTreeNode<T> node)
	{
		BinaryTreeNode<T> currNode=node;
		if(currNode.right==null && currNode.left==null)
		{
			System.out.print(" -> "+currNode.data);
			return;
		}
		postOrderTraversal(currNode.left);
		postOrderTraversal(currNode.right);
		System.out.print(" -> "+currNode.data);
	}
	public void levelOrderTraversal(BinaryTreeNode<T> node)
	{
		Queue<BinaryTreeNode<T>> queue = new LinkedList<BinaryTreeNode<T>>();
		queue.add(node);
		
		while(!queue.isEmpty())
		{
			BinaryTreeNode<T> tNode =  queue.remove();
			System.out.print(" -> "+tNode.data);
			if(tNode.left!=null) {
				queue.add(tNode.left);
			}
			if(tNode.right!=null) {
				queue.add(tNode.right);
			}
		}
	}
	
	public int maxDepth(BinaryTreeNode<T> node)
    {
		int lDepth=0;
		int rDepth=0;
        if (node == null)
            return 0;
        else {
            lDepth = maxDepth(node.left);
            rDepth = maxDepth(node.right);
            /* use the larger one */
            if (lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
        }
    }
	/*
			 				    				  DRINK
			 		Hot															  Cold
		Tea 					 Coffee							Non-Alcoholic 		  		Alcoholic
GreenTea	BlackTea		Latte      Cappachino		  Mogito			 STING 		 Rum		 Gin
	*/
	public static void drinkTree()
	{
		BinaryTreeNode<String> DRINK =  new BinaryTreeNode<String>("DRINKS");
			BinaryTreeNode<String> HOT =  new BinaryTreeNode<String>("HOT");
				BinaryTreeNode<String> TEA =  new BinaryTreeNode<String>("TEA");
					BinaryTreeNode<String> GREENTEA =  new BinaryTreeNode<String>("GREENTEA");
					BinaryTreeNode<String> BLACKTEA =  new BinaryTreeNode<String>("BLACKTEA");
				BinaryTreeNode<String> COFFEE =  new BinaryTreeNode<String>("COFFEE");
					BinaryTreeNode<String> LATTE =  new BinaryTreeNode<String>("LATTE");
					BinaryTreeNode<String> CAPPACHINA =  new BinaryTreeNode<String>("CAPPACHINA");
			BinaryTreeNode<String> COLD =  new BinaryTreeNode<String>("COLD");
				BinaryTreeNode<String> ALCOHOLIC =  new BinaryTreeNode<String>("ALCOHOLIC");
					BinaryTreeNode<String> RUM =  new BinaryTreeNode<String>("RUM");
					BinaryTreeNode<String> GIN =  new BinaryTreeNode<String>("GIN");
				BinaryTreeNode<String> NONALCOHOLIC =  new BinaryTreeNode<String>("NONALCOHOLIC");
					BinaryTreeNode<String> MOGGITO =  new BinaryTreeNode<String>("MOGGITO");
					BinaryTreeNode<String> STING =  new BinaryTreeNode<String>("STING");
						//BinaryTreeNode<String> STING1 =  new BinaryTreeNode<String>("STING1");
						//BinaryTreeNode<String> STING2 =  new BinaryTreeNode<String>("STING2");

		TEA.insertChild(GREENTEA);
		TEA.insertChild(BLACKTEA);
		COFFEE.insertChild(LATTE);
		COFFEE.insertChild(CAPPACHINA);
		ALCOHOLIC.insertChild(RUM);
		ALCOHOLIC.insertChild(GIN);
		//STING.insertChild(STING1);
		//STING.insertChild(STING2);
		NONALCOHOLIC.insertChild(MOGGITO);
		NONALCOHOLIC.insertChild(STING);
		HOT.insertChild(TEA);
		HOT.insertChild(COFFEE);
		COLD.insertChild(NONALCOHOLIC);
		COLD.insertChild(ALCOHOLIC);
		DRINK.insertChild(HOT);
		DRINK.insertChild(COLD);	
		
		int height = DRINK.maxDepth(DRINK);
		System.out.print("Height="+height);
		
		
		System.out.println();
		System.out.print("Pre Order Traversal=");
		DRINK.preOrderTraversal(DRINK);
		
		System.out.println();
		System.out.print("In Order Traversal=");
		DRINK.inOrderTraversal(DRINK);
		
		System.out.println();
		System.out.print("Post Order Traversal=");
		DRINK.postOrderTraversal(DRINK);
		
		
		System.out.println();
		System.out.print("Level Order Traversal=");
		DRINK.levelOrderTraversal(DRINK);
		
		
		
	}
	public static void traversal()
	{
		BinaryTreeNode<String> DRINK =  new BinaryTreeNode<String>("N1");
			BinaryTreeNode<String> HOT =  new BinaryTreeNode<String>("N2");
				BinaryTreeNode<String> TEA =  new BinaryTreeNode<String>("N4");
					BinaryTreeNode<String> GREENTEA =  new BinaryTreeNode<String>("N8");
					BinaryTreeNode<String> BLACKTEA =  new BinaryTreeNode<String>("N9");
				BinaryTreeNode<String> COFFEE =  new BinaryTreeNode<String>("N5");
					BinaryTreeNode<String> LATTE =  new BinaryTreeNode<String>("N10");
					BinaryTreeNode<String> CAPPACHINA =  new BinaryTreeNode<String>("N11");
			BinaryTreeNode<String> COLD =  new BinaryTreeNode<String>("N3");
				BinaryTreeNode<String> ALCOHOLIC =  new BinaryTreeNode<String>("N6");
					BinaryTreeNode<String> RUM =  new BinaryTreeNode<String>("N12");
					BinaryTreeNode<String> GIN =  new BinaryTreeNode<String>("N13");
				BinaryTreeNode<String> NONALCOHOLIC =  new BinaryTreeNode<String>("N7");
					BinaryTreeNode<String> MOGGITO =  new BinaryTreeNode<String>("N14");
					BinaryTreeNode<String> STING =  new BinaryTreeNode<String>("N15");

		TEA.insertChild(GREENTEA);
		TEA.insertChild(BLACKTEA);
		COFFEE.insertChild(CAPPACHINA);
		COFFEE.insertChild(LATTE);
		ALCOHOLIC.insertChild(RUM);
		ALCOHOLIC.insertChild(GIN);
		NONALCOHOLIC.insertChild(MOGGITO);
		NONALCOHOLIC.insertChild(STING);
		HOT.insertChild(TEA);
		HOT.insertChild(COFFEE);
		COLD.insertChild(ALCOHOLIC);
		COLD.insertChild(NONALCOHOLIC);
		DRINK.insertChild(HOT);
		DRINK.insertChild(COLD);
	}
	public static void main(String[] args) {
		drinkTree();
		//traversal();
		System.exit(0);
	}
	
}
