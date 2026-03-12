//Given an integer array nums and an integer k, return the kth largest element in the array.

import java.util.Arrays;

public class KthLargestElementInAnArray {
     public static int findKthLargest(int[] nums, int k) {

        Arrays.sort(nums);

        int n = nums.length;

        return nums[n - k];
    }

    public static void main(String[] args) {

        int[] nums = {3,2,1,5,6,4};
        int k = 2;

        int result = findKthLargest(nums, k);

        System.out.println("Kth Largest Element: " + result);
    }
}
