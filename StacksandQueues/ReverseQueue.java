import java.util.*;

public class ReverseQueue {

    // Function to reverse queue
    public static void reverseQueue(Queue<Integer> q) {

        // Create stack
        Stack<Integer> stack = new Stack<>();

        // Step 1: Move all elements to stack
        while (!q.isEmpty()) {
            stack.push(q.remove());
        }

        // Step 2: Move back to queue (reversed)
        while (!stack.isEmpty()) {
            q.add(stack.pop());
        }
    }

    public static void main(String[] args) {

        Queue<Integer> q = new LinkedList<>();

        // Add elements
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        System.out.println("Original Queue: " + q);

        // Reverse queue
        reverseQueue(q);

        System.out.println("Reversed Queue: " + q);
    }
}