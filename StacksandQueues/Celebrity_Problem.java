/*
 * CELEBRITY PROBLEM
 *
 *  CORE IDEA:
 * A celebrity is someone who:
 * 1. Everyone knows them
 * 2. They know no one
 *
 *  APPROACH:
 * Step 1: Find a potential candidate using elimination
 * Step 2: Verify if candidate is actually a celebrity
 */

public class Celebrity_Problem {

    // Function to find celebrity
    static int findCelebrity(int[][] mat, int n) {

        /*
         * STEP 1: Find potential candidate
         *
         * Start with candidate = 0
         * Compare with others:
         * If candidate knows i → candidate cannot be celebrity
         * → update candidate = i
         */
        int candidate = 0;

        for (int i = 1; i < n; i++) {

            // If candidate knows i → candidate is not celebrity
            if (mat[candidate][i] == 1) {
                candidate = i;
            }
            // Else → i is not celebrity, ignore i
        }

        /*
         * STEP 2: Verify candidate
         */

        for (int i = 0; i < n; i++) {

            if (i == candidate) continue;

            /*
             * Condition 1:
             * Candidate should NOT know anyone
             */
            if (mat[candidate][i] == 1) {
                return -1;
            }

            /*
             * Condition 2:
             * Everyone should know candidate
             */
            if (mat[i][candidate] == 0) {
                return -1;
            }
        }

        // If both conditions satisfied → celebrity found
        return candidate;
    }

    public static void main(String[] args) {

        int[][] mat = {
            {1, 1, 0},
            {0, 1, 0},
            {0, 1, 1}
        };

        int n = mat.length;

        int result = findCelebrity(mat, n);

        if (result == -1) {
            System.out.println("No Celebrity");
        } else {
            System.out.println("Celebrity Index: " + result);
        }
    }
}