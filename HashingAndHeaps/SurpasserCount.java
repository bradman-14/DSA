//Given an array of distinct integers arr[], a surpasser of an element arr[i] is any element arr[j] such that j > i and arr[j] > arr[i]. Find the number of surpassers for each element in the array

import java.util.*;

class SurpasserCount {

    // Pair class to store value + original index
    static class Pair {
        int value;
        int index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    // Main function
    public static int[] surpasserCount(int[] arr) {

        int n = arr.length;

        // This array will store the final answer
        // result[i] = number of elements greater than arr[i] on right side
        int[] result = new int[n];

        // Create pair array to track original indices
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(arr[i], i);
        }

        // Apply merge sort
        mergeSort(pairs, 0, n - 1, result);

        return result;
    }

    // Merge sort function (divide step)
    private static void mergeSort(Pair[] arr, int left, int right, int[] result) {

        // Base condition: single element
        if (left >= right) return;

        // Find middle index
        int mid = (left + right) / 2;

        // Recursively sort left half
        mergeSort(arr, left, mid, result);

        // Recursively sort right half
        mergeSort(arr, mid + 1, right, result);

        // Merge both halves and count surpassers
        merge(arr, left, mid, right, result);
    }

    // Merge function (THIS IS WHERE COUNTING HAPPENS)
    private static void merge(Pair[] arr, int left, int mid, int right, int[] result) {

        // Temporary list to store merged result
        List<Pair> temp = new ArrayList<>();

        int i = left;       // pointer for left half
        int j = mid + 1;   // pointer for right half

        // This variable counts how many greater elements
        // from right side have been seen so far
        int rightCount = 0;

        // Traverse both halves
        while (i <= mid && j <= right) {

            // If right element is greater than left element
            if (arr[j].value > arr[i].value) {

                // Found a surpasser
                rightCount++;

                // Add right element to temp
                temp.add(arr[j]);
                j++;

            } else {

                // Add the number of surpassers found so far
                // to this left element
                result[arr[i].index] += rightCount;

                // Add left element to temp
                temp.add(arr[i]);
                i++;
            }
        }

        // Process remaining elements in left half
        while (i <= mid) {

            // All previously counted right elements are greater
            result[arr[i].index] += rightCount;

            temp.add(arr[i]);
            i++;
        }

        // Process remaining elements in right half
        while (j <= right) {
            temp.add(arr[j]);
            j++;
        }

        // Copy merged elements back into original array
        for (int k = 0; k < temp.size(); k++) {
            arr[left + k] = temp.get(k);
        }
    }

    // Driver code to test
    public static void main(String[] args) {

        int[] arr = {4, 3, 5, 1};

        int[] result = surpasserCount(arr);

        // Print result
        System.out.println(Arrays.toString(result));
    }
}