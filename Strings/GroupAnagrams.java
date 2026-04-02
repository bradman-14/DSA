//Given an array of strings strs, group the anagrams together. You can return the answer in any order.

import java.util.*;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {

        // Map: key = frequency string, value = list of anagrams
        HashMap<String, List<String>> map = new HashMap<>();

        // Loop through each word
        for (String word : strs) {

            // Step 1: Create frequency array for 26 letters (a–z)
            int[] count = new int[26];

            // Step 2: Count each character in the word
            for (char ch : word.toCharArray()) {
                count[ch - 'a']++;
            }

            // Step 3: Build a string key from frequency array
            // This key will uniquely identify anagrams
            StringBuilder keyBuilder = new StringBuilder();

            // Step 4: Convert frequency array into string
            // Example: "eat" → "1#0#0#...#1#...#1"
            for (int i = 0; i < 26; i++) {
                keyBuilder.append(count[i]).append("#");
            }

            // Step 5: Convert StringBuilder to String
            String key = keyBuilder.toString();

            // Step 6: If key not present, create new list
            map.putIfAbsent(key, new ArrayList<>());

            // Step 7: Add current word to the corresponding group
            map.get(key).add(word);
        }

        // Step 8: Return all grouped anagrams
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of words: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        String[] strs = new String[n];

        System.out.println("Enter words:");
        for (int i = 0; i < n; i++) {
            strs[i] = sc.nextLine();
        }

        List<List<String>> result = groupAnagrams(strs);

        // Print result
        System.out.println("\nGrouped Anagrams:");
        for (List<String> group : result) {
            System.out.println(group);
        }

        sc.close();
    }
}