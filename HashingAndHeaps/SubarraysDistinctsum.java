// This program calculates the sum of lengths of all subarrays with distinct elements

package HashingAndHeaps;

import java.util.*;

public class SubarraysDistinctsum {

    public static void main(String[] args) {

        // Input array
        int[] arr = {1, 2, 3};   // try {1,2,1} also

        // HashSet to store UNIQUE elements in current window
        Set<Integer> set = new HashSet<>();

        // Left pointer of sliding window
        int left = 0;

        // Final answer: sum of lengths of all valid subarrays
        long sum = 0;

        // Right pointer expands the window
        for (int right = 0; right < arr.length; right++) {

            /*
             * STEP 1: REMOVE DUPLICATES
             * If current element already exists in set,
             * window becomes invalid (not distinct)
             *
             * So we SHRINK window from LEFT
             * until duplicate is removed
             */
            while (set.contains(arr[right])) {
                set.remove(arr[left]);  // remove leftmost element
                left++;                // move left forward
            }

            /*
             * STEP 2: ADD CURRENT ELEMENT
             * Now window is valid (all elements distinct)
             */
            set.add(arr[right]);

            /*
             * STEP 3: CALCULATE CONTRIBUTION
             *
             * Current window size:
             * k = right - left + 1
             *
             * Subarrays ending at 'right' will have lengths:
             * 1, 2, 3, ..., k
             *
             * Their total length = k * (k + 1) / 2
             */
            int k = right - left + 1;

            sum += (long) k * (k + 1) / 2;  // IMPORTANT FIX
        }

        /*
         * FINAL RESULT
         */
        System.out.println("Sum of lengths of all distinct subarrays = " + sum);
    }
}