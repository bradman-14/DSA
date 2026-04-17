// This program finds the recurring sequence in the decimal representation of a fraction given by numerator and denominator. If there is no recurring sequence, it indicates that as well.

package HashingAndHeaps;

import java.util.*;

public class RecurringFraction {

    public static void main(String[] args) {

        int numerator = 50;
        int denominator = 22;

        System.out.println(findRecurring(numerator, denominator));
    }

    public static String findRecurring(int numerator, int denominator) {

        // Store remainder → index mapping
        Map<Integer, Integer> map = new HashMap<>();

        StringBuilder result = new StringBuilder();

        int remainder = numerator % denominator;

        // No decimal part → no recurring
        if (remainder == 0) {
            return "No recurring sequence";
        }

        while (remainder != 0) {

            // If remainder seen before → cycle found
            if (map.containsKey(remainder)) {

                int start = map.get(remainder);

                // Extract repeating part
                return "Recurring sequence is " + result.substring(start);
            }

            // Store position of this remainder
            map.put(remainder, result.length());

            // Multiply remainder by 10 (like long division)
            remainder *= 10;

            // Get next digit
            int digit = remainder / denominator;

            // Add digit to result
            result.append(digit);

            // Update remainder
            remainder = remainder % denominator;
        }

        return "No recurring sequence";
    }
}