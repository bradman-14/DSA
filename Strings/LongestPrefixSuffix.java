// Given a string, find the length of the longest prefix which is also a suffix.
// Note: The prefix and suffix can be overlapping.

public class LongestPrefixSuffix {

    public static int longestPrefixSuffix(String s) {

        int n = s.length();

        // LPS array
        int[] lps = new int[n];

        // length of previous longest prefix suffix
        int len = 0;

        // start from index 1 (0 is always 0)
        int i = 1;

        while (i < n) {

            // -------------------------------
            // CASE 1: characters match
            // -------------------------------
            if (s.charAt(i) == s.charAt(len)) {

                len++;          // increase length
                lps[i] = len;   // store it
                i++;            // move forward
            }

            // -------------------------------
            // CASE 2: mismatch
            // -------------------------------
            else {

                if (len != 0) {
                    // fallback to previous LPS
                    len = lps[len - 1];
                } else {
                    // no match at all
                    lps[i] = 0;
                    i++;
                }
            }
        }

        // last value gives answer
        return lps[n - 1];
    }

    public static void main(String[] args) {

        String s = "abab";

        int result = longestPrefixSuffix(s);

        System.out.println("Length of Longest Prefix = Suffix: " + result);
    }
}