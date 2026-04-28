//We have an empty stack and can perform push and pop operations.
//We are given two arrays, a[] and b[] of same length, where a[] represents the order in which elements are pushed onto the stack, and b[] represents the order in which elements are popped from the stack
//Find whether the given push and pop sequences are valid.

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Stack_Permutations {

    static boolean checkPerm(int[] a, int[] b) {

        // Queue to simulate input (push sequence)
        Queue<Integer> q1 = new LinkedList<>();
        for (int i = 0; i < a.length; i++) 
            q1.add(a[i]);

        // Queue to simulate desired output (pop sequence)
        Queue<Integer> q2 = new LinkedList<>();
        for (int i = 0; i < b.length; i++)
            q2.add(b[i]);

        // Stack to simulate actual stack operations
        Stack<Integer> st = new Stack<>();
        
        // Process all elements from input queue
        while (!q1.isEmpty()) {

            // Take front element from input queue (simulate push)
            int ele = q1.poll();
            
            /*
             * If current element matches the expected output element
             * → simulate immediate push + pop
             */
            if (ele == q2.peek()) {
                
                // Remove matched element from output queue
                q2.poll();
                
                /*
                 * Now check stack:
                 * If stack top matches next expected output,
                 * pop it as well
                 */
                while (!st.isEmpty() && !q2.isEmpty() && st.peek() == q2.peek()) {
                    st.pop();      // pop from stack
                    q2.poll();     // remove from output queue
                }
            }
            else {
                /*
                 * If it doesn't match expected output,
                 * push it into stack for later use
                 */
                st.push(ele);
            }
        }
        
        /*
         * If output queue is empty,
         * all elements were matched correctly
         * → valid stack permutation
         */
        return q2.isEmpty();
    }

    public static void main(String[] args) {

        int[] a = {1, 2, 3};  // push sequence
        int[] b = {3, 2, 1};  // desired pop sequence
        
        if (checkPerm(a, b))
            System.out.println("true");
        else
            System.out.println("false");
    }
}