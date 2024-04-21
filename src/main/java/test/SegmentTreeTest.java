package test;

public class SegmentTreeTest {
    private static class Node{
        int startInterval,endInterval;
        int value;
        Node left,right;

        public Node(int startInterval,int endInterval){
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }

    private Node root;

    //construct the segment tree
    private void construct(int[] arr){
        root = construct(arr,0,arr.length -1);
    }

    private Node construct(int[] arr,int start,int end){

        if(start == end){
            //craete the leaf node first
            Node leaf = new Node(start,end);
            leaf.value = arr[start];
            return leaf;
        }

        //before find the leaf node meanwhile construct the segment tree
        Node node = new Node(start,end);
        int mid = (start+ end) /2;
        //create left part of segment tree
        node.left = construct(arr,start,mid);
        //craete right part of segment tree
        node.right = construct(arr,mid +1,end);

        //add the left and right child value
        node.value = node.left.value + node.right.value;
        return  node;
    }

    //Query the interval of sum
    private int query(int startQueryIndex,int endQueryIndex){
        return query(root,startQueryIndex,endQueryIndex);
    }

    private int query(Node node, int startQueryIndex,int endQueryIndex){
        if(node.startInterval >= startQueryIndex && node.endInterval <= endQueryIndex) {
            return node.value;
        }else if(node.startInterval > endQueryIndex || node.endInterval < startQueryIndex){
            return 0;
        }else{
            return query(node.left,startQueryIndex,endQueryIndex) + query(node.right,startQueryIndex,endQueryIndex);
        }
    }


    //update the particular node with an index
    private void update (int index,int newValue){
        root.value = update(root,index,newValue);
    }

    private int update(Node node, int index,int newValue){
        if(index >= node.startInterval && index <= node.endInterval){
            if(index == node.startInterval && index == node.endInterval){
                node.value = newValue;
                return node.value;
            }else{
                node.value = update(node.left,index,newValue) + update(node.right,index,newValue);
                return node.value;
            }
        }
        return node.value;
    }

    //display (preOrder traversal)
    private void display(){
        display(root);
    }
    private void display(Node node){
        if(node == null)
            return;

        System.out.println("Interval : [ "+node.startInterval+ " : "+node.endInterval+" ]  ==> node value : "+node.value);
        display(node.left);
        display(node.right);
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,7,9,11};
        SegmentTreeTest segmentTreeTest = new SegmentTreeTest();
        segmentTreeTest.construct(arr);
        segmentTreeTest.display();
    }

}
