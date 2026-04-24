import java.util.*;

public class PostfixEvaluation {

    public static int evaluatePostfix(String[] arr) {

        // Stack to store operands
        Stack<Integer> stack = new Stack<>();

        for (String token : arr) {

            // If token is a number → push
            if (!isOperator(token)) {
                stack.push(Integer.parseInt(token));
            } else {

                // Pop two operands
                int b = stack.pop(); // second operand
                int a = stack.pop(); // first operand

                int result = 0;

                switch (token) {
                    case "+":
                        result = a + b;
                        break;

                    case "-":
                        result = a - b;
                        break;

                    case "*":
                        result = a * b;
                        break;

                    case "/":
                        result = a / b; // integer division
                        break;

                    case "^":
                        result = (int) Math.pow(a, b);
                        break;
                }

                // Push result back
                stack.push(result);
            }
        }

        // Final result
        return stack.pop();
    }

    // Helper function to check operator
    public static boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") ||
               s.equals("*") || s.equals("/") ||
               s.equals("^");
    }

    public static void main(String[] args) {

        String[] arr1 = {"2", "3", "1", "*", "+", "9", "-"};
        System.out.println(evaluatePostfix(arr1)); 

        String[] arr2 = {"2", "3", "^", "1", "+"};
        System.out.println(evaluatePostfix(arr2)); 
    }
}