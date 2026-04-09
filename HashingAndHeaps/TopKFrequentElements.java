//Given an integer array nums and an integer k, return the k most frequent elements.
package HashingAndHeaps;
import java.util.*;

public class TopKFrequentElements {

    public static int[] topKFrequent(int[] nums, int k) {
        // STEP 1: Create HashMap to store frequency
        HashMap<Integer, Integer> map = new HashMap<>();
        // Traverse the array
        for (int num : nums) {

            // If key already exists → increase frequency
            if (map.containsKey(num)) {
                int current = map.get(num);   // get current frequency
                map.put(num, current + 1);   // update frequency
            } 
            else {
                // If key does NOT exist → add with frequency 1
                map.put(num, 1);
            }
        }
        // STEP 2: Create Min Heap based on frequency
        // Heap will store numbers, but compare using their frequency
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> map.get(a) - map.get(b)   // smaller frequency first
        );
        //(a, b) -> map.get(a) - map.get(b) is a lambda function that defines the ordering of elements in the priority queue (min heap) based on their frequency.
        //It means If freq(a) < freq(b) → a comes first
        //So, SMALLEST frequency stays at top of the heap
        //Thats why, this is the Min Heap based on frequency

        // STEP 3: Add elements to heap
        for (int key : map.keySet()) {

            pq.add(key);  // add element to heap

            // If heap size becomes greater than k → remove smallest frequency
            if (pq.size() > k) {
                pq.poll(); // remove least frequent element
                //pq.poll() removes and returns the head of the queue, which is the least frequent element in this case, ensuring that only the top k frequent elements remain in the heap.
            }
        }

        // -------------------------------
        // STEP 4: Extract result from heap
        // -------------------------------
        int[] result = new int[k];
        int i = 0;

        // Remove elements from heap and store in result
        while (!pq.isEmpty()) {
            result[i] = pq.poll();
            i++;
        }

        return result;
    }

    // -------------------------------
    // MAIN FUNCTION
    // -------------------------------
    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        int[] result = topKFrequent(nums, k);

        System.out.println(Arrays.toString(result));
    }
}