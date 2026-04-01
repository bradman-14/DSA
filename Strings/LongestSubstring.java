// This program finds the length of the longest substring without repeating characters in a given string.

import java.util.Scanner;

public class LongestSubstring {

    public static int lengthOfLongestSubstring(String s) {

        int left = 0;            // left pointer of sliding window
        int maxLength = 0;       // stores the maximum length found

        int[] count = new int[256]; // array to store frequency of characters (ASCII)

        // right pointer expands the window
        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right); // current character

            count[ch]++; // increase frequency of current character

            // If duplicate found (count > 1), shrink window
            while (count[ch] > 1) {

                // remove character at left pointer
                count[s.charAt(left)]--;

                left++; // move left pointer forward
            }

            // calculate current window length and update max
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength; // final answer
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String s = sc.nextLine();

        int result = lengthOfLongestSubstring(s);

        System.out.println("Length of longest substring without repeating characters: " + result);

        sc.close();
    }
}