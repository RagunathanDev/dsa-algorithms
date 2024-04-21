package com.dsa.trees;

import java.util.Scanner;

public class BinaryTree {
    public BinaryTree(){}

    private static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value){
            this.value= value;
        }
    }

    private Node root;

    //root node value
    public void populate(Scanner scanner){
        System.out.println("Please enter the root node value");
        int value = scanner.nextInt();
        root = new Node(value);
        populate(scanner,root);
    }

    //populate to left and right tree
    public void populate(Scanner scanner, Node node){
        System.out.println("do you want to enter left node of "+node.value);
        boolean left = scanner.nextBoolean();
        if(left){
            System.out.println("Enter the left node value of "+node.value);
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(scanner,node.left);
        }
        System.out.println("do you want to enter right node of "+node.value);
        boolean right = scanner.nextBoolean();
        if(right){
            System.out.println("Enter the right node value of "+node.value);
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(scanner,node.right);
        }
    }


    //to display the binary tree
    public void display(){
        display(root,"");
    }
    public void display(Node node,String intent){
        if(node == null){
            return;
        }
        System.out.println(intent+ node.value);
        display(node.left,intent+"\t");
        display(node.right,intent+"\t");
    }

    public void prettyDisplay(){
        prettyDisplay(root,0);
    }

    public void prettyDisplay(Node node, int level){
        if(node == null)
            return;

        prettyDisplay(node.right, level+1);

        if(level!=0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|-------->"+node.value);
        }else{
            System.out.println(node.value);
        }
        prettyDisplay(node.left,level+1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.populate(scanner);
        binaryTree.display();
        binaryTree.prettyDisplay();
    }
}
