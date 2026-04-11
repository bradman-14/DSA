// Given an integer stream, find the k-th largest element at any point in time. If there are fewer than k elements, return -1.

package HashingAndHeaps;

import java.util.*;

public class KthLargestStream {

    public static int[] kthLargest(int arr[], int k) {

        int n = arr.length;
        int result[] = new int[n];

        // Min heap to store k largest elements
        // WHY min heap? → smallest in heap = k-th largest overall
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {

            // Add current element to heap
            minHeap.add(arr[i]);

            // If heap size > k → remove smallest
            // WHY? → keep only k largest elements
            if (minHeap.size() > k) {
                minHeap.poll();
            }

            // If we don't have k elements yet → answer = -1
            if (minHeap.size() < k) {
                result[i] = -1;
            } else {
                // Heap top = k-th largest element
                result[i] = minHeap.peek();
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int arr[] = {4, 5, 8, 2};
        int k = 3;

        System.out.println(Arrays.toString(kthLargest(arr, k)));
    }
}