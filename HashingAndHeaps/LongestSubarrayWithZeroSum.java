// Given an array of integers, find the length of the longest subarray with sum 0.
//package HashingAndHeaps;
import java.util.*;

public class LongestSubarrayWithZeroSum {

    public static int maxLen(int[] arr) {

        // HashMap to store:
        // prefixSum → first index where this sum occurred
        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;      // Running prefix sum
        int maxLen = 0;   // Answer

        for (int i = 0; i < arr.length; i++) {

            // Step 1: Add current element to prefix sum
            sum += arr[i];

            //  Case 1:
            // If sum becomes 0 → subarray from 0 to i has sum 0
            if (sum == 0) {
                maxLen = i + 1;
            }

            //  Case 2:
            // If this sum was seen before
            // then subarray between previous index and current index = 0
            if (map.containsKey(sum)) {

                // Length of subarray with sum 0
                int len = i - map.get(sum);

                // Update max length
                maxLen = Math.max(maxLen, len);
            } 
            else {
                // Store ONLY first occurrence of this sum
                // because earlier index → longer subarray
                map.put(sum, i);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {

        int arr[] = {1, -1, 3, 2, -2, -3, 3};

        System.out.println(maxLen(arr)); // Output: 6
    }
}