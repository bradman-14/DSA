// Given a string s, return the number of palindromic substrings in it.

import java.util.Scanner;

public class PalindromicSubstrings {

    // Function to count all palindromic substrings
    public static int countSubstrings(String s) {

        int count = 0; // stores total number of palindromes

        // Loop through each character → treat as center
        for (int i = 0; i < s.length(); i++) {

            // Case 1: Odd length palindrome (center = single char)
            count += expand(s, i, i);

            // Case 2: Even length palindrome (center between two chars)
            count += expand(s, i, i + 1);
        }

        return count;
    }

    // Helper function to expand around center and count palindromes
    public static int expand(String s, int left, int right) {

        int count = 0;

        // Expand while valid and characters match
        while (left >= 0 && right < s.length() &&
               s.charAt(left) == s.charAt(right)) {

            count++;  // Found one palindrome

            left--;   // move left pointer outward
            right++;  // move right pointer outward
        }

        return count; // return number of palindromes from this center
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String s = sc.nextLine();

        int result = countSubstrings(s);

        System.out.println("Total Palindromic Substrings: " + result);

        sc.close();
    }
}