import java.util.*;

/*
 * Implement Stack using ONE Queue
 * Idea:
 * - Push element into queue
 * - Rotate previous elements so new element comes to front
 * - This makes queue behave like a stack (LIFO)
 */

class MyStack {

    Queue<Integer> q;

    // Constructor
    public MyStack() {
        q = new LinkedList<>();
    }

  
     // PUSH operation
     
    public void push(int x) {

        // Step 1: Add new element
        q.add(x);

        /*
         * Step 2: Rotate the queue
         * Move all previous elements behind the new element
         */
        for (int i = 0; i < q.size() - 1; i++) {
            q.add(q.remove());
        }

        System.out.println("Pushed: " + x);
    }

    /*
     * POP operation
     * Removes top element (front of queue)
     */
    public int pop() {
        if (q.isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }

        int val = q.remove();
        System.out.println("Popped: " + val);
        return val;
    }

    /*
     * TOP operation
     * Returns top element without removing
     */
    public int top() {
        if (q.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return q.peek();
    }

    /*
     * Check if stack is empty
     */
    public boolean empty() {
        return q.isEmpty();
    }

    /*
     * Utility function to display queue (for understanding)
     */
    public void printStack() {
        System.out.println("Current Stack (front = top): " + q);
        System.out.println("---------------------------");
    }
}

/*
 * Main class to test the implementation
 */
public class Stacks_using_Queues {

    public static void main(String[] args) {

        MyStack stack = new MyStack();

        // Push elements
        stack.push(10);
        stack.printStack();

        stack.push(20);
        stack.printStack();

        stack.push(30);
        stack.printStack();

        // Top element
        System.out.println("Top element: " + stack.top());
        System.out.println("---------------------------");

        // Pop elements
        stack.pop();
        stack.printStack();

        stack.pop();
        stack.printStack();

        // Check empty
        System.out.println("Is stack empty? " + stack.empty());

        stack.pop();
        stack.printStack();

        System.out.println("Is stack empty? " + stack.empty());
    }
}