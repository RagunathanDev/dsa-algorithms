package com.dsa.trees;

public class BinarySearchTree {
    public BinarySearchTree(){}

    private static class Node{
        private int value,height;
        private Node left,right;

        public Node(int value){
            this.value = value;
        }
    }
    private Node root;

    public int height(Node node){
        if(node==null)
            return -1;
        return node.height;
    }

    public boolean isEmpty(){
        return root==null;
    }

    //Insert an element into BST
    public void insert(int value){
        root = insert(root,value);
    }

    private Node insert(Node node, int value) {

        //if reached the leaf node then create the node
        if (node == null) {
            node = new Node(value);
            return node;
        }

        //first check the left node
        if (value < node.value) {
            node.left = insert(node.left, value);
        }

        //then check the right side nodes
        if (value > node.value) {
            node.right = insert(node.right, value);
        }

        node.height = Math.max(height(node.left) , height(node.right)) + 1;
        return node;
    }

    public void display(){
        display(root,"Root Node : ");
    }
    public void display(Node node, String details){
        if(node == null)
            return;
        System.out.println(details + node.value);
        display(node.left,"Left child of "+node.value+":");
        display(node.right,"Right child of "+node.value+":");
    }

    public void populate(int[] nums){
        if(nums  == null || nums.length <=0)
            return;
        for(int i=0;i<nums.length;i++){
            insert(nums[i]);
        }
    }

    /** NOTE : Sorted array insert into BSt tree**/

    public void populateSortedArray(int[] nums){
        populateSortedArray(nums, 0, nums.length);
    }
    public void populateSortedArray(int[] nums, int start, int end){
        if(start >= end){
            return;
        }

        //find the middle element formula
        int mid = (start+end)/2;
        //find a middle element and insert the value
        insert(nums[mid]);

        //for left insert
        populateSortedArray(nums,start,mid);
        //for right insert
        populateSortedArray(nums,mid+1,end);

    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        int[] nums = {5,7,8,2,4,65,3,21,22};
        binarySearchTree.populate(nums);
        binarySearchTree.display();

//        BinarySearchTree binarySearchTreeSorted = new BinarySearchTree();
//        int[] sortedNums = {1,2,3,4,5,6,7,8,9,10};
//        binarySearchTreeSorted.populateSortedArray(sortedNums);
//        binarySearchTreeSorted.display();
    }
}
