//Given an array of distinct integers arr[], find the length of the longest subarray which has contiguous elements. The elements can be in any order.

import java.util.*;

class LargestSubarrayWithContiguousElements {

    public static int longestSubarray(int[] arr) {

        int n = arr.length;
        int maxLen = 1;

        // Fix starting point
        for (int i = 0; i < n; i++) {

            int min = arr[i];
            int max = arr[i];

            // To check duplicates
            HashSet<Integer> set = new HashSet<>();

            // Expand subarray
            for (int j = i; j < n; j++) {

                // If duplicate found → break
                if (set.contains(arr[j])) {
                    break;
                }

                set.add(arr[j]);

                // Update min & max
                min = Math.min(min, arr[j]);
                max = Math.max(max, arr[j]);

                // Check contiguous condition
                if (max - min == j - i) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {

        int[] arr = {10, 12, 11};

        System.out.println(longestSubarray(arr)); 
    }
}