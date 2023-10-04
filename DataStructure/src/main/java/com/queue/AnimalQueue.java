package com.queue;

abstract class Animal {
	private int order;
	protected abstract String name();
	protected abstract String type();
	public void setOrder(int order) {
		this.order = order;
	}
	public int getOrder() {
		return order;
	}
}

class Cat extends Animal {
	private String name;

	public Cat(String name) {
		this.name = name;	}

	public String name() {
		return name;
	}
	@Override
	protected String type() {		
		return "Cat";
	}
	@Override
	public String toString() {
		return "Cat [name=" + name + "]";
	}	
}

class Dog extends Animal {
	private String name;

	public Dog(String name) {
		this.name = name;
	}

	public String name() {
		return name;
	}
	@Override
	protected String type() {		
		return "Dog";
	}
	@Override
	public String toString() {
		return "Dog [name=" + name + "]";
	}
	
}
class Node
{
	public Node prev;
	public Animal value;
	public Node next;
	
	public Node(Animal value)
	{
		this.value=value;
	}
}
public class AnimalQueue {
	private Node head =null; 
	private Node tail =null;
	private int size ;
	public void enqueue(Animal animal) {
		Node newNode = new Node(animal);
		if(size==0)
		{
			head = newNode;
			tail = newNode;
		}
		tail.next=newNode;
		newNode.prev=tail;
		tail = newNode;
		size++;
		animal.setOrder(size);
	}
	public Animal dequeueAny() {
		Animal animal =null;
		if(size>0)
		{
			animal = head.value;
			head = head.next;
			size--;
		}
		if(animal!=null)
			System.out.println(animal.type()+" "+animal.name()+" Exited");
		else
			System.out.println("No Animal in Shelter");
		return animal;
	}
	public Animal dequeueDogs() {
		Animal animal =null;
		Node node = head;
		for(int i=0;i<size;i++)
		{
			if(node.value instanceof Dog)
			{
				animal=node.value;
				if(node==head)
				{
					if(node!=null)
						head=node.next;
				}
				else
				{	
					node.prev.next=node.next;
				}
				size--;
				break;
			}
			node =  node.next;
		}
		if(animal!=null)
			System.out.println(animal.type()+" "+animal.name()+" Exited");
		else
			System.out.println("No Dogs in Shelter");
		return animal;
	}
	public Animal dequeueCats() {
		Animal animal =null;
		Node node = head;
		for(int i=0;i<size;i++)
		{
			if(node.value instanceof Cat)
			{
				animal=node.value;
				if(node==head)
				{
					if(node!=null)
						head=node.next;
				}
				else
				{	
					node.prev.next=node.next;
				}
				size--;
				break;
			}
			node =  node.next;
		}
		if(animal!=null)
			System.out.println(animal.type()+" "+animal.name()+" Exited");
		else
			System.out.println("No Cats in Shelter");
		return animal;
	}
	public void iterate()
	{
		Node node = head;
		for(int i=0;i<size;i++)
		{
			System.out.print(node.value.name()+"-"+node.value.type()+"-"+node.value.getOrder()+" ");
			node =  node.next;
		}
	}
	public static void main(String args[]) {
		AnimalQueue animals = new AnimalQueue();
		animals.enqueue(new Cat("Kiki"));
		animals.enqueue(new Cat("Kari"));
		animals.enqueue(new Dog("Beji"));
		animals.enqueue(new Cat("Reki"));
		animals.enqueue(new Dog("Dexter"));
		System.out.print("Animal Queue...");
		animals.iterate();
		animals.dequeueAny();
		animals.dequeueDogs();
		animals.dequeueCats();
		animals.dequeueCats();
		animals.dequeueCats();
		animals.dequeueDogs();
		animals.dequeueDogs();
		System.out.print("Animal Queue...");
		animals.iterate();
	}
}
