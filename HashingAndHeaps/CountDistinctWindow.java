// Given an array of integers and a number k, find the count of distinct elements in every window of size k in the array.

import java.util.*;

public class CountDistinctWindow {

    public static List<Integer> countDistinct(int[] arr, int k) {

        // Map will store:
        // element → how many times it appears in current window
        HashMap<Integer, Integer> map = new HashMap<>();

        // List to store final answers
        List<Integer> result = new ArrayList<>();

        // STEP 1: Process first window
        for (int i = 0; i < k; i++) {

            // If element already exists → increase frequency
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } 
            else {
                // If new element → insert with frequency 1
                map.put(arr[i], 1);
            }
        }

        // Store distinct count of first window
        result.add(map.size());

        // STEP 2: Slide the window
        for (int i = k; i < arr.length; i++) {

            //  Element going OUT of window
            int left = arr[i - k];

            //  **IMPORTANT LOGIC**
            // If frequency is 1 → this was last occurrence → remove completely
            if (map.get(left) == 1) {
                map.remove(left);
            } 
            else {
                // If more occurrences exist → just decrease frequency
                map.put(left, map.get(left) - 1);
            }

            //  Element coming INTO window
            int right = arr[i];

            // Increase frequency or insert new element
            if (map.containsKey(right)) {
                map.put(right, map.get(right) + 1);
            } 
            else {
                map.put(right, 1);
            }

            // Store number of distinct elements
            result.add(map.size());
        }

        return result;
    }

    public static void main(String[] args) {

        int arr[] = {1, 2,1, 3, 4, 2, 3};
        int k = 3;

        System.out.println(countDistinct(arr, k));
    }
}