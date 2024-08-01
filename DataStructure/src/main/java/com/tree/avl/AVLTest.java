package com.tree.avl;

public class AVLTest {

    public static void main(String[] args) {
        dataSet1();
    }
    //30 , 25, 35, 20, 15, 5, 10, 50, 60, 70, 65
/*
            50                                   65
        40         65                     50           70
                60    70       ->      40    60             75
                         75
*/
    private static void dataSet1() {
        AVLTree<Integer> avlTree = new AVLTree<>();
        avlTree.insert(50);
        avlTree.insert(40);
        avlTree.insert(65);
        avlTree.insert(60);
        avlTree.insert(70);
        avlTree.insert(75);
        avlTree.print();
        System.out.println("After 80");
        avlTree.insert(80);
        avlTree.insert(90);
        avlTree.insert(95);
        avlTree.insert(100);

        avlTree.print();
    }
    /* Imbalance Tree
                             70
                 50				            90
            30		60		            80		100
                                     74
                                 73
                             72
    */
    private static void dataSet2() {
        AVLTree<Integer> avlTree = new AVLTree<>();
        avlTree.insert(70);
        avlTree.insert(50);
        avlTree.insert(90);
        avlTree.insert(30);
        avlTree.insert(60);
        avlTree.insert(80);
        avlTree.insert(100);
        avlTree.insert(74);
        avlTree.insert(73);
        avlTree.insert(72);
        avlTree.print();
    }
}
