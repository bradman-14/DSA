//Given an array arr[] of n integers where arr[i] represents the number of chocolates in ith packet. Each packet can have a variable number of chocolates. There are m students, the task is to distribute chocolate packets such that: 

//Each student gets exactly one packet.
//The difference between the maximum and minimum number of chocolates in the packets given to the students is minimized.

import java.util.Arrays;

public class chocolate_distribution_problem {
    public static int findMinDiff(int[] arr, int m) {

        if (m == 0 || arr.length == 0)
            return 0;

        Arrays.sort(arr);

        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i + m - 1 < arr.length; i++) {

            int diff = arr[i + m - 1] - arr[i];

            minDiff = Math.min(minDiff, diff);
        }

        return minDiff;
    }

    public static void main(String[] args) {

        int[] arr = {7, 3, 2, 4, 9, 12, 56};
        int m = 3;

        int result = findMinDiff(arr, m);

        System.out.println("Minimum difference: " + result);
    }
}
