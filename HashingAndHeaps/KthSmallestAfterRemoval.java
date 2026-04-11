// Given an array of size n, find the k-th smallest number in the natural numbers after removing all elements of the array. The natural numbers are 1, 2, 3, and so on. The elements of the array are also natural numbers. For example, if the input array is [1, 3] and k = 4, then the remaining natural numbers after removing 1 and 3 are [2, 4, 5, 6, ...]. The 4th smallest number in this list is 6.

package HashingAndHeaps;

import java.util.*;

public class KthSmallestAfterRemoval {

    public static int findKth(int arr[], int k) {

        // Step 1: Store all elements of arr in a HashSet
        // This helps us quickly check if a number is removed or not (O(1) lookup)
        HashSet<Integer> set = new HashSet<>();
        for (int x : arr) {
            set.add(x);
        }

        int count = 0;   // Counts how many valid (non-removed) numbers we have seen
        int num = 1;     // Start checking from the first natural number

        // Step 2: Traverse natural numbers one by one
        while (true) {

            // If current number is NOT in the removed set
            if (!set.contains(num)) {

                // This number is part of remaining natural numbers
                count++;

                // If we have found the k-th valid number
                if (count == k) {
                    return num;  // Return it as answer
                }
            }

            // Move to next natural number
            num++;
        }
    }

    public static void main(String[] args) {

        // Example input
        int arr[] = {1, 3};  // Numbers to remove
        int k = 4;           // Find 4th smallest remaining number

        // Call function and print result
        System.out.println(findKth(arr, k)); // Output: 6
    }
}