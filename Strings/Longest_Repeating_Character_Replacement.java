// This program finds the length of the longest substring that can be obtained by replacing at most k characters in a given string.

import java.util.Scanner;

public class Longest_Repeating_Character_Replacement {
    public static int characterReplacement(String s, int k) {

        // Array to store frequency of characters (A-Z)
        int[] count = new int[26];

        int left = 0;        // Left pointer of sliding window
        int maxFreq = 0;     // Stores max frequency of any character in current window
        int maxLength = 0;   // Stores the final answer

        // Right pointer expands the window
        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            // Increase frequency of current character
            count[ch - 'A']++;

            // Update max frequency in current window
            // This tells which character is most frequent (we keep this one)
            maxFreq = Math.max(maxFreq, count[ch - 'A']);

            // Check if window is invalid:
            // (window size - maxFreq) = number of replacements needed
            // If replacements needed > k → shrink window
            while ((right - left + 1) - maxFreq > k) {

                // Remove leftmost character from window
                count[s.charAt(left) - 'A']--;

                // Move left pointer forward
                left++;
            }

            // Update maximum valid window length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        // Return the longest valid substring length
        return maxLength;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input string
        System.out.print("Enter string (only uppercase letters): ");
        String s = sc.nextLine();

        // Input k
        System.out.print("Enter k (number of replacements allowed): ");
        int k = sc.nextInt();

        // Call function
        int result = characterReplacement(s, k);

        // Output result
        System.out.println("Longest repeating substring length: " + result);

        sc.close();
    }
}
