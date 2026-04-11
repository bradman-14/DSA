//return exactly k elements from the array that are closest to x, excluding x itself if it is present in the array.

package HashingAndHeaps;

import java.util.*;

public class ClosestKElementsHeap {

    public static List<Integer> findClosest(int[] arr, int k, int x) {

        // Max Heap to store k closest elements
        // Each element = [distance from x, actual number]
        // WHY max heap? → so we can remove the "worst" (farthest) element easily
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> {
                // Compare by distance first
                // Larger distance = worse → should come first (so we can remove it)
                if (a[0] != b[0]) {
                    return b[0] - a[0];
                }

                // If same distance → smaller value is worse
                // (because question prefers larger value in tie)
                return a[1] - b[1];
            }
        );

        // Traverse all elements
        for (int num : arr) {

            // Skip x itself (problem condition)
            if (num == x) continue;

            // Calculate distance from x
            int dist = Math.abs(num - x);

            // Add current element to heap
            maxHeap.add(new int[]{dist, num});

            // If heap size exceeds k → remove worst element
            // WHY? → we only want k best elements
            if (maxHeap.size() > k) {
                maxHeap.poll(); // removes farthest (or worse tie case)
            }
        }

        // Extract results from heap
        List<Integer> result = new ArrayList<>();

        // Remove all elements from heap
        while (!maxHeap.isEmpty()) {

            // poll() returns [distance, number]
            // we only need the number → index 1
            result.add(maxHeap.poll()[1]);
        }

        // Return k closest elements
        return result;
    }

    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 4, 5};
        int k = 2;
        int x = 3;

        System.out.println(findClosest(arr, k, x)); // Output: [2, 4]
    }
}