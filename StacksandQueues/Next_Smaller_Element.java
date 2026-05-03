import java.util.*;

class Next_Smaller_Element {

    /*
    ===================== LOGIC =====================

    Problem: Find Next Smaller Element (NSE) for each element.

    Approach: Monotonic Stack

    1. Traverse array from right to left
    2. Maintain a stack that stores possible smaller elements
    3. For each element:
       - Remove all elements >= current (they are useless)
       - If stack empty → answer = -1
       - Else → top of stack = NSE
       - Push current element into stack

    Time Complexity: O(n)
    Space Complexity: O(n)

    =================================================
    */

    public int[] nextSmaller(int[] arr) {

        int n = arr.length;
        int[] ans = new int[n];

        Stack<Integer> st = new Stack<>();

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {

            // Remove elements >= current
            while (!st.isEmpty() && st.peek() >= arr[i]) {
                st.pop();
            }

            // If stack empty → no smaller element
            if (st.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = st.peek();
            }

            // Push current element
            st.push(arr[i]);
        }

        return ans;
    }

    // -------------------------------
    // MAIN FUNCTION
    // -------------------------------
    public static void main(String[] args) {

        Next_Smaller_Element obj = new Next_Smaller_Element();

        int[] arr = {4, 8, 5, 2, 25};

        int[] result = obj.nextSmaller(arr);

        System.out.println("Next Smaller Elements:");
        for (int x : result) {
            System.out.print(x + " ");
        }
    }
}