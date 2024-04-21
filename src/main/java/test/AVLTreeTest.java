package test;

import java.util.stream.IntStream;

public class AVLTreeTest {

    private class Node{
        int value,height;
        Node left,right;

        public Node(int value){
            this.value = value;
        }
    }

    private Node root;

    //height calculation
    private int height(){
        return height(root);
    }

    //height of the node
    private int height(Node node){
        if(node == null){
            return -1;
        }
        return node.height;
    }

    //Insert value into the root element
    private void insert(int value){
        root = insert(root,value);
    }

    private Node insert(Node node, int value){
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

        node.height = Math.max(height(node.left) ,height(node.right)) + 1;
        return rotate(node);
    }

    private Node rotate(Node node){

        if((height(node.left) - height(node.right)) > 1){
            //Left heavy
            if(height(node.left.left) - height(node.left.right) >0){
                //Left-Left approach
                return rightRotate(node);
            }
            if(height(node.left.left) - height(node.left.right) < 0){
                //Left-Right Approach
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        if(height(node.left) - height(node.right) < -1){
            //right heavy
            if(height(node.right.left) - height(node.right.right) < 0 ){
                //Right - Right approach
                return leftRotate(node);
            }
            if(height(node.right.left) - height(node.right.right) > 0){
                //Right - left Approach
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        return node;
    }

    // Right rotate
    private Node rightRotate(Node p){
        Node c = p.left;
        Node t= p.left.right; //c.right

        c.right = p;
        p.left = t;

        p.height = Math.max(height(p.left),height(p.right)) + 1;
        c.height = Math.max(height(c.left),height(c.right)) +1;
        return c;
    }

    // Left rotate
    private Node leftRotate(Node c){
        Node p = c.right;
        Node t = p.left; // c.right.left

        p.left = c;
        c.right = t;

        c.height = Math.max(height(c.left), height(c.right)) + 1;
        p.height = Math.max(height(p.left), height(p.right)) + 1;
        return p;
    }

    private boolean balanced(){
        return balanced(root);
    }

    private boolean balanced(Node node){
        if(node == null)
            return true;
        return Math.abs(height(node.left) - height(node.right)) <=1 && balanced(node.left)  && balanced(node.right);
    }



    //display
    private void display(){
        inOrderDisplay(root);
        System.out.println();
        preOrderDisplay(root);
        System.out.println();
        postorderDisplay(root);
        System.out.println();
    }
    private void inOrderDisplay(Node node){
        if(node == null)
            return;

        inOrderDisplay(node.left);
        System.out.print(node.value + ": height : ("+ node.height +") |");
        inOrderDisplay(node.right);
    }

    //preorder traversal
    private void preOrderDisplay(Node node){
        if(node == null)
            return;
        System.out.print(node.value + " | ");
        preOrderDisplay(node.left);
        preOrderDisplay(node.right);
    }

    //postOrder traversal
    private void postorderDisplay(Node node){
        if(node == null)
            return;
        postorderDisplay(node.left);
        postorderDisplay(node.right);
        System.out.print(node.value + " | ");
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

    private void populateValue(){
        IntStream.range(0,10).forEach(this::insert);
    }
    public static void main(String[] args) {
        AVLTreeTest avlTreeTest = new AVLTreeTest();
        avlTreeTest.populateValue();
        avlTreeTest.display();
        System.out.println(avlTreeTest.height());
        System.out.print(avlTreeTest.balanced());
        avlTreeTest.printAncestor(9);
    }



}
