// Given a text and a pattern, find all starting indices in the text where the pattern occurs as a substring.

import java.util.*;

public class PatternSearch {

    // Function to find all starting indices where pattern occurs in text
    public static List<Integer> search(String text, String pattern) {

        // List to store result indices
        List<Integer> result = new ArrayList<>();

        // Length of text and pattern
        int n = text.length();
        int m = pattern.length();

        // ------------------------------------------
        // Outer loop: try every possible starting index
        // ------------------------------------------
        // We go till (n - m) because pattern length is m
        for (int i = 0; i <= n - m; i++) {

            boolean match = true; // assume match initially

            // ------------------------------------------
            // Inner loop: compare pattern with substring
            // ------------------------------------------
            for (int j = 0; j < m; j++) {

                // Compare characters one by one
                if (text.charAt(i + j) != pattern.charAt(j)) {

                    // If mismatch found → break immediately
                    match = false;
                    break;
                }
            }

            // ------------------------------------------
            // If match is true → full pattern matched
            // ------------------------------------------
            if (match) {
                result.add(i); // store starting index
            }
        }

        // Return all matching indices
        return result;
    }

    // ------------------------------------------
    // MAIN FUNCTION
    // ------------------------------------------
    public static void main(String[] args) {

        String text = "ababcabcab";
        String pattern = "abc";

        // Call search function
        List<Integer> result = search(text, pattern);

        // Print result
        System.out.println("Pattern found at indices: " + result);
    }
}