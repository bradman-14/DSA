/*
 * FIND DUPLICATE PARENTHESES
 *
 *  CORE IDEA:
 * - Use a stack to store characters of the expression.
 * - Whenever we encounter a closing bracket ')':
 *     1. Check what is inside the corresponding '('.
 *     2. If nothing or only one element is inside → duplicate parentheses.
 *
 * Duplicate cases:
 *    ()        → empty
 *    (a)       → only one element
 *
 *  Valid case:
 *    (a+b)     → contains operator → meaningful
 */

import java.util.*;

public class FindDuplicateParentheses {

    public static boolean hasDuplicateParentheses(String s) {

        // Stack to store characters
        Stack<Character> stack = new Stack<>();

        // Traverse each character of the string
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // If current character is NOT ')'
            if (ch != ')') {

                // Push everything into stack
                stack.push(ch);

            } else {
                /*
                 * We found a closing bracket ')'
                 * Now we check what is inside the corresponding '('
                 */

                // Case 1: Immediate '(' → empty parentheses "()"
                if (stack.peek() == '(') {
                    return true; // duplicate found
                }

                // Count elements inside the parentheses
                int count = 0;

                // Pop elements until '(' is found
                while (stack.peek() != '(') {
                    stack.pop();
                    count++;
                }

                // Remove the opening '('
                stack.pop();

                /*
                 * Case 2:
                 * If number of elements inside ≤ 1
                 * → duplicate parentheses
                 *
                 * Example:
                 * (a) → count = 1 → duplicate
                 */
                if (count <= 1) {
                    return true;
                }
            }
        }

        // If no duplicate parentheses found
        return false;
    }

    public static void main(String[] args) {

        String s1 = "((a+b))";
        System.out.println(hasDuplicateParentheses(s1)); // true

        String s2 = "(a+(b)/c)";
        System.out.println(hasDuplicateParentheses(s2)); // true

        String s3 = "(a+b*(c-d))";
        System.out.println(hasDuplicateParentheses(s3)); // false
    }
}