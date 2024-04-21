package com.dsa.trees;

public class SegmentTree {

    private static class Node {
        int startInterval, endInterval;
        int value;
        Node left, right;

        public Node(int startInterval, int endInterval) {
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }

    private Node root;

    //construct segment trr
    private void construct(int[] arr) {
        root = construct(arr, 0, arr.length - 1);
    }

    private Node construct(int[] arr, int start, int end) {
        if (start == end) {
            Node leaf = new Node(start, end);
            leaf.value = arr[start];
            return leaf;
        }

        Node node = new Node(start, end);
        int mid = (start + end) / 2;

        node.left = construct(arr, start, mid);
        node.right = construct(arr, mid + 1, end);

        node.value = node.left.value + node.right.value;
        return node;
    }

    //Query the segment tree
    private int query(int queryStartIndex, int queryEndIndex) {
        return query(root, queryStartIndex, queryEndIndex);
    }

    private int query(Node node, int queryStartIndex, int queryEndIndex) {
        if (node.startInterval >= queryStartIndex && node.endInterval <= queryEndIndex) {
            //Node lying inside teh interval for query
            return node.value;
        } else if (node.startInterval > queryEndIndex || node.endInterval < queryStartIndex) {
            //means for this node there is no contribution to the query interval's
            return 0;
        } else {
            return query(node.left, queryStartIndex, queryEndIndex) + query(node.right, queryStartIndex, queryEndIndex);
        }
    }

    //update the particular index
    private void update(int index, int value) {
        root.value = update(root, index, value);
    }

    private int update(Node node, int index, int value) {
        if (index >= node.startInterval && index <= node.endInterval) {
            System.out.println("Index : " + index + "  :: " + "[ " + node.startInterval + " : " + node.endInterval + " ]");
            if (index == node.startInterval && index == node.endInterval) {
                node.value = value;
                return node.value;
            } else {
                node.value = update(node.left, index, value) + update(node.right, index, value);
                return node.value;
            }
        }
        return node.value;
    }


    private void display() {
        display(root);
    }

    private void display(Node node) {
        if (node == null)
            return;
        System.out.println("Node value of : " + node.value + "an interval of : [ " + node.startInterval + " : " + node.endInterval + " ]");
        display(node.left);
        display(node.right);
    }


    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        SegmentTree segmentTree = new SegmentTree();
        segmentTree.construct(arr);
        segmentTree.display();
        int queryResult = segmentTree.query(1, 2);
        System.out.println(queryResult);
        segmentTree.update(2,4);
        segmentTree.display();

    }

}