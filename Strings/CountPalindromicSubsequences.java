public class CountPalindromicSubsequences {

    // Global variable to store count of palindromic subsequences
    static int count = 0;

    // Function to generate all subsequences
    public static void generate(String s, int index, String current) {

        // -------------------------------
        // BASE CASE
        // -------------------------------
        // If we have reached the end of the string
        if (index == s.length()) {

            // Ignore empty subsequence
            // Check if current subsequence is palindrome
            if (current.length() > 0 && isPalindrome(current)) {

                // If yes → increase count
                count++;
            }

            // Stop recursion for this branch
            return;
        }

        // -------------------------------
        // CHOICE 1: INCLUDE CURRENT CHARACTER
        // -------------------------------
        // Add current character to subsequence
        generate(s, index + 1, current + s.charAt(index));

        // -------------------------------
        // CHOICE 2: EXCLUDE CURRENT CHARACTER
        // -------------------------------
        // Do not add current character
        generate(s, index + 1, current);
    }

    // Function to check if a string is palindrome
    public static boolean isPalindrome(String str) {

        int left = 0;
        int right = str.length() - 1;

        // Compare characters from both ends
        while (left < right) {

            // If mismatch found → not palindrome
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }

            // Move pointers inward
            left++;
            right--;
        }

        // If all characters matched → palindrome
        return true;
    }

    // -------------------------------
    // MAIN FUNCTION
    // -------------------------------
    public static void main(String[] args) {

        String s = "aab";

        // Start recursion
        generate(s, 0, "");

        // Print result
        System.out.println("Total Palindromic Subsequences: " + count);
    }
}