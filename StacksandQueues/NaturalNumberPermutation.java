/*
 * PROBLEM:
 * Count natural numbers from 1 to n such that
 * ALL permutations of their digits are ≥ the number itself.
 *
 *  CORE LOGIC:
 * A number satisfies the condition IF AND ONLY IF
 * its digits are in NON-DECREASING order (left → right).
 *
 * WHY?
 * - The smallest permutation of any number = digits sorted ascending
 * - If original number == smallest permutation → valid
 *
 * Example:
 * 123 → smallest permutation = 123 valid
 * 132 → smallest permutation = 123 invalid
 *
 *  APPROACH (Using STACK):
 * 1. Extract digits and push into stack (reverses order)
 * 2. Pop to process digits from left → right
 * 3. Check if digits ever decrease
 * 4. If yes → invalid, else valid
 */

import java.util.*;

public class NaturalNumberPermutation
{

    // Function to check if digits are non-decreasing
    static boolean isValid(int num) {

        // Stack to store digits
        Stack<Integer> st = new Stack<>();

        /*
         * Step 1: Extract digits from number
         * and push into stack
         * Example: 123 → push 3,2,1
         */
        while (num > 0) {
            st.push(num % 10);  // get last digit
            num /= 10;          // remove last digit
        }

        /*
         * Step 2: Compare digits in correct order
         * (left → right after popping)
         */
        int prev = -1;  // stores previous digit

        while (!st.isEmpty()) {

            int curr = st.pop(); // get next digit

            /*
             * If digits decrease → invalid
             * Example: 132 → 3 > 2 → invalid
             */
            if (prev > curr) {
                return false;
            }

            // Update previous digit
            prev = curr;
        }

        // If no violation → valid number
        return true;
    }

    // Function to count valid numbers from 1 to n
    static int countValid(int n) {

        int count = 0;

        // Check each number
        for (int i = 1; i <= n; i++) {

            if (isValid(i)) {
                count++;  // increment if valid
            }
        }

        return count;
    }

    // Driver function
    public static void main(String[] args) {

        int n = 15;

        // Output result
        System.out.println(countValid(n)); // Output: 14
    }
}