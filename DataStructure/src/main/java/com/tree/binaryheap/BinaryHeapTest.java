package com.tree.binaryheap;

public class BinaryHeapTest {
    public static final String MIN_HEAP ="MIN-HEAP";
    public static final String MAX_HEAP ="MAX-HEAP";
    public static void main(String[] args) {
        minHeapTest();
    }
/*
                             1*(Remove Head)                            5
                    5                  20           ->          10              20
             10         40       50       60                30      40      50        60
      30
*/
    public static void minHeapTest() {
        BinaryHeapArray<Integer> heapArray = new BinaryHeapArray<>(8, MIN_HEAP);
        heapArray.insert(5);
        heapArray.insert(10);
        heapArray.insert(20);
        heapArray.insert(30);
        heapArray.insert(40);
        heapArray.insert(50);
        heapArray.insert(60);
        heapArray.insert(1);
        System.out.println("Size of Array...." + heapArray.size());
        heapArray.levelOrder();
        heapArray.removeHead();
        heapArray.levelOrder();
        heapArray.removeHead();
        heapArray.levelOrder();
        System.out.println("Size of Array...." + heapArray.size());
    }
    /*
                          80                                                       5
                 70                 60             =>                     10                30
           50          40      30         20                       20         60      70          40
       5        10                                             80      50
    */
    public static void minHeapTest1() {
        BinaryHeapArray<Integer> heapArray = new BinaryHeapArray<>(9, MIN_HEAP);
        heapArray.insert(80);
        heapArray.insert(70);
        heapArray.insert(60);
        heapArray.insert(50);
        heapArray.insert(40);
        heapArray.insert(30);
        heapArray.insert(20);
        heapArray.insert(5);
        heapArray.insert(10);
        System.out.println("Size of Array...." + heapArray.size());
        heapArray.levelOrder();
    }
    /*
                          80                                                       5
                 70                 60             =>                     10                30
           50          40      30         20                       20         60      70          40
       5        10                                             80      50
    */
    public static void maxHeapTest() {
        BinaryHeapArray<Integer> heapArray = new BinaryHeapArray<>(10, MAX_HEAP);
        heapArray.insert(80);
        heapArray.insert(70);
        heapArray.insert(60);
        heapArray.insert(50);
        heapArray.insert(40);
        heapArray.insert(30);
        heapArray.insert(20);
        heapArray.insert(5);
        heapArray.insert(10);
        heapArray.insert(90);
        System.out.println("Size of Array...." + heapArray.size());
        heapArray.levelOrder();
    }
}
