package com.tree.binaryheap;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryHeapArray<T> {
    public static final String MIN_HEAP ="MIN-HEAP";
    public static final String MAX_HEAP ="MAX-HEAP";
    private int size ;
    private String type ;
    private T arr[] ;
    public BinaryHeapArray(int size,String type) {
        this.size=0;
        this.type=type;
        arr = (T[]) new Object[size+1];
    }
    public int size() {
        return size;
    }
    public T peek() {
        return arr[1];
    }

    public void levelOrder() {
        Queue<Integer> printer = new LinkedList<>();
        printer.add(1);
        levelOrder(printer);
    }

    public void levelOrder(Queue<Integer> printer) {
        Integer position = printer.remove();
        if(position>size)
            return;
        System.out.print(arr[position] +" -> ");
        if(position*2<=size)
            System.out.print(arr[position*2]+",");
        else
            System.out.print("null,");

        if((position*2)+1<=size)
            System.out.print(arr[(position*2)+1] );
        else
            System.out.print("null");

        System.out.println();
        printer.add(position*2);
        printer.add((position*2)+1);
        levelOrder(printer);
    }

    //5  10  20  30  40  50  60   1
    //1  2   3   4   5   6   7    8
/*
                    5                                               1
           10               20        ->                  5                  20
       30       40     50       60                  10         40       50       60
   1                                          30
*/
    public void insert(T data) {
        if(arr.length-1 == size ) {
            System.out.println("Array Filled");
            return ;
        }
        arr[++size] = (T)data;
        heapifyBottomToTop(size);
    }
    private void heapifyBottomToTop(int position) {
        if(position==1)
            return ;
        int parentPosition= position/2;
        if(type.equals(MIN_HEAP)) {
            if(Integer.parseInt(arr[parentPosition].toString()) > Integer.parseInt(arr[position].toString())) {
                T temp = arr[parentPosition] ;
                arr[parentPosition]=arr[position];
                arr[position]=temp;
                heapifyBottomToTop(parentPosition);
            }
        } else if(type.equals(MAX_HEAP)) {
            if(Integer.parseInt(arr[parentPosition].toString()) < Integer.parseInt(arr[position].toString())) {
                T temp = arr[parentPosition] ;
                arr[parentPosition]=arr[position];
                arr[position]=temp;
                heapifyBottomToTop(parentPosition);
            }
        }
    }
    public void removeHead() {
        arr[1] = arr[size];
        arr[size] = null;
        size--;
        heapifyTopToBottom(1,type);
    }

/*
                             1*(Remove Head)
                    5                  20
             10         40        50       60
      30
*/

    private void heapifyTopToBottom(int position,String type) {
        if(position>size)
            return;
        int left = position*2;
        int right = (position*2)+1;

        if(MIN_HEAP.equals(type)) {
            System.out.println(left+"="+position+"="+right+"="+size);

            if(arr[left]!=null && (Integer.parseInt(arr[left].toString()) < Integer.parseInt(arr[position].toString()))) {
                T temp = arr[left] ;
                arr[left]=arr[position];
                arr[position]=temp;
                heapifyTopToBottom(left,MIN_HEAP);
            }
            else if(right< arr.length && arr[right]!=null && (Integer.parseInt(arr[right].toString()) < Integer.parseInt(arr[position].toString()))) {
                T temp = arr[right] ;
                arr[right]=arr[position];
                arr[position]=temp;
                heapifyTopToBottom(right,MIN_HEAP);
            }

        } else if(MAX_HEAP.equals(type)) {
            if(arr[left]!=null && (Integer.parseInt(arr[left].toString()) > Integer.parseInt(arr[position].toString()))) {
                T temp = arr[left] ;
                arr[left]=arr[position];
                arr[position]=temp;
                heapifyTopToBottom(left,MIN_HEAP);
            }
            else if(right< arr.length && arr[right]!=null  && (Integer.parseInt(arr[right].toString()) > Integer.parseInt(arr[position].toString()))) {
                T temp = arr[right] ;
                arr[right]=arr[position];
                arr[position]=temp;
                heapifyTopToBottom(right,MIN_HEAP);
            }
        }
    }
}
