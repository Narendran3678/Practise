package com.linkedlist.circularlinkedlist;

public class CircularLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;
    public CircularLinkedList() {
       head = new Node<>();
       tail = new Node<>();
    }
    public void add(T value) {
        Node<T> newNode = new Node<T>();
        newNode.value = value;
        if(size==0) {
            newNode.prev = newNode;
            newNode.next = newNode;
            head=tail=newNode;
        }
        else {
            newNode.prev = tail;
            tail.next=newNode;
            newNode.next = null;
            tail=newNode;
            head.prev=newNode;
            tail.next=head;
        }
        size++;
    }
    public void put(int position,T value) {
        if(position>size) {
            throw new ArrayIndexOutOfBoundsException("Given Position is greater than List Size");
        }
        if(size==position) {
            add(value);
            return;
        }
        Node<T> node = head;
        for(int i =1;i<=size;i++) {
            if(i==position) {
                Node<T> newNode = new Node<T>();
                newNode.value=value;
                newNode.next=node.next;
                newNode.prev=node;
                node.next.prev=newNode;
                node.next = newNode;
                newNode.prev=null;
                size++;
            }
            else {
                node = node.next;
            }
        }
    }
    public void iterate() {
        Node<T> itr = head;
        for(int i =1;i<=size;i++) {
            if(itr==null)
               break;
            System.out.print(itr.value);
            if(i<size) {
               System.out.print(" > ");
            }
            itr= itr.next;
        }
        System.out.println();
    }
    public void printHeadAndTail() {
        System.out.println("Head Value From Tail Node..."+tail.next.value);
        System.out.println("Tail Value From Head Node..."+head.prev.value);
    }
    public int size() {
        return size;
    }
    private static class Node<T> {
        public Node<T> prev;
        public T value;
        public Node<T> next;
    }
}
