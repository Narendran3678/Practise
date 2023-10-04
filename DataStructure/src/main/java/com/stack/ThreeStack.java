package com.stack;

public class ThreeStack {
	private int[] sizes;
	private int numberOfStacks=3;
	private int eachCapacity;
	private int stackArr[];
	private int totalArrSize ;
	public ThreeStack(int eachCapacity)
	{
		this.eachCapacity =eachCapacity;
		this.sizes = new int[numberOfStacks];
		this.stackArr = new int[numberOfStacks * eachCapacity];
		this.totalArrSize = numberOfStacks * eachCapacity;
	}
	
	public boolean isFull(int stackNumber)
	{
		if(sizes[stackNumber]== (eachCapacity))
		{
			return true;
		}
		return false;
	}
	public boolean isEmpty(int stackNumber)	
	{
		if(sizes[stackNumber]== 0)
		{
			return true;
		}
		return false;
	}
	
	// 1 | 2 | 3 |  4 | 5 | 6  | 7 | 8 | 9
	// 0 | 1 | 2 |  3 | 4 | 5  | 6 | 7 | 8  
	public boolean push(int stackNumber , int data)
	{
		stackNumber = stackNumber-1;
		if(isFull(stackNumber))
		{
			System.out.println("Stack "+stackNumber+" is Full");
			return false;
		}
		int currentCursor = 0;
		if(stackNumber ==0)
		{
			currentCursor = ((( (totalArrSize-1)/2) - 1) - eachCapacity) + sizes[stackNumber];
		}
		else if(stackNumber ==1)
		{
			currentCursor =(( (((totalArrSize-1)/2) -1)+ eachCapacity) - eachCapacity)  + sizes[stackNumber];
		}
		else if(stackNumber ==2)
		{
			currentCursor = (totalArrSize  - eachCapacity) + sizes[stackNumber];
		}
		
		stackArr[currentCursor] = data;
		sizes[stackNumber] = ++sizes[stackNumber];
		
		return true;
	}
	// 1 | 2 | 3 |  4 | 5 | 6  | 7 | 8 | 9
	// 0 | 1 | 2 |  3 | 4 | 5  | 6 | 7 | 8 
	public boolean pop(int stackNumber )
	{
		stackNumber = stackNumber-1;
		if(isEmpty(stackNumber))
		{
			System.out.println("Stack "+stackNumber+" is Empty");
			return false;
		}
		int currentCursor = 0;
		if(stackNumber ==0)
		{
			currentCursor = ((( (totalArrSize-1)/2) - 2) ) - (eachCapacity - sizes[stackNumber]);
			//System.out.println("CurrentCursor"+currentCursor+" totalArrSize="+totalArrSize+" SIze="+sizes[stackNumber]);
		}
		else if(stackNumber ==1)
		{
			currentCursor =((((totalArrSize-1)/2) -2) + eachCapacity)  - (eachCapacity - sizes[stackNumber]);
		}
		else if(stackNumber ==2)
		{
			currentCursor = (totalArrSize - 1) - (eachCapacity - sizes[stackNumber]);
		}
		
		stackArr[currentCursor] = 0;
		sizes[stackNumber] = --sizes[stackNumber];
		
		return true;
	}
	public void iterate()
	{
		int stackNumber =1;
		System.out.print("\nStack "+stackNumber+"...");
		for(int i=0;i< stackArr.length;i++) {
			System.out.print(stackArr[i]+" ");
			if((i+1)%4==0 && i+1!=stackArr.length) {
				stackNumber++;
				System.out.print("\nStack "+stackNumber+"...");
			}
		}
	}
	public static void main(String args[])
	{
		ThreeStack ms = new ThreeStack(4);
		ms.push(2, 4);
		ms.push(2, 5);
		ms.push(2, 6);
		ms.push(2, 6);
		
		ms.push(1, 1);
		ms.push(1, 2);
		ms.push(1, 3);
		ms.push(1, 3);
		
		ms.push(3, 7);
		ms.push(3, 8);
		ms.push(3, 9);
		ms.push(3, 9);
		ms.iterate();
		System.out.println();
		ms.pop(1);
		ms.pop(1);
		ms.pop(1);
		ms.pop(1);
		ms.pop(1);
		ms.pop(2);
		ms.pop(2);
		ms.pop(2);
		
		ms.pop(3);
		ms.pop(3);
		ms.iterate();
		
	}
}
