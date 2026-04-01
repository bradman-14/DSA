//Given two strings s and t, return true if t is an anagram of s, and false otherwise.

import java.util.Arrays;
import java.util.Scanner;

public class isAnagram {

    public static boolean isAnagram(String s, String t) {
        // If lengths differ → not anagram
        if (s.length() != t.length()) {
            return false;
        }

        // Convert to char arrays
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();

        // Sort both arrays
        Arrays.sort(a);
        Arrays.sort(b);

        // Compare
        return Arrays.equals(a, b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String s = sc.nextLine();

        System.out.print("Enter second string: ");
        String t = sc.nextLine();

        if (isAnagram(s, t)) {
            System.out.println("Anagram");
        } else {
            System.out.println("Not Anagram");
        }

        sc.close();
    }
}
