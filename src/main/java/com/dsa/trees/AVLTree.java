package com.dsa.trees;


import java.util.stream.IntStream;

public class AVLTree {
    private class Node{
        int value,height;
        Node left,right;
        public Node(int value){
            this.value = value;
        }
    }

    private Node root;

    private int height(){
       return height(root);
    }

    //calculate height
    private int height(Node node){
        if(node == null)
            return 0;
        return node.height;
    }

    //insert node into the binary tree
    private void insert(int value){
        root = insert(root,value);
    }
    private Node insert(Node node,int value){
        if(node == null){
            node = new Node(value);
            return node;
        }

        if(value < node.value){
            node.left = insert(node.left,value);
        }
        if(value > node.value){
            node.right = insert(node.right,value);
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return rotate(node);
    }

    //Self-balancing node rotation of the tree
    private Node rotate(Node node){
        // check the node right heavy or left heavy
        if((height(node.left) - height(node.right)) > 1){
            //Left heavy
            if(height(node.left.left) - height(node.left.right) > 0){
                //Left-Left approach
                return rightRotate(node);
            }
            if(height(node.left.left) - height(node.left.right) < 0){
                //Left-Right approach
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        if(height(node.left) - height(node.right) <-1){
            //right heavy
            if(height(node.right.left) - height(node.right.right) <0){
                //Right-Right approach
                return leftRotate(node);
            }
            if(height(node.right.left) - height(node.right.right) > 0){
                //Right-Left Approach
                //rightRotate of (c)
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }

    private Node rightRotate(Node p){
        Node c = p.left;
        Node t = c.right;

        c.right = p;
        p.left = t;
        p.height = Math.max(height(p.left),height(p.right)) +1;
        c.height = Math.max(height(c.left), height(c.right)) +1;
        return c;
    }
    private Node leftRotate(Node c){
        Node p = c.right;
        Node t= p.left;

        p.left = c;
        c.right = t;
        c.height = Math.max(height(c.left),height(c.right)) +1;
        p.height =  Math.max(height(p.left),height(p.right)) + 1;

        return p;
    }



    //Inorder traversal
    private void inOrder(){
        inOrder(root , "Root Node value ");
    }
    private void inOrder(Node node,String intent){
        if(node == null)
            return;
        inOrder(node.left, "Left of "+node.value + " value is : ");
        System.out.println(intent + node.value);
        inOrder(node.right, "Right of "+node.value+" value is :");
    }


    private void populateValues(){
        IntStream.range(0,10).forEach(this :: insert);
    }

    private boolean balanced(){
        return balanced(root);
    }

    private boolean balanced(Node node){
        if(node == null)
            return true;
        return Math.abs(height(node.left)-height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }

    private void printAncestor(int target){
        System.out.println();
        printAncestor(root,target);
    }
    private boolean printAncestor(Node node, int target){
        if(node == null)
            return false;

        if(node.value == target)
            return true;

        if(printAncestor(node.left,target) || printAncestor(node.right,target)){
            System.out.print(node.value + " ");
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        avlTree.populateValues();
        avlTree.inOrder();
        System.out.println(avlTree.height());
        System.out.println(avlTree.balanced());
        avlTree.printAncestor(6);
    }

}
