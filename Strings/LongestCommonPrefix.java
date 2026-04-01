//Write a function to find the longest common prefix string amongst an array of strings. If there is no common prefix, return an empty string "".
import java.util.Scanner;
public class LongestCommonPrefix {

    public static String findPrefix(String[] strs) {

        // If array is empty → no prefix
        if (strs.length == 0) return "";

        // Assume first string is the prefix initially
        String prefix = strs[0];

        // Loop through remaining strings
        for (int i = 1; i < strs.length; i++) {

            // Keep reducing prefix until current string starts with it
            while (strs[i].indexOf(prefix) != 0) {

                // Remove last character from prefix
                prefix = prefix.substring(0, prefix.length() - 1);

                // If prefix becomes empty → no common prefix
                if (prefix.isEmpty()) return "";
            }
        }

        // Final prefix after checking all strings
        return prefix;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take number of strings
        System.out.print("Enter number of strings: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        String[] arr = new String[n];

        // Input all strings
        System.out.println("Enter strings:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLine();
        }

        // Call function and print result
        String result = findPrefix(arr);
        System.out.println("Longest Common Prefix: " + result);

        sc.close();
    }
}