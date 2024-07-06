package com.linkedlist.circularlinkedlist;

public class CircularLinkedListTest {
    public static void main(String args[]) {
        CircularLinkedList<Integer> cirLinkedList =  new CircularLinkedList<>();
        cirLinkedList.add(1);
        cirLinkedList.add(2);
        cirLinkedList.add(4);
        cirLinkedList.add(5);
        cirLinkedList.add(6);
        cirLinkedList.iterate();
        cirLinkedList.put(1,3);
        cirLinkedList.iterate();
        cirLinkedList.printHeadAndTail();
    }
}
