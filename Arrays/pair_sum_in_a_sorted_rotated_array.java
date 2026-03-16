//Given an array arr[] of size n, which is sorted and then rotated around an unknown pivot,
//the task is to check whether there exists a pair of elements in the array whose sum is equal to a given target value.
public class pair_sum_in_a_sorted_rotated_array{
    public static boolean pairSum(int[] arr, int target) {

        int n = arr.length;

        // Step 1: Find pivot (where array rotation happened)
        int pivot = -1;

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                pivot = i;
                break;
            }
        }

        /*
        Example:
        arr = [11,15,6,8,9,10]

        pivot = 1 (because 15 > 6)

        smallest element index = pivot + 1 = 2
        largest element index = pivot = 1
        */

        int left = (pivot + 1) % n;  // smallest element
        int right = pivot;           // largest element

        // Step 2: Use two pointer technique
        while (left != right) {

            int sum = arr[left] + arr[right];

            /*
            Case 1: If sum equals target
            */
            if (sum == target) {
                return true;
            }

            /*
            Case 2: If sum is smaller than target
            move left pointer forward
            (increase sum)
            */
            else if (sum < target) {
                left = (left + 1) % n;
            }

            /*
            Case 3: If sum is greater than target
            move right pointer backward
            (decrease sum)
            */
            else {
                right = (n + right - 1) % n;
            }
        }

        // If no pair found
        return false;
    }

    public static void main(String[] args) {

        int arr[] = {11, 15, 6, 8, 9, 10};
        int target = 16;

        boolean result = pairSum(arr, target);

        System.out.println("Pair exists: " + result);
    }
}
