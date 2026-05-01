/*
 * PROBLEM:
 * Given a stream of characters, print the first non-repeating character
 * after each character is inserted.
 *
 * CORE IDEA:
 * 1. Use a frequency array to count occurrences of each character.
 * 2. Use a queue to maintain order of characters.
 * 3. For each incoming character:
 *      - Add it to queue
 *      - Increase its frequency
 *      - Remove all characters from front of queue whose frequency > 1
 *      - The front of queue is the first non-repeating character
 */

import java.util.*;

public class First_non_repeating_character_in_a_stream {

    public static void firstNonRepeating(String stream) {

        // Queue to store characters in order
        Queue<Character> q = new LinkedList<>();

        // Frequency array for 26 lowercase letters
        int[] freq = new int[26];

        // Traverse the stream
        for (int i = 0; i < stream.length(); i++) {

            char ch = stream.charAt(i);

            // Step 1: Add character to queue
            q.add(ch);

            // Step 2: Increase frequency
            freq[ch - 'a']++;

            /*
             * Step 3: Remove repeating characters from front
             * Keep removing until front is non-repeating
             */
            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.poll(); // remove from queue
            }

            /*
             * Step 4: Print result
             * If queue is empty → no non-repeating character
             * Else → front of queue is answer
             */
            if (q.isEmpty()) {
                System.out.print("-1 ");
            } else {
                System.out.print(q.peek() + " ");
            }
        }
    }

    public static void main(String[] args) {

        String stream = "aabc";

        // Expected Output: a -1 b b
        firstNonRepeating(stream);
    }
}