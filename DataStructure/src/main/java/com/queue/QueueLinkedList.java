package com.queue;

public class QueueLinkedList<T> {
    public Node<T> current;
    public Node<T> front;
    public Node<T> rear;
    public static class Node<T> {
        public Node<T> left;
        public T data;
        public Node<T> right;
    }
/*
0 | 1 | 101     101 | 1 | 103      102 | 1 | 104    103 | 1 | 105     104 | 1 | 0
   100               102                103              104               105
*/
    public void push(T data) {
        Node<T> newNode = new Node<T>();
        newNode.data=data;
        if(front==null) {
            front = newNode;
            rear = newNode;
            current = newNode;
        }
        else {
            newNode.left = current;
            current.right = newNode;
            current = newNode;
            rear = newNode;
        }
    }
    public void pop() {
        if(front==null || rear==null) {
            System.out.println("Queue Empty");
            return;
        }
        if(front!=rear) {
            front.right.left = null;
            front = front.right;
        }
        else {
            front=rear=null;
        }
    }

    public T remove() {
        T tempNode = null;
        if(front==null || rear==null) {
            System.out.println("Queue Empty");
            return tempNode;
        }
        tempNode = front.data;
        if(front!=rear) {
            front.right.left = null;
            front = front.right;
        }
        else {
            front=rear=null;
        }
        return tempNode;
    }
    public void iterate(Node<T> iterNode) {
        if(front==null || rear==null) {
            System.out.println("Queue Empty");
            return;
        }
        if(iterNode.right==null) {
            System.out.print(" -> "+iterNode.data);
            System.out.println();
            return;
        }
        System.out.print(" -> "+iterNode.data);
        iterate(iterNode.right);
    }
    public boolean isEmpty() {
        return front==null && rear==null;
    }
    public static void main(String[] args) {
        QueueLinkedList<Integer> queue = new QueueLinkedList<>();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);
        queue.iterate(queue.front);
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.isEmpty());
    }
}
