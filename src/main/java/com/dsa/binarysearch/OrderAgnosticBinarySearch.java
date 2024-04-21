package com.dsa.binarysearch;

public class OrderAgnosticBinarySearch {

    public static void main(String[] args) {

        // Binary search we used only for sorted array.

        int[] ascArr = { 2, 4, 6, 8, 9, 11, 15, 19, 25, 28, 37, 46, 56, 87, 54 };
        int[] decArr = {98,76,54,46,32,22,15,13,14,9,6,5,3,2,1,-5,-4,-87,-99};
        int target = 46;
        int element = binarySearch(ascArr, target);
        System.out.println(element);
    }

    private static int binarySearch(int[] arr, int target){
        int start =0 ,end = arr.length-1,mid;

        //find teh order agnostics

        boolean isAcending = arr[start] < arr[end];

        while(start <= end){

            mid = (start + (end - start)/2);

            if(arr[mid] == target) return mid;

            if(isAcending){
                if(arr[mid] < target)
                    start = mid+1;
                else end = mid -1;
            }else{
                if(arr[mid] < target)
                    end = mid -1;
                else start = mid+1;
            }
        }
        return -1;
    }
}
