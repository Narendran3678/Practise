package com.stack;

import java.util.Arrays;


@SuppressWarnings("unchecked")
public class Stacks<T> {
	private int size=5;
	private T arr[];
	private int pointer ;
	private int minValue = 99999;
	private int maxValue = 0;
	public Stacks()
	{
		arr = (T[]) new Object[size];
		pointer=-1;
	}
	public void push(T data)
	{
		if(pointer+1>=size)
		{
			arr = reinitializeArray(size+size);
		}
		arr[++pointer]=data;
		if((int)data<minValue)
		{
			minValue=(int)data;
		}
		if((int)data>maxValue)
		{
			maxValue=(int)data;
		}
		System.out.println("Data inserted....."+arr[pointer]);
	}
	public void pop()
	{		
		if(pointer<0)
		{
			throw new ArrayIndexOutOfBoundsException("Stack Limit Below Zero");
		}
		T data = arr[pointer];
		arr[pointer]=null;
		pointer--;
		if(pointer<(size/2))
		{
			reinitializeArray(-size);
		}
		System.out.println("Data Removed....."+data);
	}
	private T[] reinitializeArray(int tsize)
	{
		size=size+(tsize/2);
		//System.out.println("Stack Size Changed to "+size);
		return Arrays.copyOf(arr, size);
	}
	public int min()
	{
		return minValue;
	}
	public int max()
	{
		return maxValue;
	}
	public void iterate()
	{
		for(int i=0;i<size;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	public boolean isEmpty()
	{
		if(pointer==-1)
			return true;
		else 
			return false;
	}
	public boolean isFull()
	{
		if(pointer==size-1)
			return true;
		else 
			return false;
	}
	
	public int getSize() {
		return pointer;
	}
	public static void main(String args[])
	{
		Stacks<Integer> stack = new Stacks<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		stack.push(7);
		System.out.println("Stack Full Status..."+stack.isFull()+" isEmpty..."+stack.isEmpty()+" Min..."+stack.min()+" Max.."+stack.max());
		stack.iterate();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(8);
		stack.push(6);
		stack.push(7);
		stack.pop();
		stack.pop();
		stack.iterate();
		System.out.println("Stack Full Status..."+stack.isFull()+" isEmpty..."+stack.isEmpty()+" Min..."+stack.min()+" Max.."+stack.max());
	}
}
