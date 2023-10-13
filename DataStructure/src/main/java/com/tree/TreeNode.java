package com.tree;

import java.util.*;

public class TreeNode<T> {
	public T data;
	public List<TreeNode<T>> childerNode ;
	public TreeNode(T data)
	{
		this.data =data;
		childerNode = new ArrayList<>();
	}
	
	public void insertChild(TreeNode<T> node) {		
		this.childerNode.add(node);
	}
	
	public void print(TreeNode<T> node , String space)
	{
		TreeNode<T> currNode=node;
		System.out.println(space+currNode.data);
		for(TreeNode<T> tNode:currNode.childerNode)
		{
			print(tNode,space+"--");
		}
	}
	public void print(TreeNode<T> node)
	{
		print(node,"");
	}
	public static void main(String[] args) {
		TreeNode<String> DRINK =  new TreeNode<String>("DRINKS");
			TreeNode<String> HOT =  new TreeNode<String>("HOT");
				TreeNode<String> TEA =  new TreeNode<String>("TEA");
					TreeNode<String> GREENTEA =  new TreeNode<String>("GREENTEA");
				TreeNode<String> COFFEE =  new TreeNode<String>("COFFEE");
					TreeNode<String> CAPPACHINA =  new TreeNode<String>("CAPPACHINA");
				TreeNode<String> MILK =  new TreeNode<String>("MILK");
			TreeNode<String> COLD =  new TreeNode<String>("COLD");
				TreeNode<String> ALCOHOLIC =  new TreeNode<String>("ALCOHOLIC");
					TreeNode<String> RUM =  new TreeNode<String>("RUM");
					TreeNode<String> GIN =  new TreeNode<String>("GIN");
					TreeNode<String> VODKA =  new TreeNode<String>("VODKA");
				TreeNode<String> NONALCOHOLIC =  new TreeNode<String>("NONALCOHOLIC");
					TreeNode<String> MOGGITO =  new TreeNode<String>("MOGGITO");
		
		TEA.insertChild(GREENTEA);
		COFFEE.insertChild(CAPPACHINA);
		ALCOHOLIC.insertChild(RUM);
		ALCOHOLIC.insertChild(GIN);
		ALCOHOLIC.insertChild(VODKA);
		NONALCOHOLIC.insertChild(MOGGITO);
		HOT.insertChild(TEA);
		HOT.insertChild(COFFEE);
		HOT.insertChild(MILK);
		COLD.insertChild(ALCOHOLIC);
		COLD.insertChild(NONALCOHOLIC);
		DRINK.insertChild(HOT);
		DRINK.insertChild(COLD);	
		
		DRINK.print(DRINK);
	}
	
}
