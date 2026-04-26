import java.util.*;

public class ReverseFirstKQueue {

    public static void reverseFirstK(Queue<Integer> q, int k) {

        // Edge case
        if (q.size() < k || k <= 0) {
            System.out.println("Invalid K, returning original queue");
            return;
        }

        Stack<Integer> stack = new Stack<>();

        // Step 1: Remove first K elements and push to stack
        for (int i = 0; i < k; i++) {
            stack.push(q.remove());
        }

        // Step 2: Push back to queue (reversed order)
        while (!stack.isEmpty()) {
            q.add(stack.pop());
        }

        // Step 3: Move remaining elements to rear
        int remaining = q.size() - k;
        for (int i = 0; i < remaining; i++) {
            q.add(q.remove());
        }
    }

    public static void main(String[] args) {

        Queue<Integer> q = new LinkedList<>();

        // Add elements
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        int k = 3;

        System.out.println("Original Queue: " + q);

        reverseFirstK(q, k);

        System.out.println("Modified Queue: " + q);
    }
}