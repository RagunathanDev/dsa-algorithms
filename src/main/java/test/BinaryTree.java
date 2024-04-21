package test;

import java.util.Scanner;

public class BinaryTree {

    private class Node{
        int value;
        Node left,right;
        public Node(int value){
            this.value = value;
        }
    }

    private Node root;

    //populate insert into node
    private void populate(Scanner scanner){
        System.out.println("Please enter the root node value : ");
        int value = scanner.nextInt();
        root = new Node(value);
        populate(root, scanner);
    }

    private void populate(Node node,Scanner scanner){
        System.out.println("Do you want to insert left node of "+node.value);
        boolean left = scanner.nextBoolean();
        if(left){
            System.out.println("Enter value for left node of "+node.value);
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(node.left,scanner);
        }
        System.out.println("Do you want to create right node of "+node.value);
        boolean right = scanner.nextBoolean();
        if(right){
            System.out.println("Enter the value of right node of"+node.value);
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(node.right,scanner);
        }
    }


    //display the binary tree
    private void display(){
        display(root,"Root node value is");
    }

    private void display(Node node, String intent){
        if(node == null)
            return;
        System.out.println(intent + " : "+node.value);
        display(node.left,"left node of "+node.value+" is");
        display(node.right,"right node of "+node.value+" is");
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.populate(scanner);
        binaryTree.display();
    }
}
