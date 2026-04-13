//Given an array of strings (all lowercase letters), the task is to group them in such a way that all strings in a group are shifted versions of each other.
//wo strings s1 and s2 are called shifted if:
//s1.length is equal to s2.length
//s1[i] is equal to s2[i] + m for all 1 <= i <= s1.length for a constant integer m. 

import java.util.*;

public class GroupShiftedStrings {

    public static List<List<String>> groupStrings(String[] arr) {

        // 🔹 Map to store:
        // pattern (key) → list of strings having same pattern
        HashMap<String, List<String>> map = new HashMap<>();

        // 🔁 Traverse each string in input array
        for (String s : arr) {

            // 🧠 Generate key for this string
            // Example: "acd" → "2,1"
            String key = getKey(s);

            // 🔹 If this pattern is seen for first time
            // create a new list for it
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            // 🔹 Add current string into its group
            map.get(key).add(s);
        }

        // 🔹 Return all grouped values
        // map.values() gives all lists
        return new ArrayList<>(map.values());
    }

    // 🔥 Function to generate pattern key for a string
    public static String getKey(String s) {

        // 🔹 Special case:
        // All single character strings belong to same group
        if (s.length() == 1) return "single";

        // This string will store pattern like "2,1"
        String key = "";

        // 🔁 Loop through string characters
        for (int i = 1; i < s.length(); i++) {

            // 🧠 Find difference between current and previous character
            // Example: c - a = 2
            int diff = s.charAt(i) - s.charAt(i - 1);

            // 🔄 Handle circular shift (important!)
            // Example: a - y = -24 → +26 = 2
            if (diff < 0) {
                diff += 26;
            }

            // 🔹 Append this difference to key
            // Example: "2,1,"
            key += diff + ",";
        }

        // 🔹 Return generated pattern
        return key;
    }

    public static void main(String[] args) {

        String[] arr = {
            "acd", "dfg", "wyz", "yab", "mop",
            "bdfh", "a", "x", "moqs"
        };

        // Call function and print result
        List<List<String>> result = groupStrings(arr);

        System.out.println(result);
    }
}