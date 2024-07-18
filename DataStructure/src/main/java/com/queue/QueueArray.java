package com.queue;

@SuppressWarnings("unchecked")
public class QueueArray<T> {
	
	private int front;
	private int rear;
	private T[] arr;
	private int MAX_SIZE=10;
	private int currSize=0;
	public QueueArray()
	{
		arr = (T[]) new Object[MAX_SIZE];
		front=rear=-1;
	}
	public boolean push(T data) {
		boolean status=false;
		try
		{
			if(isFull())
			{
				System.out.println("Queue is Full");
				return false;
			}
			
			if(rear+1>=MAX_SIZE && front>0)
			{
				rear=-1;
			}
			if(front==-1 && rear==-1)
			{
				front++;
				rear++;
				arr[rear]=data;
				
			}
			else
			{
				rear++;	 
				arr[rear]=data;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status=false;
		}
		return status;
	}
	public boolean pop() {
		boolean status=false;
		if(isEmpty()) {
			System.out.println("Queue is Empty");
			return false;
		}
		T data = arr[front];
		arr[front]=null;
		if(front==rear)
		{
			rear++;
		}
		front++;
		System.out.println("Data Removed="+data);
		return status;
	}
	public boolean isEmpty()
	{
		if(rear-front==-1 || (front==-1 || rear==-1))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean isFull()
	{
		//System.out.println("Front ="+front+", Rear="+rear);
		if( front>rear && front-rear==1) 
			return true;
		else if(front==0 && front<rear && rear>=MAX_SIZE)
			return true;
		else
			return false;
		
	}
	public int size()
	{
		if(front>rear)
			currSize = (MAX_SIZE-front)+rear;
		else
			currSize = (rear)-front;
	
		return currSize;
	}
	@SuppressWarnings("unused")
	public void iterate()
	{
		System.out.println("Front ="+front+", Rear="+rear);
		if(front<0)
		{
			return ;
		}
		for(int i=front ;i<MAX_SIZE;i++)
		{
			if(arr[i]!=null)
				System.out.print(arr[i]+" ");
		}
		if(rear>=0 && front>rear)
		{
			for(int i=0 ;i<=rear;i++)
			{
				System.out.print(arr[i]+" ");
			}
		}
		if(false)
		{
			System.out.println();
			for(int i=0 ;i<5;i++)
			{
				System.out.print(arr[i]+" ");
			}
		}
		System.out.println();
	}
	public static void main(String args[])
	{
		QueueArray<Integer> queue = new QueueArray<>();
		queue.push(1);
		
		queue.push(2);
		queue.push(3);
		queue.push(4);
		queue.push(5);
		
		System.out.print("Queue Entry...");
		queue.iterate();
		
		queue.pop();
		System.out.print("After Queue Pop...");
		queue.iterate();
		
		System .out.print("After Queue Push...");
		queue.push(5);
		queue.push(6);
		queue.push(7);
		queue.push(7);
		
		queue.iterate();
		//System.out.println("\nQueue isEmpty="+queue.isEmpty()+", isFull="+queue.isFull()+", size="+queue.size());
		System.out.println("\nSize="+queue.size());
		
		
	}
}
