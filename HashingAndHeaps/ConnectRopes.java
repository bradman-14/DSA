//Given an array arr[] of rope lengths, connect all ropes into a single rope with the minimum total cost.
// The cost to connect two ropes is equal to the sum of their lengths.
package HashingAndHeaps;
import java.util.*;

public class ConnectRopes {

    public static int minCost(int[] arr) {

        // Min heap to always get smallest ropes
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add all ropes into heap
        for (int x : arr) {
            pq.add(x);
        }

        int totalCost = 0;

        // Keep connecting until one rope remains
        while (pq.size() > 1) {

            // Take two smallest ropes
            int first = pq.poll();
            int second = pq.poll();

            // Cost to connect them
            int cost = first + second;

            // Add to total cost
            totalCost += cost;

            // Add new rope back to heap
            pq.add(cost);
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int arr[] = {4, 3, 2, 6};
        System.out.println(minCost(arr)); // Output: 29
    }
}