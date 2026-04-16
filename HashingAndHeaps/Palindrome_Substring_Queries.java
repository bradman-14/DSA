// Given a string s and a list of queries, each query consists of two integers l and r. For each query, determine if the substring s[l…r] is a palindrome. A palindrome is a string that reads the same backward as forward.
class lindrome_Substring_QueriesPa {

    // Base for hashing (like 10 in numbers)
    static final int BASE = 31;

    // Mod to avoid overflow and reduce collisions
    static final int MOD = 1000000007;

    public static void palindromeQueries(String s, int[][] queries) {

        int n = s.length();

        // 🔹 forwardHash[i] → hash of substring s[0…i]
        long[] forwardHash = new long[n];

        // 🔹 reverseHash[i] → hash of substring s[i…n-1]
        long[] reverseHash = new long[n];

        // 🔹 power[i] → BASE^i (used for shifting)
        long[] power = new long[n];

        // ---------------------------------------
        // STEP 1: Precompute powers
        // ---------------------------------------
        power[0] = 1;
        for (int i = 1; i < n; i++) {
            power[i] = (power[i - 1] * BASE) % MOD;
        }

        // ---------------------------------------
        // STEP 2: Build forward hash
        // forwardHash[i] = hash of s[0…i]
        // ---------------------------------------
        forwardHash[0] = s.charAt(0) - 'a' + 1;

        for (int i = 1; i < n; i++) {

            int val = s.charAt(i) - 'a' + 1;

            // Multiply previous hash by BASE (shift left)
            // then add current character
            forwardHash[i] = (forwardHash[i - 1] * BASE + val) % MOD;
        }

        // ---------------------------------------
        // STEP 3: Build reverse hash
        // reverseHash[i] = hash of s[i…n-1]
        // ---------------------------------------
        reverseHash[n - 1] = s.charAt(n - 1) - 'a' + 1;

        for (int i = n - 2; i >= 0; i--) {

            int val = s.charAt(i) - 'a' + 1;

            // Similar to forward hash but from right side
            reverseHash[i] = (reverseHash[i + 1] * BASE + val) % MOD;
        }

        // ---------------------------------------
        // STEP 4: Process each query
        // ---------------------------------------
        for (int[] q : queries) {

            int l = q[0];
            int r = q[1];

            // ---------------------------------------
            // 🔹 Get forward hash of substring s[l…r]
            // ---------------------------------------

            long hash1 = forwardHash[r];

            // If substring doesn't start at 0,
            // subtract the unwanted left part
            if (l > 0) {

                hash1 = (hash1
                        - (forwardHash[l - 1] * power[r - l + 1]) % MOD
                        + MOD) % MOD;
            }

            // ---------------------------------------
            // 🔹 Get reverse hash of substring s[l…r]
            // ---------------------------------------

            long hash2 = reverseHash[l];

            // If substring doesn't end at last index,
            // subtract the unwanted right part
            if (r < n - 1) {

                hash2 = (hash2
                        - (reverseHash[r + 1] * power[r - l + 1]) % MOD
                        + MOD) % MOD;
            }

            // ---------------------------------------
            // 🔹 Compare hashes
            // ---------------------------------------

            if (hash1 == hash2) {
                System.out.println("Yes");  // Palindrome
            } else {
                System.out.println("No");   // Not palindrome
            }
        }
    }

    // Driver code
    public static void main(String[] args) {

        String s = "ababa";

        int[][] queries = {
            {0, 2},   // "aba" → Yes
            {1, 3},   // "bab" → Yes
            {1, 4}    // "baba" → No
        };

        palindromeQueries(s, queries);
    }
}