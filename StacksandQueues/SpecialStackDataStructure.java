/*
 * SPECIAL STACK
 *Design a Data Structure SpecialStack that supports all the stack operations like push(), pop(), isEmpty(), isFull() and an additional operation getMin() 
    *which should return minimum element from the SpecialStack. (Expected time complexity for all operations is O(1))
 * CORE IDEA:
 * Use TWO stacks:
 * 1. Main stack → stores all elements
 * 2. Min stack → stores minimum elements
 *
 * getMin() → always return top of min stack
 */

import java.util.*;

public class SpecialStackDataStructure {

    static class SpecialStack {

        Stack<Integer> mainStack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();

        // Push operation
        void push(int x) {

            // Push into main stack
            mainStack.push(x);

            /*
             * If min stack is empty OR
             * current element is smaller or equal
             * → push into min stack
             */
            if (minStack.isEmpty() || x <= minStack.peek()) {
                minStack.push(x);
            }
        }

        // Pop operation
        int pop() {

            if (mainStack.isEmpty()) {
                System.out.println("Stack Underflow");
                return -1;
            }

            int removed = mainStack.pop();

            /*
             * If removed element is equal to
             * current minimum → pop from min stack also
             */
            if (removed == minStack.peek()) {
                minStack.pop();
            }

            return removed;
        }

        // Get minimum element
        int getMin() {

            if (minStack.isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }

            return minStack.peek();
        }

        boolean isEmpty() {
            return mainStack.isEmpty();
        }

        boolean isFull() {
            // Stack is dynamic → never full
            return false;
        }
    }

    public static void main(String[] args) {

        SpecialStack st = new SpecialStack();

        st.push(18);
        st.push(19);
        st.push(29);
        st.push(15);
        st.push(16);

        System.out.println("Minimum: " + st.getMin()); // 15

        st.pop();
        st.pop();

        System.out.println("Minimum after pops: " + st.getMin()); // 18
    }
}