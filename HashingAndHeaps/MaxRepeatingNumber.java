// Given an array of size n, find the maximum repeating number in it in O(n) time and O(1) extra space. The elements are in the range from 0 to k-1 where k is a positive integer and k <= n.

package HashingAndHeaps;
public class MaxRepeatingNumber {

    public static int maxRepeating(int arr[], int n, int k) {

        // 🔁 STEP 1: Count frequencies using array itself
        for (int i = 0; i < n; i++) {

            // Get original value (important because values get modified)
            int index = arr[i] % k;

            // Go to that index and add k
            // Meaning: number 'index' appeared once
            arr[index] += k;
        }

        // 🔍 STEP 2: Find index with maximum value
        // aur jis index pe maximum value aayi, wahi index apna answer hua 
        int max = arr[0];   // assume first is max
        int result = 0;     // store index of max

        for (int i = 1; i < n; i++) {

            // If current value is greater → update max
            if (arr[i] > max) {
                max = arr[i];
                result = i;  // index = most frequent number
            }
        }

        // Return the number which appears most
        return result;
    }

    public static void main(String[] args) {

        int arr[] = {1, 2, 2, 2, 0, 2, 0, 2, 3, 8, 0, 9, 2, 3};
        int n = arr.length;
        int k = 10;

        int ans = maxRepeating(arr, n, k);

        System.out.println("Maximum repeating number = " + ans);
    }
}