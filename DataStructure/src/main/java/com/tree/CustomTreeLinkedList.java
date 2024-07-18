package com.tree;

import com.queue.QueueLinkedList;

public class CustomTreeLinkedList<T> {
    Node<T> rootNode;
    Node<T> currentNode;
    private static class Node<T> {
        public Node<T> parent;
        public Node<T> left;
        public T data;
        public Node<T> right;
        public Node<T> siblingLeft;
        public Node<T> siblingRight;
    }

    public void addByLevel(T data) {
        Node<T> newNode = new Node<T>();
        newNode.data = data;
        if(rootNode==null) {
            System.out.println("Added ["+data+"] in Root");
            currentNode = newNode;
            rootNode = newNode;
        }
        else {
            if(currentNode.left==null) {
                currentNode.left = newNode;
                newNode.parent = currentNode;
                if(newNode.parent.siblingLeft!=null) {
                    newNode.parent.siblingLeft.right.siblingRight = newNode;
                    newNode.siblingLeft = newNode.parent.siblingLeft.right;
                }
                System.out.println("Added ["+data+"] in Left");
            }
            else if(currentNode.right==null) {
                currentNode.right = newNode;
                newNode.parent = currentNode;
                newNode.parent.left.siblingRight = newNode;
                newNode.siblingLeft = newNode.parent.left;
                currentNode = getCurrentNode(newNode);
                System.out.println("Added ["+data+"] in Right and CurrentNode ["+currentNode.data+"] siblingLeft["+newNode.siblingLeft.data+"]");
            }
        }
    }
    private Node<T> getCurrentNode(Node<T> newNode) {
        if(newNode.siblingLeft==null) {
            return newNode;
        }
        if(newNode.parent.siblingRight!=null && newNode.parent.siblingRight.left==null && newNode.parent.siblingRight.right==null) {
            return newNode.parent.siblingRight;
        }
        return getCurrentNode(newNode.siblingLeft);
    }
    public void iterate(CustomTreeLinkedList<T> treeLinkedList) {
        iterate(treeLinkedList.rootNode,"");
    }

    // LEFT -> ROOT -> RIGHT
    // H D I B J E K A L F M C N G O
    public void inorderTraversal(Node<T> iterNode) {
        if (iterNode.left == null && iterNode.right == null) {
            System.out.print(iterNode.data+" ");
            return;
        }
        inorderTraversal(iterNode.left);
        System.out.print(iterNode.data+" ");
        inorderTraversal(iterNode.right);
    }

    // ROOT -> LEFT -> RIGHT
    // A -> B -> D -> H -> I -> E -> J -> K -> C -> F -> L -> M -> G -> N -> O
    public void preorderTraversal(Node<T> iterNode) {

        if (iterNode.left == null && iterNode.right == null) {
            System.out.print(iterNode.data+" ");
            return;
        }
        System.out.print(iterNode.data+" ");
        preorderTraversal(iterNode.left);
        preorderTraversal(iterNode.right);
    }
    public void levelOrderTraversal(Node<T> iterNode) {

        QueueLinkedList<Node<T>> queueLinkedList = new QueueLinkedList<>();
        queueLinkedList.push(iterNode);
        while(!queueLinkedList.isEmpty()) {
            Node<T> node = queueLinkedList.remove();
            if(node==null)
                return;
            String leftData = node.left!=null ? (String)node.left.data : "NULL";
            String rightData = node.right!=null ? (String)node.right.data : "NULL";
            System.out.println( leftData +"<-"+node.data+"->"+rightData );
            queueLinkedList.push(node.left);
            queueLinkedList.push(node.right);
        }

    }
    public void iterate(Node<T> iterNode,String space) {
        if (iterNode==null || (iterNode.left == null && iterNode.right == null)) {
            if(iterNode!=null)
                System.out.println(space + iterNode.data);
            return;
        }
        System.out.println(space+iterNode.data);
        space += " ";
        iterate(iterNode.left,space);
        iterate(iterNode.right,space);
    }
/*
                                                           101 | A | 102
                                                                100
                        103| B |104                                                                105| C |106
                            101                                                                        102

        107| D |108                          109| E |110                       111| F |112                        113| G |114
            103                                  104                               105                                106

0 | H | 0        0 | I | 0           0 | J | 0         0 | K | 0       0 | L | 0       0 | M | 0        0 | N | 0           0 | O | 0
   107              108                 109               110              111             112             113                 114
*/
    
    public static void main(String[] args) {
        CustomTreeLinkedList<String> treeList = new CustomTreeLinkedList<String>() ;
        treeList.addByLevel("A");
        treeList.addByLevel("B");
        treeList.addByLevel("C");
        treeList.addByLevel("D");
        treeList.addByLevel("E");
        treeList.addByLevel("F");
        treeList.addByLevel("G");
        treeList.addByLevel("H");
        treeList.addByLevel("I");
        treeList.addByLevel("J");
        treeList.addByLevel("K");
        treeList.addByLevel("L");
        treeList.addByLevel("M");
        treeList.addByLevel("N");
        treeList.addByLevel("O");
        //treeList.iterate(treeList);
        treeList.levelOrderTraversal(treeList.rootNode);

    }
}
