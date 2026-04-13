//Given an array arr[] of integers and an integer k, your task is to find the maximum value for each contiguous subarray of size k
//The output should be an array of maximum values corresponding to each contiguous subarray.

import java.util.*;

public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] arr, int k) {

        int n = arr.length;

        // 🔹 Number of windows = n - k + 1
        int[] result = new int[n - k + 1];

        // Max Heap:
        // Each element = {value, index}
        // We sort by value in descending order (max heap)
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> b[0] - a[0]
        );

        // 🔹 Pointer to fill result array
        int idx = 0;

        //  Traverse the array
        for (int i = 0; i < n; i++) {

            // STEP 1: Add current element to heap
            // Store both value and index
            // we r storing value awa index because we need to know if the element is outside the window or not which we r calling outdated element
            pq.add(new int[]{arr[i], i});

            // STEP 2: Remove elements that are OUTSIDE the window
            // Window range = [i-k+1, i]
            // So valid indices > i-k
            while (!pq.isEmpty() && pq.peek()[1] <= i - k) {
                pq.poll(); // remove outdated element
            }

            // STEP 3: Store answer when window is fully formed
            if (i >= k - 1) {

                // Top of heap = maximum element of current window
                result[idx++] = pq.peek()[0];
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int arr[] = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int[] res = maxSlidingWindow(arr, k);

        // 🔹 Print result
        System.out.println(Arrays.toString(res));
    }
}