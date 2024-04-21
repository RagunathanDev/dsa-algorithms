package test;

import java.util.Arrays;

public class BinarySearchTree {
    private class Node{
        int value,height;
        Node left,right;
        public Node(int value){
            this.value=value;
            this.left = this.right = null;
        }
    }

    private Node root;

    //Height of a tree
    private static int height(Node node){
        if(node == null)
            return -1;
        return node.height;
    }

    //Insert into binarySearchTree
    private void insert(int value){
        root = insert(root,value);
    }

    private Node insert(Node node,int value){
        if(node == null)
            node = new Node(value);

        if(value < node.value){
            node.left = insert(node.left,value);
        }
        if(value > node.value){
            node.right = insert(node.right,value);
        }
        node.height = Math.max(height(node.left) , height(node.right))+1;
        return node;
    }

    //InOrder traversal
    private void inOrderTraversal(){
        inOrderTraversal(root);
    }
    private void inOrderTraversal(Node node){
        if(node == null)
            return;
        inOrderTraversal(node.left);
        System.out.print(node.value+" ");
        inOrderTraversal(node.right);
    }

    //preOrder traversal
    private void preOrderTraversal(){
        preOrderTraversal(root);
    }
    private void preOrderTraversal(Node node){
        if(node == null)
            return;
        System.out.print(node.value+ " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    //PostOrder Traversal
    private void postOrderTraversal(){
        postOrderTraversal(root);
    }
    private void postOrderTraversal(Node node){
        if(node == null)
            return;

        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.value + " ");
    }


    //print anchestor of the node - ( anchestor mean munnorgal)
    private void printAnchestor(int target){
        System.out.println("Ancestor of "+target + " : ");
        printAncestor(root,target);
    }

    private boolean printAncestor(Node node, int target){
        if(node == null){
            return false;
        }

        if(node.value == target){
            return true;
        }

        if(printAncestor(node.left,target) || printAncestor(node.right,target)){
            System.out.print(node.value + " ");
            return true;
        }
        return false;
    }

    private void populateArray(int[] nums){
        Arrays.stream(nums).forEach(this :: insert);
    }

    public static void main(String[] args) {
       //int[] nums = {5,7,8,2,4,65,3,21,22};
        int[] nums = {100,20,200,10,30,150,300};
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.populateArray(nums);
        binarySearchTree.inOrderTraversal();
        System.out.println();
        binarySearchTree.preOrderTraversal();
        System.out.println();
        binarySearchTree.postOrderTraversal();
        binarySearchTree.printAnchestor(300);
    }

}
