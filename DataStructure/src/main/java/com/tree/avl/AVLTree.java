package com.tree.avl;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree<T> {
    public Node<T> rootNode = null;

    public static class Node<T> {
        public Integer height = 1;
        public T data;
        public Node<T> parent;
        public Node<T> left;
        public Node<T> right;

        public Node(T data) {
            this.data = data;
        }
    }

    public int maxDepth(Node<T> node) {
        int lDepth = 0;
        int rDepth = 0;
        if (node == null)
            return 0;
        else {
            lDepth = maxDepth(node.left);
            rDepth = maxDepth(node.right);
            /* use the larger one */
            if (lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
        }
    }

    public boolean compare(T data1, T data2) {
        try {
            double value1 = Double.parseDouble(String.valueOf(data1));
            double value2 = Double.parseDouble(String.valueOf(data2));
            return value1 <= value2;
        } catch (Exception e) {
            System.out.println("Error Converting to Double..." + e);
        }
        try {
            String value1 = String.valueOf(data1);
            String value2 = String.valueOf(data2);
            return value1.compareTo(value2) <= 0;
        } catch (Exception e) {
            System.out.println("Error Converting to String");
        }
        return false;
    }

    /*
                    70
            50				90
        30		60		80		100
    */
    public void insert(T data) {
        insert(this.rootNode, data);
    }

    /*
                         30
                  25		    35
            20
        15
    */
    private int height(Node<T> node) {
        if(node==null) {
            return 0;
        }
        return node.height;
    }

    private void insert(Node<T> currentNode, T data) {
        Node<T> newNode = new Node<>(data);
        if (rootNode == null) {
            newNode.height = 1;
            rootNode = newNode;
            return;
        }
        if (compare(data, currentNode.data)) {
            if (currentNode.left != null)
                insert(currentNode.left, data);
            else {
                System.out.println("Adding..."+data);
                currentNode.left = newNode;
                newNode.parent = currentNode;
            }
        } else {
            if (currentNode.right != null)
                insert(currentNode.right, data);
            else {
                System.out.println("Adding..."+data);
                currentNode.right = newNode;
                newNode.parent = currentNode;
            }
        }
        currentNode.height = 1 + Math.max(height(currentNode.left),height(currentNode.right)); // To set max height is node of each subtree.
        int heightDifference = getHeightDifferenceForRotation(currentNode);
        System.out.println(heightDifference+"-"+currentNode.data);
        if(heightDifference< -1 && !compare(data, currentNode.right.data)) { //>= Right Right Condition
/*
        5                            10
            10          ->       5      15
                15
*/
            rotateLeft(currentNode);
        }
        else if(heightDifference< -1 && compare(data, currentNode.right.data)) { //<= Right Left Condition
/*
        5                   5                           7
                10    ->        7            ->    5        10
            7                       10
*/          rotateRight(currentNode.right);
            //print();
            rotateLeft(currentNode);
        }
        else  if(heightDifference>1 && compare(data, currentNode.left.data)) { // <=Left Left Condition
/*
            10                  5
        5             ->   3        10
    3
*/          rotateRight(currentNode);
        }
        else if(heightDifference>1 && !compare(data, currentNode.left.data)) { //>= Left Left Condition
/*
                10                  10                       7
        5               ->      7              ->       5        10
            7               5
*/          rotateLeft(currentNode.left);
            rotateRight(currentNode);
        }
    }
/*
    1.        5                            10
                  10          ->       5      15
                     15

    2.
                 50                                 65
            40         65                     50           70
                    60    70       ->      40    60             75
                             75
 */
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
    private void rotateLeft(Node<T> disbalanceNode) {
        System.out.println("Rotate Left For Root Node ["+disbalanceNode.data+"]");
        Node<T> tempNode =  disbalanceNode.right;
        disbalanceNode.right=tempNode.left; // This line if for to rotate from root element
        tempNode.left = disbalanceNode;
        if(disbalanceNode==rootNode) {
            rootNode = tempNode;
        }
        else {
            if(compare(disbalanceNode.data,this.rootNode.data)) {
                disbalanceNode.parent.left = tempNode;
            } else {
                if(disbalanceNode.parent!=null)
                    disbalanceNode.parent.right = tempNode;
            }
            tempNode.parent = disbalanceNode.parent;
        }
        disbalanceNode.parent=tempNode;
        disbalanceNode.height=1+Math.max(height(disbalanceNode.left),height(disbalanceNode.right));
        tempNode.height = 1+Math.max(height(tempNode.left),height(tempNode.right));
        disbalanceNode=tempNode;
    }
/*
                           15                               10
                   10              20      ->         5            15
               5       12                         3            12      20
           3

                            30                                    30
                    25              35     ->           20                   35
               20                                  15         25
           15
       */

    private void rotateRight(Node<T> disbalanceNode ) {
        System.out.println("Rotate Right For Root Node ["+disbalanceNode.data+"]");
        Node<T> tempNode =  disbalanceNode.left;
        if(disbalanceNode==rootNode) {
            rootNode=tempNode;
        }
        else {
            if(compare(disbalanceNode.data,this.rootNode.data)) {
                disbalanceNode.parent.left = tempNode;
            } else {
                if(disbalanceNode.parent!=null)
                    disbalanceNode.parent.right = tempNode;
            }
            tempNode.parent = disbalanceNode.parent;
        }
        disbalanceNode.parent = tempNode;
        disbalanceNode.left = tempNode.right;
        tempNode.right=disbalanceNode;
        disbalanceNode.height=1+Math.max(height(disbalanceNode.left),height(disbalanceNode.right));
        tempNode.height = 1+Math.max(height(tempNode.left),height(tempNode.right));
        disbalanceNode=tempNode;
    }
    private int getHeightDifferenceForRotation(Node<T> node) {
        if(node==null)
            return 0;
        return height(node.left) - height(node.right);
    }
    public void print() {
        print(this.rootNode, "");
    }

    private void print(Node<T> node, String space) {
        Node<T> currNode = node;
        if (currNode != null && currNode.data != null) {
            System.out.println(space + currNode.data+"/"+currNode.height);
            if (currNode.right == null && currNode.left == null)
                return;
            print(currNode.left, space += " ");
            print(currNode.right, space);
        }
    }
    void levelOrder() {
        Queue<Node<T>> queue = new LinkedList<Node<T>>();
        queue.add(this.rootNode);
        while (!queue.isEmpty()) {
            Node<T> presentNode = queue.remove();
            System.out.print(presentNode.data + " ");
            if (presentNode.left != null) {
                queue.add(presentNode.left);
            }
            if (presentNode.right != null) {
                queue.add(presentNode.right);
            }
        }
    }
    public boolean search(T data) {
        return search(this.rootNode, data);
    }

    public boolean search(Node<T> avlTreeNode, T data) {
        if (avlTreeNode == null)
            return false;
        if (avlTreeNode.data == data)
            return true;

        if (compare(avlTreeNode.data, data)) {
            return search(avlTreeNode.left, data);
        } else {
            return search(avlTreeNode.right, data);
        }
    }
}
