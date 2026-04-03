// Given an array of integers, find the next permutation of the array in place.
//implement the next permutation that rearranges the numbers into the lexicographically next greater permutation.

import java.util.Arrays;

public class NextPermutation {

    public static void nextPermutation(int[] nums) {

        int n = nums.length;

        // -------------------------------
        // STEP 1: Find the PIVOT
        // -------------------------------
        // Pivot = first index from right where nums[i] < nums[i+1]
        // This is the point where we can increase the number slightly
        //This is the posisiton where we have to start to increase the number

        int i = n - 2;  // start from second last index

        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--; // move left while sequence is decreasing
        }

        // After this loop:
        // If i >= 0 → pivot found
        // If i < 0 → entire array is decreasing (last permutation)

        // -------------------------------
        // STEP 2: Find JUST GREATER element
        // -------------------------------
        if (i >= 0) {

            int j = n - 1; // start from last index

            // Find the smallest element greater than nums[i]
            while (nums[j] <= nums[i]) {
                j--;
            }

            // -------------------------------
            // STEP 3: Swap pivot and this element
            // -------------------------------
            swap(nums, i, j);
        }

        // -------------------------------
        // STEP 4: Reverse the right part
        // -------------------------------
        // Why? Because right part is in descending order
        // Reversing makes it smallest (ascending)

        reverse(nums, i + 1, n - 1);
    }

    // Function to swap two elements
    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    // Function to reverse part of array
    public static void reverse(int[] nums, int start, int end) {

        while (start < end) {

            swap(nums, start, end);

            start++;
            end--;
        }
    }

    // -------------------------------
    // MAIN FUNCTION
    // -------------------------------
    public static void main(String[] args) {

        int[] arr = {2, 4, 1, 7, 5, 0};

        System.out.println("Original Array:");
        System.out.println(Arrays.toString(arr));

        nextPermutation(arr);

        System.out.println("Next Permutation:");
        System.out.println(Arrays.toString(arr));
    }
}