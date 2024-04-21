package test;

public class BinarySearch{
    public static void main(String[] args) {
        int[] nums = {2,12,24,35,45,67,89,99,104};
        int target = 200;
        System.out.println(searchNumber(nums,target));
    }

    private static int searchNumber(int[] nums, int target){
        int left =0 , right = nums.length-1, mid;

        while(left <= right){
            mid = (left + ((right - left)/2));
            if(nums[mid] == target) return mid;

            if(nums[mid] < target){
                left = mid +1;
            }else{
                right = mid -1;
            }
        }
        return -1;
    }
}