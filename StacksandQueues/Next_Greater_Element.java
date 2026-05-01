//You are given an array arr[] of integers, the task is to find the next greater element for each element of the array in order of their appearance in the array
//Next greater element of an element in the array is the nearest element on the right which is greater than the current element.

import java.util.*;

public class Next_Greater_Element {

    public static int[] nextGreater(int[] arr) {

        int n = arr.length;
        int[] result = new int[n];

        Stack<Integer> st = new Stack<>();

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {

            /*
             * Remove all elements smaller than or equal to current
             */
            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }

            /*
             * If stack is empty → no greater element
             */
            if (st.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = st.peek();
            }

            /*
             * Push current element into stack
             */
            st.push(arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr = {4, 5, 2, 10};

        int[] res = nextGreater(arr);

        System.out.println(Arrays.toString(res));
    }
}