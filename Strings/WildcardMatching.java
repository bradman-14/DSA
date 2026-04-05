//Given two strings wild and pattern.
//Determine if the given two strings can be matched given that, wild string may contain * and ? but string pattern will not
//* --> This character in string wild can be replaced by any sequence of characters, it can also be replaced by an empty string.
//? --> This character in string wild can be replaced by any one character.


public class WildcardMatching {

    public static boolean isMatch(String wild, String pattern) {

        int i = 0; // pointer for wild
        int j = 0; // pointer for pattern

        int starIndex = -1; // position of last '*'
        int match = 0;      // position in pattern when '*' was found

        while (j < pattern.length()) {

            // -------------------------------
            // CASE 1: characters match OR '?'
            // -------------------------------
            if (i < wild.length() &&
                (wild.charAt(i) == pattern.charAt(j) || wild.charAt(i) == '?')) {

                i++;
                j++;
            }

            // -------------------------------
            // CASE 2: '*' found
            // -------------------------------
            else if (i < wild.length() && wild.charAt(i) == '*') {

                starIndex = i; // store position of '*'
                match = j;     // store current pattern index
                i++;           // move wild pointer
            }

            // -------------------------------
            // CASE 3: mismatch but '*' was found earlier
            // -------------------------------
            else if (starIndex != -1) {

                // go back to '*' and try to match more characters
                i = starIndex + 1;
                match++;
                j = match;
            }

            // -------------------------------
            // CASE 4: mismatch and no '*'
            // -------------------------------
            else {
                return false;
            }
        }

        // -------------------------------
        // CHECK remaining characters in wild
        // -------------------------------
        // Only '*' can remain
        while (i < wild.length() && wild.charAt(i) == '*') {
            i++;
        }

        return i == wild.length();
    }

    // -------------------------------
    // MAIN FUNCTION
    // -------------------------------
    public static void main(String[] args) {

        String wild = "a*b";
        String pattern = "aaab";

        boolean result = isMatch(wild, pattern);

        System.out.println("Match result: " + result);
    }
}