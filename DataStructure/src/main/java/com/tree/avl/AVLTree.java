package com.tree.avl;

public class AVLTree<T> {
    public Node<T> rootNode = null;

    public class Node<T> {
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
                currentNode.left = newNode;
                newNode.parent = currentNode;
            }
        } else {
            if (currentNode.right != null)
                insert(currentNode.right, data);
            else {
                currentNode.right = newNode;
                newNode.parent = currentNode;
            }
        }
        currentNode.height = 1 + Math.max(height(currentNode.left),height(currentNode.right)); // To set max height is node of each subtree.
        int heightDifference = getHeightDifferenceForRotation(currentNode);
        //System.out.println(heightDifference+"-"+currentNode.data);
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

    private void rotateLeft(Node<T> disbalanceNode) {
        System.out.println("Reached..."+disbalanceNode.data);
        Node<T> tempNode =  disbalanceNode.right;
        disbalanceNode.right=tempNode.left; // This line if for to rotate from root element
        tempNode.left = disbalanceNode;
        if(disbalanceNode==rootNode) {
            rootNode = tempNode;
        }
        else {
            disbalanceNode.parent.right=tempNode;
            tempNode.parent = disbalanceNode.parent;
        }
        disbalanceNode.parent=tempNode;
        disbalanceNode.height=1+Math.max(height(disbalanceNode.left),height(disbalanceNode.right));
        tempNode.height = 1+Math.max(height(tempNode.left),height(tempNode.right));

    }

    private void rotateRight(Node<T> currentNode ) {

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
