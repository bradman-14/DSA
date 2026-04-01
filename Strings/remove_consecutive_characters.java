//Given a string s, remove the consecutive characters that are the same and return the resulting string.

import java.util.Scanner;
public class remove_consecutive_characters{
    public static String Remove_consecutive_characters(String s) {
        String result = "";

        // First character always included
        result += s.charAt(0);

        for (int i = 1; i < s.length(); i++) {
            // Add only if different from previous
            if (s.charAt(i) != s.charAt(i - 1)) {
                result += s.charAt(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String s = sc.nextLine();

        String ans = Remove_consecutive_characters(s);
        System.out.println("Result: " + ans);

        sc.close();
    }
}

