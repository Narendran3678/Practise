package com.tree.avl;

public class AVLTest {

    public static void main(String[] args) {
        dataSet5();
        //30 , 25, 35, 20, 15, 5, 10, 50, 60, 70, 65
    }
/*
1.                       70                                 50
                  50           90(Remove)   ->         30       70
             30

2.                  70                              60
            50             90(Remove)    ->    50       70
                60
*/

    private static void dataSet6() {
        AVLTree<Integer> avlTree = new AVLTree<>();
        /*avlTree.insert(70);
        avlTree.insert(90);
        avlTree.insert(50);
        avlTree.insert(30);
        avlTree.delete(90);*/
        avlTree.insert(70);
        avlTree.insert(90);
        avlTree.insert(50);
        avlTree.insert(60);
        //avlTree.insert(30);
        avlTree.delete(90);
        avlTree.print();
        // System.out.println(avlTree.rootNode.data);
        // System.out.println(avlTree.rootNode.right.data);

    }
/*
                            70
                  50                  90
             30       60          80      100
         20      40       65                  110
    15
*/
    private static void dataSet5() {
        //Issue with this case
        AVLTree<Integer> avlTree = new AVLTree<>();
        avlTree.insert(70);
        avlTree.insert(90);
        avlTree.insert(50);
        avlTree.insert(30);
        avlTree.insert(60);
        avlTree.insert(80);
        avlTree.insert(100);
        avlTree.insert(110);
        avlTree.insert(65);
        avlTree.insert(20);
        avlTree.insert(40);
        //avlTree.print();

        avlTree.delete(70);
        System.out.println();
        avlTree.print();
        System.out.println(avlTree.rootNode.data);
        System.out.println(avlTree.rootNode.left.data);
        System.out.println(avlTree.rootNode.right.data);
        System.out.println(avlTree.rootNode.right.parent.data);
        System.out.println(avlTree.rootNode.right.parent.right.data);

    }

/*
                     30                                      30                                 20                                        20
             25              35         ->           20              35        ->       15               30           ->            15             30               Continued Down
        20                                      15        25                        5              25         35                10            25       35
    15*                                      5*                                         10*                                 5

                   20                                                       20                                                           20
           10              30                       ->              10               30                           ->          10                       50
       5        15     25       35                              5       15       25        50                           5           15          30              60
                                    50                                                 35       60                                          25       35              70
                                        60*                                                         70*

                        20                                                     20                                                                   20
            10                       50                             10                       50                     ->                  10                        50
        5       15          30              60           ->    5         15          30              60                            5         15           30                65
                        25      35              70                               25      35               65                                         25         35      50      70
                                            65*                                                                70
*/
    private static void dataSet4() {
        //Rotate Right Strategy
        AVLTree<Integer> avlTree = new AVLTree<>();
        avlTree.insert(30);
        avlTree.insert(25);
        avlTree.insert(35);
        avlTree.insert(20);
        avlTree.insert(15);
        avlTree.insert(5);
        avlTree.insert(10);
        avlTree.insert(50);
        avlTree.insert(60);
        avlTree.insert(70);
        avlTree.insert(65);
        avlTree.print();
        //avlTree.levelOrder();
    }
/*
                    15                              10
            10              20      ->         5            15
        5       12                          3           12      20
    3
*/
    private static void dataSet3() {
        //Rotate Right Strategy
        AVLTree<Integer> avlTree = new AVLTree<>();
        avlTree.insert(15);
        avlTree.insert(10);
        avlTree.insert(20);
        avlTree.insert(5);
        avlTree.insert(12);
        avlTree.insert(3);
        avlTree.print();
    }

/*
            50                                   65
        40         65                     50           70
                60    70       ->      40    60             75
                         75
*/
    private static void dataSet1() {
        //Rotate Left Strategy
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
