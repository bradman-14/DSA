//Given two strings s and p. Find the smallest substring in s consisting of all the characters of the string p.

public class SmallestWindowSubstring {

    // Function to find smallest window
    public static String minWindow(String s, String p) {

        // Edge case: if s is smaller than p, no solution
        if (s.length() < p.length()) return "";

        // -------------------------------
        // STEP 1: Create frequency array
        // -------------------------------
        // This will store how many times each character is needed
        int[] freq = new int[256];

        // Fill frequency using string p
        for (char c : p.toCharArray()) {
            freq[c]++;
        }

        // -------------------------------
        // STEP 2: Initialize variables
        // -------------------------------
        int left = 0;              // left pointer of window
        int count = p.length();    // total characters we still need

        int minLen = Integer.MAX_VALUE; // store minimum window length
        int start = 0;                  // starting index of answer

        // -------------------------------
        // STEP 3: Expand window using right pointer
        // -------------------------------
        for (int right = 0; right < s.length(); right++) {

            char current = s.charAt(right);

            // If this character is required (freq > 0)
            if (freq[current] > 0) {
                count--; // we matched one required character
            }

            // Decrease frequency (mark this character as used)
            freq[current]--;

            // -------------------------------
            // STEP 4: When window becomes valid
            // -------------------------------
            // count == 0 means all characters of p are present
            while (count == 0) {

                // Update minimum window if current is smaller
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                // Now try to shrink window from left
                char leftChar = s.charAt(left);

                // Increase frequency since we are removing this char
                freq[leftChar]++;

                // If after removing, freq > 0 → we are missing that char
                if (freq[leftChar] > 0) {
                    count++; // window becomes invalid
                }

                // Move left pointer forward
                left++;
            }
        }

        // -------------------------------
        // STEP 5: Return result
        // -------------------------------
        if (minLen == Integer.MAX_VALUE) return "";

        return s.substring(start, start + minLen);
    }

    // -------------------------------
    // MAIN FUNCTION
    // -------------------------------
    public static void main(String[] args) {

        String s = "ADOBECODEBANC";
        String p = "ABC";

        String result = minWindow(s, p);

        System.out.println("Smallest Window: " + result);
    }
}