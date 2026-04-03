import java.util.Scanner;

public class LongestPalindrome {

    // Function to find longest palindromic substring
    public static String longestPalindrome(String s) {

        // Edge case: if string is empty or null
        if (s == null || s.length() < 1) return "";

        int start = 0, end = 0; // stores indices of longest palindrome

        // Loop through each character → treat each as center
        for (int i = 0; i < s.length(); i++) {

            // Case 1: Odd length palindrome (center is single character)
            // Example: "aba"
            int len1 = expand(s, i, i);

            // Case 2: Even length palindrome (center is between two characters)
            // Example: "abba"
            int len2 = expand(s, i, i + 1);

            // Take the maximum length from both cases
            int len = Math.max(len1, len2);

            // If current palindrome is longer than previous best
            if (len > end - start) {

                // Calculate start index of palindrome
                // (len - 1)/2 handles left side expansion
                start = i - (len - 1) / 2;

                // Calculate end index of palindrome
                // len/2 handles right side expansion
                end = i + len / 2;
            }
        }

        // Return substring from start to end (inclusive)
        return s.substring(start, end + 1);
    }

    // Helper function to expand around center
    public static int expand(String s, int left, int right) {

        // Expand as long as:
        // 1. left pointer is within bounds
        // 2. right pointer is within bounds
        // 3. characters at left and right are equal
        while (left >= 0 && right < s.length() &&
               s.charAt(left) == s.charAt(right)) {

            left--;   // move left pointer outward
            right++;  // move right pointer outward
        }

        // After loop, pointers have gone one step extra
        // So actual palindrome length = right - left - 1
        return right - left - 1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String s = sc.nextLine();

        // Call function
        String result = longestPalindrome(s);

        // Print result
        System.out.println("Longest Palindromic Substring: " + result);

        sc.close();
    }
}