/*
 * LONGEST VALID PARENTHESES
 *
 * CORE IDEA:
 * - Use a stack to store indices of unmatched parentheses.
 * - Push -1 initially to act as a base for length calculation.
 * - For every ')':
 *     → pop once
 *     → if stack becomes empty → push current index (new invalid boundary)
 *     → else → calculate length = current index - stack.peek()
 *
 * stack.peek() always represents the last invalid position
 * length = distance between current index and last invalid index
 */

import java.util.*;

public class LongestValidParenthesesSubstring {

    public static int longestValidParentheses(String s) {

        // Stack to store indices
        Stack<Integer> stack = new Stack<>();

        // Push base index (important for length calculation)
        stack.push(-1);

        int maxLength = 0;

        // Traverse the string
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '(') {
                /*
                 * If current char is '('
                 * → push its index
                 * because it might match later
                 */
                stack.push(i);

            } else {
                /*
                 * If current char is ')'
                 * → try to match it by popping
                 */
                stack.pop();

                if (stack.isEmpty()) {
                    /*
                     * If stack becomes empty
                     * → no matching '(' available
                     * → this is an invalid boundary
                     * → push current index as new base
                     */
                    stack.push(i);
                } else {
                    /*
                     * If stack is NOT empty
                     * → we found a valid substring
                     *
                     * Length = current index - last unmatched index
                     */
                    int length = i - stack.peek();

                    // Update maximum length
                    maxLength = Math.max(maxLength, length);
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {

        String s1 = "(()";
        System.out.println("Output: " + longestValidParentheses(s1)); // 2

        String s2 = ")()())";
        System.out.println("Output: " + longestValidParentheses(s2)); // 4

        String s3 = "()(())";
        System.out.println("Output: " + longestValidParentheses(s3)); // 6
    }
}