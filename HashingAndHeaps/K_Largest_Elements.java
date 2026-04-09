//Given an integer array arr and an integer k, return the k largest elements in the array in any order. 
package HashingAndHeaps;
import java.util.*;

public class K_Largest_Elements {

    public static int[] findKLargest(int[] arr, int k) {
        // STEP 1: Create Min Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // STEP 2: Process array
        for (int num : arr) {

            pq.add(num); // add element

            // If size exceeds k → remove smallest
            if (pq.size() > k) {
                pq.poll();
            }
        }
        // STEP 3: Extract result
        int[] result = new int[k];

        for (int i = k - 1; i >= 0; i--) {
            result[i] = pq.poll(); // fill in reverse for descending order
        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr = {3, 2, 1, 5, 6, 4};
        int k = 2;

        int[] result = findKLargest(arr, k);

        System.out.println(Arrays.toString(result));
    }
}