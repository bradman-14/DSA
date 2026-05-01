//Given a stack of integers st[], Sort the stack in ascending order (smallest element at the bottom and largest at the top).

import java.util.*;

public class Sort_StackUsingRecursion {

    /*
     * FUNCTION 1: Sort the stack using recursion
     *
     * Logic:
     * 1. Pop top element
     * 2. Recursively sort remaining stack
     * 3. Insert popped element at correct position
     */
    static void sortStack(Stack<Integer> st) {

        // Base case: if stack is empty → already sorted
        if (st.isEmpty()) {
            return;
        }

        // Step 1: Remove top element
        int top = st.pop();

        // Step 2: Recursively sort remaining stack
        sortStack(st);

        // Step 3: Insert the removed element in sorted position
        insertSorted(st, top);
    }

    /*
     * FUNCTION 2: Insert element in sorted order
     *
     * Logic:
     * - If stack is empty OR top ≤ element → push directly
     * - Else → pop top, insert element recursively, then push back popped element
     */
    static void insertSorted(Stack<Integer> st, int element) {

        // Base condition:
        // If stack is empty OR correct position found
        if (st.isEmpty() || st.peek() <= element) {
            st.push(element);
            return;
        }

        // If current top is greater → remove it
        int temp = st.pop();

        // Recursively insert element deeper
        insertSorted(st, element);

        // Push the removed element back
        st.push(temp);
    }

    public static void main(String[] args) {

        Stack<Integer> st = new Stack<>();

        // Push elements into stack
        st.push(41);
        st.push(22);
        st.push(89);

        // Sort stack
        sortStack(st);

        // Print sorted stack
        System.out.println(st); // Output: [1, 2, 3]
    }
}