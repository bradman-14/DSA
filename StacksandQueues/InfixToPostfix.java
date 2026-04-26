/*
 * INFIX TO POSTFIX CONVERSION
 *
 *  CORE LOGIC (SHORT):
 * 1. Traverse the infix expression left to right.
 * 2. If operand → add directly to result.
 * 3. If '(' → push to stack.
 * 4. If ')' → pop until '(' is found.
 * 5. If operator:
 *    - Pop from stack while top has higher or equal precedence.
 *    - Special case: '^' is right associative (use > instead of >=).
 *    - Then push current operator.
 * 6. At the end, pop all remaining operators.
 *
 * Stack is used to temporarily hold operators.
 * Result string stores postfix expression.
 */

import java.util.*;

public class InfixToPostfix {

    // Function to return precedence of operators
    static int precedence(char ch) {
        if (ch == '+' || ch == '-') return 1;   // lowest
        if (ch == '*' || ch == '/') return 2;   // medium
        if (ch == '^') return 3;                // highest
        return -1;
    }

    // Function to check if character is operator
    static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' ||
               ch == '*' || ch == '/' ||
               ch == '^';
    }

    // Function to convert infix to postfix
    public static String infixToPostfix(String s) {

        // StringBuilder for efficient string concatenation
        StringBuilder result = new StringBuilder();

        // Stack to store operators
        Stack<Character> stack = new Stack<>();

        // Traverse the expression
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // 1. If operand → add to result
            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);
            }

            // 2. If '(' → push to stack
            else if (ch == '(') {
                stack.push(ch);
            }

            // 3. If ')' → pop until '('
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop(); // remove '('
            }

            // 4. If operator
            else if (isOperator(ch)) {

                /*
                 * Pop operators from stack while:
                 * - stack is not empty
                 * - AND precedence condition is satisfied
                 *
                 * For normal operators → >=
                 * For '^' (right associative) → >
                 */
                while (!stack.isEmpty() &&
                      (
                       (ch != '^' && precedence(stack.peek()) >= precedence(ch)) ||
                       (ch == '^' && precedence(stack.peek()) > precedence(ch))
                      )
                ) {
                    result.append(stack.pop());
                }

                // Push current operator
                stack.push(ch);
            }
        }

        // 5. Pop remaining operators
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    // Main function to test
    public static void main(String[] args) {

        String s1 = "a*(b+c)/d";
        System.out.println("Postfix: " + infixToPostfix(s1)); // abc+*d/

        String s2 = "a+b*c+d";
        System.out.println("Postfix: " + infixToPostfix(s2)); // abc*+d+
    }
}